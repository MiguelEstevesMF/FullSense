package test;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import java.util.HashSet;


import plugins.sessionBeans.BehaviorBean;
import plugins.sessionBeans.interfaces.BehaviorBeanRemote;
import plugins.util.Pair;
import plugins.entityBeans.Behavior;
import plugins.entityBeans.Bundle;
import plugins.entityBeans.Method;

import core.sessionBeans.UserBean;
import core.sessionBeans.interfaces.UserBeanRemote;
//import fullsense.protocol.message.FSMessage;
import fullsense.protocol.message.FSMessage;



public class BundlePopulateData {

	static public final String ACTION_NAME = "_ACTION_NAME"; 
	static public final String TYPE = "_TYPE";
	static public final String MESAGE = "_MESSAGE"; 
	static public final String DEVICE_TYPE = "_DEVICE_TYPE";
	static public final String DEVICE_ID = "_DEVICE_ID";
	static public final String USER_ID = "_USER_ID"; 
	static public final String GROUP_ID = "_GROUP_ID";
	static public final String TIME = "_TIME"; 
	static public final String LOCATION = "_LOCATION";
	static public final String TRANSACTION_NUMBER = "_TRANSACTION_NUMBER";
	static public final String IP_ADDRESS = "_IP_ADDRESS";
	static public final String PORT_ADDRESS = "_PORT_ADDRESS";
	static public final String EVENT_LOG = "_EVENT_LOG";
	static public final String RESULT = "_RESULT";
	static public final String FLOOR  = "_FLOOR";
	
	static public final String ID = "ID";
	static public final String GROUP = "GROUP";
	static public final String UNDEFINED = "UNDEFINED";
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
	//	UserBeanRemote ubr = (UserBeanRemote)MyInjector.getEJBr(UserBean.class);
	//	CrudBeanRemote cb = (CrudBeanRemote)MyInjector.getEJBr(CrudBean.class);
		BehaviorBeanRemote bb = (BehaviorBeanRemote)MyInjector.getEJBr(BehaviorBean.class);
		
		
		

		
		//new Behavior(10,101,0,"#"+FSMessage.DEVICE_TYPE+":String:equalsString:String:bluetooth#",111,"#"+FSMessage.TIME+":Long:30#"), 
		//new Behavior(10,101,0,"#"+FSMessage.DEVICE_TYPE+":String:equalsString:String:rfid#",111,"#"+FSMessage.TIME+":Long:30#")};
		
		
	/**
	**WEB SERVICE BUNDLE 1 # 1
	**/
	Bundle webServiceBundle = new Bundle();
	webServiceBundle.setName("WebUtilities");
	webServiceBundle.setDescription("A bundle that contains several methods to be used by the web components. Here we can find:" +
			"<br>  listDevices: a method that allows the user to retreive all devices from a certain type detected in the next t time.");
	webServiceBundle.setUrl("file://bundleLocation");
	webServiceBundle.setProperties(new Hashtable<String, String>());
	
	//Bundle methods
	Method listDevices =  new Method();
	listDevices.setBundle(webServiceBundle);
	listDevices.setName("scanDevices");
	listDevices.setDescription("a method that allows the user to retreive all devices from a certain type detected in the next t time");
	//method parameters 
	Map<String,Pair> listDevices_parameters =  new TreeMap<String, Pair>();
	Pair p = new Pair("String", false);
	//cb.save(p);
	listDevices_parameters.put(DEVICE_TYPE, p);
	listDevices.setParameters(listDevices_parameters);
	listDevices.setModifier(UNDEFINED);
	
	
	Map<String,String> exitValues =  new TreeMap<String, String>();
	exitValues.put(DEVICE_TYPE,"String");
	listDevices.setExitValues(exitValues);
	//cb.save(listDevices);
	Set<Method> webActionMethods = new HashSet<Method>();
	webActionMethods.add(listDevices);
	webServiceBundle.setActions(webActionMethods);	
	bb.create(webServiceBundle);
	//cb.save(webServiceBundle);
	
	
	/**
	**BLUETOOTH SERVICE BUNDLE 2 # 2
	**/
	Bundle bluetoothServiceBundle = new Bundle();
	bluetoothServiceBundle.setName("BluetoothService");
	bluetoothServiceBundle.setDescription("A bundle that contains methods to deal with the bluetooth device");
	bluetoothServiceBundle.setUrl("file://bundleLocation");
	
