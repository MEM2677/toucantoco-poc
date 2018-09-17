
INSERT INTO widgetcatalog (code, titles, parameters, plugincode, parenttypecode, defaultconfig, locked, maingroup) VALUES ('jptoucantocoConnector', '<?xml version="1.0" encoding="UTF-8"?>
<properties>
<property key="en">Toucan Toco Connector</property>
<property key="it">Connectore Toucan Toco</property>
</properties>', '<config>
	<parameter name="secret">secret</parameter>
	<parameter name="username">username</parameter>
	<parameter name="url">url</parameter>
	<parameter name="debug">true</parameter>
	<action name="jptoucantocoConnectorConfig"/>
</config>','jptoucantoco', NULL, NULL, 1, 'free');


