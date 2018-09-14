/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptoucantoco.aps.system.init.servdb;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = Connector.TABLE_NAME)
public class Connector {
	
	public Connector() {}
	
	@DatabaseField(columnName = "id", 
		dataType = DataType.INTEGER, 
		 canBeNull=false, id = true)
	private int _id;
	
	@DatabaseField(columnName = "name", 
		dataType = DataType.LONG_STRING,
		 canBeNull=false)
	private String _name;
	

public static final String TABLE_NAME = "jptoucantoco_connector";
}