	//Bundle methods
	Method scanDevices  =  new Method();
	scanDevices.setBundle(bluetoothServiceBundle);
	scanDevices.setName("scanDevices");
	scanDevices.setDescription("a method that allows the user to retreive all devices from a certain type detected in the next t time");
	//method parameters 
	Map<String,Pair> scanDevices_parameters =  new TreeMap<String, Pair>();
	Pair p2 = new Pair("Long", false);
	//cb.save(p2);
	Pair p3 = new Pair("Long", true);
	//cb.save(p3);
	
	scanDevices_parameters.put(TRANSACTION_NUMBER, p2);
	scanDevices_parameters.put(TIME, p3);
	scanDevices.setParameters(scanDevices_parameters);
	scanDevices.setModifier(UNDEFINED);
	
	Map<String,String> scan_exitValues =  new TreeMap<String, String>();
	scanDevices.setExitValues(scan_exitValues);
	
	Set<Method> bluetoothMethods = new HashSet<Method>();
	bluetoothMethods.add(scanDevices);
	bluetoothServiceBundle.setActions(bluetoothMethods);
	
	//cb.save(scanDevices);
	bb.create(bluetoothServiceBundle);
//	cb.save(bluetoothServiceBundle);

	/**
	**BEHAVIOR BUNDLE 3 #
	**/	
	
	Bundle behaviorServiceBundle = new Bundle();
	behaviorServiceBundle.setUrl("file://bundleLocation");
	behaviorServiceBundle.setName("BehaviorControler");
	behaviorServiceBundle.setDescription("INTERNAL!!! NOT FOR USE: Behavior controler inside the core");
	behaviorServiceBundle.setProperties(new Hashtable<String, String>());
	behaviorServiceBundle.setActions(new HashSet<Method>());
	
	bb.create(behaviorServiceBundle);
	//cb.save(behaviorServiceBundle);
	
	/**
	**STORING TABLE BUNDLE 4 #
	**/
	
	Bundle infoTableBundle =  new Bundle();
	infoTableBundle.setName("StoringTableService");
	infoTableBundle.setUrl("file://bundleLocation");
	infoTableBundle.setDescription("INTERNAL!!! NOT FOR USE: Storing service inside the platform");
	infoTableBundle.setProperties(new Hashtable<String, String>());
	infoTableBundle.setActions(new HashSet<Method>());
	
	//cb.save(infoTableBundle);
	bb.create(infoTableBundle);
	
	/**
	**DATA SOURCE BUNDLE 5 #
	**/	 
	
	Bundle dataSourceBundle =  new Bundle();
	dataSourceBundle.setUrl("file://bundleLocation");
	dataSourceBundle.setName("DataSource");
	dataSourceBundle.setDescription("INTERNAL!!! NOT FOR USE: Data base bridge");
	dataSourceBundle.setProperties(new Hashtable<String, String>());
	dataSourceBundle.setActions(new HashSet<Method>());
	
	//cb.save(dataSourceBundle);
	bb.create(dataSourceBundle);
	
	/**
	**BLUETOOTH SENSOR 6 # 3
	**/
	
	Bundle bluetoothSensorBundle = new Bundle();
	bluetoothSensorBundle.setName("BluetoothSensor");
	bluetoothSensorBundle.setDescription("A bundle that contains methods associated withe the information that comes from the sensor.");
	bluetoothSensorBundle.setUrl("file://bundleLocation");
	
	//Bundle methods
	Method bluetoothEvent  =  new Method();
	bluetoothEvent.setBundle(bluetoothSensorBundle);
	bluetoothEvent.setName("Event");
	bluetoothEvent.setDescription("The triggered method upon sensor event");
	//method parameters 
	Map<String,Pair> bluetoothEvent_parameters =  new TreeMap<String, Pair>();
	Pair bp2 = new Pair("String", false);
	//cb.save(p2);
	Pair bp3 = new Pair("String", false);
	//cb.save(p3);
	Pair bp4 = new Pair("String", false);
	Pair bp5 = new Pair("String", false);
	
