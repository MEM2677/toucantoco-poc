/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptoucantoco.aps.system.services.connector;

import java.util.List;
import com.agiletec.aps.system.exception.ApsSystemException;
import com.agiletec.aps.system.common.model.dao.SearcherDaoPaginatedResult;

import com.agiletec.aps.system.common.FieldSearchFilter;

public interface IConnectorManager {

	public Connector getConnector(int id) throws ApsSystemException;

	public List<Integer> getConnectors() throws ApsSystemException;

	public List<Integer> searchConnectors(FieldSearchFilter filters[]) throws ApsSystemException;

	public void addConnector(Connector connector) throws ApsSystemException;

	public void updateConnector(Connector connector) throws ApsSystemException;

	public void deleteConnector(int id) throws ApsSystemException;

	public SearcherDaoPaginatedResult<Connector> getConnectors(List<FieldSearchFilter> fieldSearchFilters) throws ApsSystemException;
}