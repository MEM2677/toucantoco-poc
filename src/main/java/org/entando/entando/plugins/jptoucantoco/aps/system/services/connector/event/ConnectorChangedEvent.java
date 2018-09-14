/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptoucantoco.aps.system.services.connector.event;

import com.agiletec.aps.system.common.IManager;
import com.agiletec.aps.system.common.notify.ApsEvent;
import org.entando.entando.plugins.jptoucantoco.aps.system.services.connector.Connector;


public class ConnectorChangedEvent extends ApsEvent {
	
	@Override
	public void notify(IManager srv) {
		((ConnectorChangedObserver) srv).updateFromConnectorChanged(this);
	}
	
	@Override
	public Class getObserverInterface() {
		return ConnectorChangedObserver.class;
	}
	
	public int getOperationCode() {
		return _operationCode;
	}
	public void setOperationCode(int operationCode) {
		this._operationCode = operationCode;
	}
	
	public Connector getConnector() {
		return _connector;
	}
	public void setConnector(Connector connector) {
		this._connector = connector;
	}

	private Connector _connector;
	private int _operationCode;
	
	public static final int INSERT_OPERATION_CODE = 1;
	public static final int REMOVE_OPERATION_CODE = 2;
	public static final int UPDATE_OPERATION_CODE = 3;

}