	 bluetoothEvent_parameters.put(USER_ID, bp2);
	 bluetoothEvent_parameters.put(DEVICE_ID, bp3);
	 bluetoothEvent_parameters.put(MESAGE, bp4);
	 bluetoothEvent_parameters.put(TIME, bp5);
	 bluetoothEvent.setParameters(bluetoothEvent_parameters);
	 bluetoothEvent.setModifier(UNDEFINED);
	
	Map<String,String> bluetoothEvent_exitValues =  new TreeMap<String, String>();
	bluetoothEvent_exitValues.put(USER_ID, "String");
	bluetoothEvent_exitValues.put(DEVICE_ID, "String");
	bluetoothEvent_exitValues.put(TIME, "String");
	bluetoothEvent_exitValues.put(MESAGE, "String");
	bluetoothEvent_exitValues.put(LOCATION, "String");
	bluetoothEvent_exitValues.put(FLOOR, "Integer");
	bluetoothEvent_exitValues.put(DEVICE_TYPE, "String");
	
	bluetoothEvent.setExitValues(bluetoothEvent_exitValues);
	
	Set<Method> bluetoothSensorMethods = new HashSet<Method>();
	bluetoothSensorMethods.add(bluetoothEvent);
	bluetoothSensorBundle.setActions(bluetoothSensorMethods);
	
	//cb.save(scanDevices);
	bb.create(bluetoothSensorBundle);
//	cb.save(bluetoothServiceBundle);


	/**
	**RFID SENSOR 7 # 4
	**/

	Bundle RFIDSensorBundle =  new Bundle();
	RFIDSensorBundle.setName("RFIDSensor");
	RFIDSensorBundle.setDescription("A bundle that contains methods associated withe the information that comes from the sensor.");
	RFIDSensorBundle.setUrl("file://bundleLocation");
	
	//RFID methods
	Method RFIDEvent  =  new Method();
	RFIDEvent.setBundle(RFIDSensorBundle);
	RFIDEvent.setName("Event");
	RFIDEvent.setDescription("The triggered method upon sensor event");
	//method parameters 
	Map<String,Pair> RFIDEventParameters =  new TreeMap<String, Pair>();
	Pair rfidp1 =  new Pair("String", false);
	Pair rfidp2 =  new Pair("String", false);
	Pair rfidp3 =  new Pair("String", false);
	Pair rfidp4 =  new Pair("String", false);
	RFIDEventParameters.put(USER_ID, rfidp1);
	RFIDEventParameters.put(DEVICE_ID, rfidp2);
	RFIDEventParameters.put(MESAGE, rfidp3);
	RFIDEventParameters.put(TIME, rfidp4);
	RFIDEvent.setParameters(RFIDEventParameters);
	RFIDEvent.setModifier(UNDEFINED);
	
	Map<String,String> RFIDEvent_exitValues =  new TreeMap<String, String>();
	RFIDEvent_exitValues.put(USER_ID, "String");
	RFIDEvent_exitValues.put(DEVICE_ID, "String");
	RFIDEvent_exitValues.put(TIME, "String");
	RFIDEvent_exitValues.put(MESAGE, "String");
	RFIDEvent_exitValues.put(LOCATION, "String");
	RFIDEvent_exitValues.put(FLOOR, "Integer");
	RFIDEvent_exitValues.put(DEVICE_TYPE, "String");
	RFIDEvent.setExitValues(RFIDEvent_exitValues);
	
	Set<Method> RFIDSensorMethods =  new HashSet<Method>();
	RFIDSensorMethods.add(RFIDEvent);
	RFIDSensorBundle.setActions(RFIDSensorMethods);
	
	bb.create(RFIDSensorBundle);


	/**
	**BIOMETRIC SENSOR 8 # 5
	**/

	
	Bundle BiometricSensor= new Bundle();
	BiometricSensor.setName("BiometricSensor");
	BiometricSensor.setDescription("A bundle that contains methods to deal with tthe bluetooth device");
	BiometricSensor.setUrl("file://bundleLocation");

	Method BiometricSensor_Event = new Method();
	BiometricSensor_Event.setName("Event");
	BiometricSensor_Event.setDescription("The triggered method upon sensor event");
	BiometricSensor_Event.setBundle(BiometricSensor);

	Map<String,Pair> BiometricSensor_EventParameters =  new TreeMap<String, Pair>();
	Pair BiometricSensor_Event0 = new Pair("String",false);
	BiometricSensor_EventParameters.put(USER_ID,BiometricSensor_Event0);
	Pair BiometricSensor_Event1 = new Pair("String",false);
	BiometricSensor_EventParameters.put(DEVICE_ID,BiometricSensor_Event1);
	
