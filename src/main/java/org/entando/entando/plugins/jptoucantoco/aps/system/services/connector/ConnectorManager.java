/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptoucantoco.aps.system.services.connector;

import org.entando.entando.plugins.jptoucantoco.aps.system.services.connector.event.ConnectorChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.agiletec.aps.system.common.FieldSearchFilter;
import com.agiletec.aps.system.common.AbstractService;
import com.agiletec.aps.system.exception.ApsSystemException;
import com.agiletec.aps.system.services.keygenerator.IKeyGeneratorManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.agiletec.aps.system.common.model.dao.SearcherDaoPaginatedResult;

public class ConnectorManager extends AbstractService implements IConnectorManager {

	private static final Logger logger =  LoggerFactory.getLogger(ConnectorManager.class);

	@Override
	public void init() throws Exception {
		logger.debug("{} ready.", this.getClass().getName());
	}
 
	@Override
	public Connector getConnector(int id) throws ApsSystemException {
		Connector connector = null;
		try {
			connector = this.getConnectorDAO().loadConnector(id);
		} catch (Throwable t) {
			logger.error("Error loading connector with id '{}'", id,  t);
			throw new ApsSystemException("Error loading connector with id: " + id, t);
		}
		return connector;
	}

	@Override
	public List<Integer> getConnectors() throws ApsSystemException {
		List<Integer> connectors = new ArrayList<Integer>();
		try {
			connectors = this.getConnectorDAO().loadConnectors();
		} catch (Throwable t) {
			logger.error("Error loading Connector list",  t);
			throw new ApsSystemException("Error loading Connector ", t);
		}
		return connectors;
	}

	@Override
	public List<Integer> searchConnectors(FieldSearchFilter filters[]) throws ApsSystemException {
		List<Integer> connectors = new ArrayList<Integer>();
		try {
			connectors = this.getConnectorDAO().searchConnectors(filters);
		} catch (Throwable t) {
			logger.error("Error searching Connectors", t);
			throw new ApsSystemException("Error searching Connectors", t);
		}
		return connectors;
	}

	@Override
	public void addConnector(Connector connector) throws ApsSystemException {
		try {
			int key = this.getKeyGeneratorManager().getUniqueKeyCurrentValue();
			connector.setId(key);
			this.getConnectorDAO().insertConnector(connector);
			this.notifyConnectorChangedEvent(connector, ConnectorChangedEvent.INSERT_OPERATION_CODE);
		} catch (Throwable t) {
			logger.error("Error adding Connector", t);
			throw new ApsSystemException("Error adding Connector", t);
		}
	}
 
	@Override
	public void updateConnector(Connector connector) throws ApsSystemException {
		try {
			this.getConnectorDAO().updateConnector(connector);
			this.notifyConnectorChangedEvent(connector, ConnectorChangedEvent.UPDATE_OPERATION_CODE);
		} catch (Throwable t) {
			logger.error("Error updating Connector", t);
			throw new ApsSystemException("Error updating Connector " + connector, t);
		}
	}

	@Override
	public void deleteConnector(int id) throws ApsSystemException {
		try {
			Connector connector = this.getConnector(id);
			this.getConnectorDAO().removeConnector(id);
			this.notifyConnectorChangedEvent(connector, ConnectorChangedEvent.REMOVE_OPERATION_CODE);
		} catch (Throwable t) {
			logger.error("Error deleting Connector with id {}", id, t);
			throw new ApsSystemException("Error deleting Connector with id:" + id, t);
		}
	}


	private void notifyConnectorChangedEvent(Connector connector, int operationCode) {
		ConnectorChangedEvent event = new ConnectorChangedEvent();
		event.setConnector(connector);
		event.setOperationCode(operationCode);
		this.notifyEvent(event);
	}

    @SuppressWarnings("rawtypes")
    public SearcherDaoPaginatedResult<Connector> getConnectors(FieldSearchFilter[] filters) throws ApsSystemException {
        SearcherDaoPaginatedResult<Connector> pagedResult = null;
        try {
            List<Connector> connectors = new ArrayList<>();
            int count = this.getConnectorDAO().countConnectors(filters);

            List<Integer> connectorNames = this.getConnectorDAO().searchConnectors(filters);
            for (Integer connectorName : connectorNames) {
                connectors.add(this.getConnector(connectorName));
            }
            pagedResult = new SearcherDaoPaginatedResult<Connector>(count, connectors);
        } catch (Throwable t) {
            logger.error("Error searching connectors", t);
            throw new ApsSystemException("Error searching connectors", t);
        }
        return pagedResult;
    }

    @Override
    public SearcherDaoPaginatedResult<Connector> getConnectors(List<FieldSearchFilter> filters) throws ApsSystemException {
        FieldSearchFilter[] array = null;
        if (null != filters) {
            array = filters.toArray(new FieldSearchFilter[filters.size()]);
        }
        return this.getConnectors(array);
    }


	protected IKeyGeneratorManager getKeyGeneratorManager() {
		return _keyGeneratorManager;
	}
	public void setKeyGeneratorManager(IKeyGeneratorManager keyGeneratorManager) {
		this._keyGeneratorManager = keyGeneratorManager;
	}

	public void setConnectorDAO(IConnectorDAO connectorDAO) {
		 this._connectorDAO = connectorDAO;
	}
	protected IConnectorDAO getConnectorDAO() {
		return _connectorDAO;
	}

	private IKeyGeneratorManager _keyGeneratorManager;
	private IConnectorDAO _connectorDAO;
}
