/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptoucantoco.aps.system.services;

import org.entando.entando.plugins.jptoucantoco.aps.JptoucantocoBaseTestCase;
import org.entando.entando.plugins.jptoucantoco.aps.system.services.connector.IConnectorManager;

public class TestConnectorManager extends JptoucantocoBaseTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.init();
	}
	
	public void testGetConnector() {
		//TODO complete test
		assertNotNull(this._connectorManager);
	}

	public void testGetConnectors() {
		//TODO complete test
		assertNotNull(this._connectorManager);
	}
	
	public void testSearchConnectors() {
		//TODO complete test
		assertNotNull(this._connectorManager);
	}

	public void testAddConnector() {
		//TODO complete test
		assertNotNull(this._connectorManager);
	}

	public void testUpdateConnector() {
		//TODO complete test
		assertNotNull(this._connectorManager);
	}

	public void testDeleteConnector() {
		//TODO complete test
		assertNotNull(this._connectorManager);
	}
	
	private void init() {
		//TODO add the spring bean id as constant
		this._connectorManager = (IConnectorManager) this.getService("jptoucantocoConnectorManager");
	}
	
	private IConnectorManager _connectorManager;
}