	Pair BiometricSensor_Event2 = new Pair("String",false);
	BiometricSensor_EventParameters.put(TIME,BiometricSensor_Event2);
	Pair BiometricSensor_Event3 = new Pair("String",false);
	BiometricSensor_EventParameters.put(MESAGE,BiometricSensor_Event3);
	
	BiometricSensor_Event.setParameters(BiometricSensor_EventParameters);
	BiometricSensor_Event.setModifier(UNDEFINED);

	Map<String,String> BiometricSensor_EventexitValues =  new TreeMap<String, String>();
	BiometricSensor_EventexitValues.put(DEVICE_ID,"String");
	BiometricSensor_EventexitValues.put(TIME,"String");
	BiometricSensor_EventexitValues.put(USER_ID,"String");
	BiometricSensor_EventexitValues.put(MESAGE, "String");
	BiometricSensor_EventexitValues.put(LOCATION, "String");
	BiometricSensor_EventexitValues.put(FLOOR, "Integer");
	BiometricSensor_EventexitValues.put(DEVICE_TYPE,"String");
	BiometricSensor_Event.setExitValues(BiometricSensor_EventexitValues);


	Set<Method> BiometricSensorMethods =  new HashSet<Method>();
	BiometricSensorMethods.add(BiometricSensor_Event);
	BiometricSensor.setActions(BiometricSensorMethods);
	bb.create(BiometricSensor);

	
	/**
	**RESOURCE TRACKER SERVICE 9 # 6
	**/

	Bundle ResourceTrackerService= new Bundle();
	ResourceTrackerService.setName("ResourceTrackerService");
	ResourceTrackerService.setDescription("Resources relationed methods.");
	ResourceTrackerService.setUrl("file://bundleLocation");

	Method ResourceTrackerService_CheckPermissions = new Method();
	ResourceTrackerService_CheckPermissions.setName("CheckPermissions");
	ResourceTrackerService_CheckPermissions.setDescription("This method receives a Resource id and place and checks if the user has permissions to be in that space.");
	ResourceTrackerService_CheckPermissions.setBundle(ResourceTrackerService);

	Map<String,Pair> ResourceTrackerService_CheckPermissionsParameters =  new TreeMap<String, Pair>();
	Pair ResourceTrackerService_CheckPermissions0 = new Pair("String",false);
	ResourceTrackerService_CheckPermissionsParameters.put(USER_ID,ResourceTrackerService_CheckPermissions0);
	Pair ResourceTrackerService_CheckPermissions1 = new Pair("String",false);
	ResourceTrackerService_CheckPermissionsParameters.put(LOCATION,ResourceTrackerService_CheckPermissions1);
	Pair ResourceTrackerService_CheckPermissions2 = new Pair("String",true);
	ResourceTrackerService_CheckPermissionsParameters.put("_CREATE_LOG",ResourceTrackerService_CheckPermissions2);
	
	ResourceTrackerService_CheckPermissions.setParameters(ResourceTrackerService_CheckPermissionsParameters);
	ResourceTrackerService_CheckPermissions.setModifier(UNDEFINED);

	Map<String,String> ResourceTrackerService_CheckPermissionsexitValues =  new TreeMap<String, String>();
	ResourceTrackerService_CheckPermissionsexitValues.put(RESULT,"Boolean");
	ResourceTrackerService_CheckPermissions.setExitValues(ResourceTrackerService_CheckPermissionsexitValues);


	Set<Method> ResourceTrackerServiceMethods =  new HashSet<Method>();
	ResourceTrackerServiceMethods.add(ResourceTrackerService_CheckPermissions);
	ResourceTrackerService.setActions(ResourceTrackerServiceMethods);
	bb.create(ResourceTrackerService);

	/**
	**ID TRACKER SERVICE 10 # 7
	**/

	Bundle IndentificationTracker= new Bundle();
	IndentificationTracker.setName("IndentificationTracker");
	IndentificationTracker.setDescription("User id related methods");
	IndentificationTracker.setUrl("file://bundleLocation");

