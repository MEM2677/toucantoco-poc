/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptoucantoco.aps.system.services.connector;

import java.util.List;

import com.agiletec.aps.system.common.FieldSearchFilter;

public interface IConnectorDAO {

	public List<Integer> searchConnectors(FieldSearchFilter[] filters);
	
	public Connector loadConnector(int id);

	public List<Integer> loadConnectors();

	public void removeConnector(int id);
	
	public void updateConnector(Connector connector);

	public void insertConnector(Connector connector);

    public int countConnectors(FieldSearchFilter[] filters);
}