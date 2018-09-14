/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptoucantoco.apsadmin.portal.specialwidget.connector;

import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.agiletec.aps.system.services.lang.Lang;
import com.agiletec.apsadmin.portal.specialwidget.SimpleWidgetConfigAction;
import org.entando.entando.plugins.jptoucantoco.aps.system.services.connector.IConnectorManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectorConfigAction extends SimpleWidgetConfigAction {

	private static final Logger _logger =  LoggerFactory.getLogger(ConnectorConfigAction.class);
	
	protected String extractInitConfig() {
		String result = super.extractInitConfig();
		String id = this.getWidget().getConfig().getProperty("id");
		String secret = this.getWidget().getConfig().getProperty("secret");
		String username = this.getWidget().getConfig().getProperty("username");
		String url = this.getWidget().getConfig().getProperty("url");
		
		if (StringUtils.isNotBlank(id)) {
			this.setId(new Integer(id));
		}
		if (StringUtils.isNotBlank(secret)) {
			this.setSecret(secret);
		}
		if (StringUtils.isNotBlank(username)) {
			this.setUsername(username);
		}
		if (StringUtils.isNotBlank(url)) {
			this.setUrl(url);
		}
		return result;
	}

	public List<Integer> getConnectorsId() {
		try {
			List<Integer> connectors = Arrays.asList(new Integer[] {2677});
			return connectors;
		} catch (Throwable t) {
			_logger.error("error in getConnectorsId", t);
			throw new RuntimeException("Error getting connectors list", t);
		}
	}
	
	public int getId() {
		return _id;
	}
	public void setId(int id) {
		this._id = id;
	}

	protected IConnectorManager getConnectorManager() {
		return _connectorManager;
	}
	public void setConnectorManager(IConnectorManager connectorManager) {
		this._connectorManager = connectorManager;
	}

	public String getSecret() {
		return _secret;
	}

	public void setSecret(String secret) {
		this._secret = secret;
	}

	public String getUsername() {
		return _username;
	}

	public void setUsername(String username) {
		this._username = username;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		this._url = url;
	}

	private int _id;
	private String _secret;
	private String _username;
	private String _url;
	
	private IConnectorManager _connectorManager;
}