	Method IndentificationTracker_CheckIdentification = new Method();
	IndentificationTracker_CheckIdentification.setName("CheckIdentification");
	IndentificationTracker_CheckIdentification.setDescription("Check if the user has permissions in a place");
	IndentificationTracker_CheckIdentification.setBundle(IndentificationTracker);

	Map<String,Pair> IndentificationTracker_CheckIdentificationParameters =  new TreeMap<String, Pair>();
	Pair IndentificationTracker_CheckIdentification0 = new Pair("String",false);
	IndentificationTracker_CheckIdentificationParameters.put(USER_ID,IndentificationTracker_CheckIdentification0);
	Pair IndentificationTracker_CheckIdentification1 = new Pair("String",false);
	IndentificationTracker_CheckIdentificationParameters.put(LOCATION,IndentificationTracker_CheckIdentification1);
	Pair IndentificationTracker_CheckIdentification2 = new Pair("Boolean",true);
	IndentificationTracker_CheckIdentificationParameters.put("_CREATE_LOG",IndentificationTracker_CheckIdentification2);
	
	IndentificationTracker_CheckIdentification.setParameters(IndentificationTracker_CheckIdentificationParameters);
	IndentificationTracker_CheckIdentification.setModifier(UNDEFINED);
	
	Map<String,String> IndentificationTracker_CheckIdentificationexitValues =  new TreeMap<String, String>();
	IndentificationTracker_CheckIdentificationexitValues.put(RESULT,"Boolean");
	IndentificationTracker_CheckIdentification.setExitValues(IndentificationTracker_CheckIdentificationexitValues);


	Set<Method> IndentificationTrackerMethods =  new HashSet<Method>();
	IndentificationTrackerMethods.add(IndentificationTracker_CheckIdentification);
	IndentificationTracker.setActions(IndentificationTrackerMethods);
	bb.create(IndentificationTracker);
	
	
	/**
	**ELEVATOR ACTUATOR 11 # 8
	**/
	
	Bundle ElevatorService= new Bundle();
	ElevatorService.setName("ElevatorService");
	ElevatorService.setDescription("Elevator related tasks");
	ElevatorService.setUrl("file://bundleLocation");

	Method ElevatorService_callElevator = new Method();
	ElevatorService_callElevator.setName("callElevator");
	ElevatorService_callElevator.setDescription("calls the elevator to a certain floor ");
	ElevatorService_callElevator.setBundle(ElevatorService);

	Map<String,Pair> ElevatorService_callElevatorParameters =  new TreeMap<String, Pair>();
	Pair ElevatorService_callElevator0 = new Pair("String",true);
	ElevatorService_callElevatorParameters.put(IP_ADDRESS,ElevatorService_callElevator0);
	Pair ElevatorService_callElevator1 = new Pair("Integer",false);
	ElevatorService_callElevatorParameters.put(FLOOR,ElevatorService_callElevator1);
	Pair ElevatorService_callElevator2 = new Pair("String",true);
	ElevatorService_callElevatorParameters.put(PORT_ADDRESS,ElevatorService_callElevator2);
	
	ElevatorService_callElevator.setParameters(ElevatorService_callElevatorParameters);
	ElevatorService_callElevator.setModifier(UNDEFINED);

	Map<String,String> ElevatorService_callElevatorexitValues =  new TreeMap<String, String>();
	ElevatorService_callElevatorexitValues.put(EVENT_LOG,"String");
	ElevatorService_callElevator.setExitValues(ElevatorService_callElevatorexitValues);


	Set<Method> ElevatorServiceMethods =  new HashSet<Method>();
	ElevatorServiceMethods.add(ElevatorService_callElevator);
	ElevatorService.setActions(ElevatorServiceMethods);
	bb.create(ElevatorService);

	/**
	**OPENDOOR ACTUATOR 12 # 9
	**/
	
	Bundle DoorService= new Bundle();
	DoorService.setName("DoorService");
	DoorService.setDescription("Doors related services");
	DoorService.setUrl("file://bundleLocation");

	Method DoorService_openDoor = new Method();
	DoorService_openDoor.setName("openDoor");
	DoorService_openDoor.setDescription("Opens a door");
	DoorService_openDoor.setBundle(DoorService);

