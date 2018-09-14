/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptoucantoco.aps.system.services.connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import com.agiletec.aps.system.common.AbstractSearcherDAO;
import com.agiletec.aps.system.common.FieldSearchFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectorDAO extends AbstractSearcherDAO implements IConnectorDAO {

	private static final Logger logger =  LoggerFactory.getLogger(ConnectorDAO.class);

    @Override
    public int countConnectors(FieldSearchFilter[] filters) {
        Integer connectors = null;
        try {
            connectors = super.countId(filters);
        } catch (Throwable t) {
            logger.error("error in count connectors", t);
            throw new RuntimeException("error in count connectors", t);
        }
        return connectors;
    }

	@Override
	protected String getTableFieldName(String metadataFieldKey) {
		return metadataFieldKey;
	}
	
	@Override
	protected String getMasterTableName() {
		return "jptoucantoco_connector";
	}
	
	@Override
	protected String getMasterTableIdFieldName() {
		return "id";
	}

	@Override
	public List<Integer> searchConnectors(FieldSearchFilter[] filters) {
		List connectorsId = null;
		try {
			connectorsId  = super.searchId(filters);
		} catch (Throwable t) {
			logger.error("error in searchConnectors",  t);
			throw new RuntimeException("error in searchConnectors", t);
		}
		return connectorsId;
	}

	@Override
	public List<Integer> loadConnectors() {
		List<Integer> connectorsId = new ArrayList<Integer>();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		try {
			conn = this.getConnection();
			stat = conn.prepareStatement(LOAD_CONNECTORS_ID);
			res = stat.executeQuery();
			while (res.next()) {
				int id = res.getInt("id");
				connectorsId.add(id);
			}
		} catch (Throwable t) {
			logger.error("Error loading Connector list",  t);
			throw new RuntimeException("Error loading Connector list", t);
		} finally {
			closeDaoResources(res, stat, conn);
		}
		return connectorsId;
	}
	
	@Override
	public void insertConnector(Connector connector) {
		PreparedStatement stat = null;
		Connection conn  = null;
		try {
			conn = this.getConnection();
			conn.setAutoCommit(false);
			this.insertConnector(connector, conn);
 			conn.commit();
		} catch (Throwable t) {
			this.executeRollback(conn);
			logger.error("Error on insert connector",  t);
			throw new RuntimeException("Error on insert connector", t);
		} finally {
			this.closeDaoResources(null, stat, conn);
		}
	}

	public void insertConnector(Connector connector, Connection conn) {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(ADD_CONNECTOR);
			int index = 1;
			stat.setInt(index++, connector.getId());
 			stat.setString(index++, connector.getName());
			stat.executeUpdate();
		} catch (Throwable t) {
			logger.error("Error on insert connector",  t);
			throw new RuntimeException("Error on insert connector", t);
		} finally {
			this.closeDaoResources(null, stat, null);
		}
	}

	@Override
	public void updateConnector(Connector connector) {
		PreparedStatement stat = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			conn.setAutoCommit(false);
			this.updateConnector(connector, conn);
 			conn.commit();
		} catch (Throwable t) {
			this.executeRollback(conn);
			logger.error("Error updating connector {}", connector.getId(),  t);
			throw new RuntimeException("Error updating connector", t);
		} finally {
			this.closeDaoResources(null, stat, conn);
		}
	}

	public void updateConnector(Connector connector, Connection conn) {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(UPDATE_CONNECTOR);
			int index = 1;

 			stat.setString(index++, connector.getName());
			stat.setInt(index++, connector.getId());
			stat.executeUpdate();
		} catch (Throwable t) {
			logger.error("Error updating connector {}", connector.getId(),  t);
			throw new RuntimeException("Error updating connector", t);
		} finally {
			this.closeDaoResources(null, stat, null);
		}
	}

	@Override
	public void removeConnector(int id) {
		PreparedStatement stat = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			conn.setAutoCommit(false);
			this.removeConnector(id, conn);
 			conn.commit();
		} catch (Throwable t) {
			this.executeRollback(conn);
			logger.error("Error deleting connector {}", id, t);
			throw new RuntimeException("Error deleting connector", t);
		} finally {
			this.closeDaoResources(null, stat, conn);
		}
	}
	
	public void removeConnector(int id, Connection conn) {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(DELETE_CONNECTOR);
			int index = 1;
			stat.setInt(index++, id);
			stat.executeUpdate();
		} catch (Throwable t) {
			logger.error("Error deleting connector {}", id, t);
			throw new RuntimeException("Error deleting connector", t);
		} finally {
			this.closeDaoResources(null, stat, null);
		}
	}

	public Connector loadConnector(int id) {
		Connector connector = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		try {
			conn = this.getConnection();
			connector = this.loadConnector(id, conn);
		} catch (Throwable t) {
			logger.error("Error loading connector with id {}", id, t);
			throw new RuntimeException("Error loading connector with id " + id, t);
		} finally {
			closeDaoResources(res, stat, conn);
		}
		return connector;
	}

	public Connector loadConnector(int id, Connection conn) {
		Connector connector = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		try {
			stat = conn.prepareStatement(LOAD_CONNECTOR);
			int index = 1;
			stat.setInt(index++, id);
			res = stat.executeQuery();
			if (res.next()) {
				connector = this.buildConnectorFromRes(res);
			}
		} catch (Throwable t) {
			logger.error("Error loading connector with id {}", id, t);
			throw new RuntimeException("Error loading connector with id " + id, t);
		} finally {
			closeDaoResources(res, stat, null);
		}
		return connector;
	}

	protected Connector buildConnectorFromRes(ResultSet res) {
		Connector connector = null;
		try {
			connector = new Connector();				
			connector.setId(res.getInt("id"));
			connector.setName(res.getString("name"));
		} catch (Throwable t) {
			logger.error("Error in buildConnectorFromRes", t);
		}
		return connector;
	}

	private static final String ADD_CONNECTOR = "INSERT INTO jptoucantoco_connector (id, name ) VALUES (?, ? )";

	private static final String UPDATE_CONNECTOR = "UPDATE jptoucantoco_connector SET name=? WHERE id = ?";

	private static final String DELETE_CONNECTOR = "DELETE FROM jptoucantoco_connector WHERE id = ?";
	
	private static final String LOAD_CONNECTOR = "SELECT id, name  FROM jptoucantoco_connector WHERE id = ?";
	
	private static final String LOAD_CONNECTORS_ID  = "SELECT id FROM jptoucantoco_connector";
	
}