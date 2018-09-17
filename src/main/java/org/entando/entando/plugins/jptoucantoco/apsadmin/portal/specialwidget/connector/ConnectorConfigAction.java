/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptoucantoco.apsadmin.portal.specialwidget.connector;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.agiletec.apsadmin.portal.specialwidget.SimpleWidgetConfigAction;

public class ConnectorConfigAction extends SimpleWidgetConfigAction {

	private static final Logger _logger =  LoggerFactory.getLogger(ConnectorConfigAction.class);
	
	protected String extractInitConfig() {
		String result = super.extractInitConfig();
		String id = this.getWidget().getConfig().getProperty("id");
		String secret = this.getWidget().getConfig().getProperty("secret");
		String username = this.getWidget().getConfig().getProperty("username");
		String url = this.getWidget().getConfig().getProperty("url");
		String debug = this.getWidget().getConfig().getProperty("debug");
		
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
		if (StringUtils.isNotBlank(debug)) {
			this.setDebug(Boolean.valueOf(debug));
		} else {
			this.setDebug(false);
		}
		return result;
	}
	
	public int getId() {
		return _id;
	}
	public void setId(int id) {
		this._id = id;
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

	public boolean isDebug() {
		return _debug;
	}

	public void setDebug(boolean debug) {
		this._debug = debug;
	}

	private int _id;
	private String _secret;
	private String _username;
	private String _url;
	private boolean _debug;
}