	Map<String,Pair> DoorService_openDoorParameters =  new TreeMap<String, Pair>();
	Pair DoorService_openDoor0 = new Pair("String",false);
	DoorService_openDoorParameters.put(LOCATION,DoorService_openDoor0);
	Pair DoorService_openDoor1 = new Pair("String",true);
	DoorService_openDoorParameters.put(IP_ADDRESS,DoorService_openDoor1);
	Pair DoorService_openDoor2 = new Pair("String",true);
	DoorService_openDoorParameters.put(PORT_ADDRESS,DoorService_openDoor2);
	DoorService_openDoor.setParameters(DoorService_openDoorParameters);
	DoorService_openDoor.setModifier(UNDEFINED);

	Map<String,String> DoorService_openDoor_ExitValues =  new TreeMap<String, String>();
	DoorService_openDoor_ExitValues.put(EVENT_LOG,"String");
	DoorService_openDoor.setExitValues(DoorService_openDoor_ExitValues);


	Set<Method> DoorServiceMethods =  new HashSet<Method>();
	DoorServiceMethods.add(DoorService_openDoor);
	DoorService.setActions(DoorServiceMethods);
	bb.create(DoorService);
	
	/**
	**DEVICE LOGGER 13 # 10
	**/ 
	
	Bundle DeviceLogger= new Bundle();
	DeviceLogger.setName("DeviceLogger");
	DeviceLogger.setDescription("Logs events from devices, and returns user ids and  locations for other uses.");
	DeviceLogger.setUrl("file://bundleLocation");

	Method DeviceLogger_logDeviceEvent = new Method();
	DeviceLogger_logDeviceEvent.setName("logDeviceEvent");
	DeviceLogger_logDeviceEvent.setDescription("logs the device event. Returns the user id, and location id");
	DeviceLogger_logDeviceEvent.setBundle(DeviceLogger);

	Map<String,Pair> DeviceLogger_logDeviceEventParameters =  new TreeMap<String, Pair>();
	Pair DeviceLogger_logDeviceEvent0 = new Pair("String",false);
	DeviceLogger_logDeviceEventParameters.put(USER_ID,DeviceLogger_logDeviceEvent0);
	Pair DeviceLogger_logDeviceEvent1 = new Pair("String",false);
	DeviceLogger_logDeviceEventParameters.put(DEVICE_ID,DeviceLogger_logDeviceEvent1);
	Pair DeviceLogger_logDeviceEvent2 = new Pair("String",false);
	DeviceLogger_logDeviceEventParameters.put(MESAGE,DeviceLogger_logDeviceEvent2);	
	Pair DeviceLogger_logDeviceEvent3 = new Pair("String",false);
	DeviceLogger_logDeviceEventParameters.put(TIME,DeviceLogger_logDeviceEvent3);
	Pair DeviceLogger_logDeviceEvent4 = new Pair("String",false);
	DeviceLogger_logDeviceEventParameters.put(DEVICE_TYPE,DeviceLogger_logDeviceEvent4);	
	
	DeviceLogger_logDeviceEvent.setParameters(DeviceLogger_logDeviceEventParameters);
	DeviceLogger_logDeviceEvent.setModifier(UNDEFINED);

	Map<String,String> DeviceLogger_logDeviceEvent_ExitValues =  new TreeMap<String, String>();
	DeviceLogger_logDeviceEvent.setExitValues(DeviceLogger_logDeviceEvent_ExitValues);


	Set<Method> DeviceLoggerMethods =  new HashSet<Method>();
	DeviceLoggerMethods.add(DeviceLogger_logDeviceEvent);
	DeviceLogger.setActions(DeviceLoggerMethods);
	bb.create(DeviceLogger);
	

	/** 
	**ALARM ACTUATOR 14 # 11
	**/
	
	Bundle AlarmService= new Bundle();
	AlarmService.setName("AlarmService");
	AlarmService.setDescription("Alarm related methods");
	AlarmService.setUrl("file://bundleLocation");

	Method AlarmService_fireAlarm = new Method();
	AlarmService_fireAlarm.setName("fireAlarm");
	AlarmService_fireAlarm.setDescription("Fires the alarm, invoke the stop method to end the alarm.  ");
	AlarmService_fireAlarm.setBundle(AlarmService);

	Map<String,Pair> AlarmService_fireAlarmParameters =  new TreeMap<String, Pair>();
	Pair AlarmService_fireAlarm0 = new Pair("String",true);
	AlarmService_fireAlarmParameters.put(IP_ADDRESS,AlarmService_fireAlarm0);
	
