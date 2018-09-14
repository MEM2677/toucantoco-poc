/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptoucantoco.aps.system.services.connector.event;

import com.agiletec.aps.system.common.notify.ObserverService;

public interface ConnectorChangedObserver extends ObserverService {
	
	public void updateFromConnectorChanged(ConnectorChangedEvent event);
	
}
