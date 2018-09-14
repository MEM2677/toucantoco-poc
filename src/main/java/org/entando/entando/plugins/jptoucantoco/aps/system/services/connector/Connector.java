/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptoucantoco.aps.system.services.connector;



public class Connector {

	public int getId() {
		return _id;
	}
	public void setId(int id) {
		this._id = id;
	}

	public String getName() {
		return _name;
	}
	public void setName(String name) {
		this._name = name;
	}

	
	private int _id;
	private String _name;

}