	Pair AlarmService_fireAlarm1 = new Pair("String",true);
	AlarmService_fireAlarmParameters.put(PORT_ADDRESS,AlarmService_fireAlarm1);
	
	Pair AlarmService_fireAlarm2 = new Pair("String",true);
	AlarmService_fireAlarmParameters.put("_ALARM",AlarmService_fireAlarm2);
	
	AlarmService_fireAlarm.setParameters(AlarmService_fireAlarmParameters);
	AlarmService_fireAlarm.setModifier(UNDEFINED);

	Map<String,String> AlarmService_fireAlarmexitValues =  new TreeMap<String, String>();
	AlarmService_fireAlarmexitValues.put(EVENT_LOG,"String");
	AlarmService_fireAlarm.setExitValues(AlarmService_fireAlarmexitValues);


	Set<Method> AlarmServiceMethods =  new HashSet<Method>();
	AlarmServiceMethods.add(AlarmService_fireAlarm);
	AlarmService.setActions(AlarmServiceMethods);
	bb.create(AlarmService);
	

	/**################################*/
	/**################################
	/**##########*BEHAVIORS*###########*
	/**###############################*
	/**################################*/

	
	Method listD = (Method) (bb.read(Bundle.class, 1)).getActions().toArray()[0];
	Method scanD = (Method) (bb.read(Bundle.class, 2)).getActions().toArray()[0];

	Behavior scanBluetoothBehavior =  new Behavior();
	scanBluetoothBehavior.setName("ScanDevices");
	scanBluetoothBehavior.setSource(listD);
	scanBluetoothBehavior.setContext(0);
	scanBluetoothBehavior.setCondition("#"+DEVICE_TYPE+":String:equalsString:String:bluetooth#");
	scanBluetoothBehavior.setAction(scanD);
	scanBluetoothBehavior.setParameters("#"+TIME+":Long:30#");
	
	//cb.save(scanBluetoothBehavior);
	bb.create(scanBluetoothBehavior);
	
	
	Behavior scanRFIdBehavior = new Behavior();
	scanRFIdBehavior.setName("ScanDevices");
	scanRFIdBehavior.setSource(listD);
	scanRFIdBehavior.setContext(0);
	scanRFIdBehavior.setCondition("#"+DEVICE_TYPE+":String:equalsString:String:rfid#");
	scanRFIdBehavior.setAction(scanD);
	scanRFIdBehavior.setParameters("#"+TIME+":Long:30#");
	bb.create(scanRFIdBehavior);
	
	

	
	
	Method BTevent =  (Method) (bb.read(Bundle.class, 6)).getActions().toArray()[0];
	Method RFevent =  (Method) (bb.read(Bundle.class, 7)).getActions().toArray()[0];
	Method BIevent =  (Method) (bb.read(Bundle.class, 8)).getActions().toArray()[0];
	
	
	Method logDev = (Method) (bb.read(Bundle.class, 13)).getActions().toArray()[0];
	Method elevator =  (Method) (bb.read(Bundle.class, 11)).getActions().toArray()[0];
	Method checkIP =  (Method) (bb.read(Bundle.class, 10)).getActions().toArray()[0];
	Method checkRP =  (Method) (bb.read(Bundle.class, 9)).getActions().toArray()[0];
	Method alarm = (Method) (bb.read(Bundle.class, 14)).getActions().toArray()[0];
	Method door = (Method) (bb.read(Bundle.class, 12)).getActions().toArray()[0];
	
	Behavior logBluetoothBehavior = new Behavior();
	logBluetoothBehavior.setName("Bluetooth log");
	logBluetoothBehavior.setSource(BTevent);
	logBluetoothBehavior.setContext(0);
	logBluetoothBehavior.setCondition("");
	logBluetoothBehavior.setAction(logDev);
	logBluetoothBehavior.setParameters("");
	bb.create(logBluetoothBehavior);
	
	Behavior logRFIDBehavior = new Behavior();
	logRFIDBehavior.setName("RFID log");
	logRFIDBehavior.setSource(RFevent);
	logRFIDBehavior.setContext(0);
	logRFIDBehavior.setCondition("");
	logRFIDBehavior.setAction(logDev);
	logRFIDBehavior.setParameters("");
	bb.create(logRFIDBehavior);
	
	Behavior logBioMetricBehavior = new Behavior();
	logBioMetricBehavior.setName("Biometric sensor log");
	logBioMetricBehavior.setSource(BIevent);
	logBioMetricBehavior.setContext(0);
	logBioMetricBehavior.setCondition("");
	logBioMetricBehavior.setAction(logDev);
	logBioMetricBehavior.setParameters("");
	bb.create(logBioMetricBehavior);
	
	Behavior callElevatorBehavior = new Behavior();
	callElevatorBehavior.setName("Call elevator behavior");
	callElevatorBehavior.setSource(BTevent);
	callElevatorBehavior.setContext(0);
	callElevatorBehavior.setCondition("#"+USER_ID+":String:belongsToGroup:String:Handicap#");//"#"+USER_ID+":String:belongsToGroup:String:Handicap#"
	callElevatorBehavior.setAction(elevator);
	callElevatorBehavior.setParameters("#"+IP_ADDRESS+":String:localhost#"+PORT_ADDRESS+":String:9999#");
	bb.create(callElevatorBehavior);
	
	
	
	Behavior checkIDPermissionsBehavior = new Behavior();
	checkIDPermissionsBehavior.setName("CheckIdPermission");
	checkIDPermissionsBehavior.setSource(BIevent);
	checkIDPermissionsBehavior.setContext(0);
	checkIDPermissionsBehavior.setCondition("");
	checkIDPermissionsBehavior.setAction(checkIP);
	checkIDPermissionsBehavior.setParameters("#_CREATE_LOG:Boolean:true#");
	bb.create(checkIDPermissionsBehavior);
	
	Behavior checkPermissionsAlarmBehavior = new Behavior();
	checkPermissionsAlarmBehavior.setName("CheckIdPermission");
	checkPermissionsAlarmBehavior.setSource(checkIP);
	checkPermissionsAlarmBehavior.setContext(1);
	checkPermissionsAlarmBehavior.setCondition("#"+RESULT+":Boolean:equalsBoolean:Boolean:true#");
	checkPermissionsAlarmBehavior.setAction(door);
	checkPermissionsAlarmBehavior.setParameters("#"+IP_ADDRESS+":String:localhost#"+PORT_ADDRESS+":String:9999#");
	bb.create(checkPermissionsAlarmBehavior);
	
	
	
	Behavior checkResourcePermissionsBehavior = new Behavior();
	checkResourcePermissionsBehavior.setName("CheckResourcePermission");
	checkResourcePermissionsBehavior.setSource(RFevent);
	checkResourcePermissionsBehavior.setContext(0);
	checkResourcePermissionsBehavior.setCondition("");
	checkResourcePermissionsBehavior.setAction(checkRP);
	checkResourcePermissionsBehavior.setParameters("#_CREATE_LOG:Boolean:true#");
	bb.create(checkResourcePermissionsBehavior);
	
	Behavior checkPermissionsDoorBehavior = new Behavior();
	checkPermissionsDoorBehavior.setName("CheckResourcePermission");
	 checkPermissionsDoorBehavior.setSource(checkRP);
	 checkPermissionsDoorBehavior.setContext(1);
	 checkPermissionsDoorBehavior.setCondition("#"+RESULT+":Boolean:equalsBoolean:Boolean:false#");
	 checkPermissionsDoorBehavior.setAction(alarm);
	 checkPermissionsDoorBehavior.setParameters("#"+IP_ADDRESS+":String:localhost#"+PORT_ADDRESS+":String:9999#_ALARM:String:0#");
	bb.create( checkPermissionsDoorBehavior);
	
	
	System.out.println("Finish");

//	
//	Behavior b = new Behavior();
//	b.setCondition("cond1");
//	b.setContext(1);
//	b.setName("B1");
//	b.setParameters("parameters");
//	
//	Method a = new Method();
//	a.setDescription("m1");
//	a.setName("m1");
//	
//	HashMap<String,String> map = new HashMap<String,String>();
//	map.put("a","a");
//	map.put("b","b");
//			
//	a.setExitValues(map);
//	
//	b.setAction(a);
//	
////	cb.save(b);
//	
//	Behavior bl = (Behavior)cb.load(Behavior.class,1);
//	System.out.println(bl.getName());
//	System.out.println(bl.getAction().getName());
//	System.out.println(bl.getAction().getExitValues());
//
//	
	}

}
