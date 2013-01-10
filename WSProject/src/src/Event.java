package src;

import java.io.Serializable;

public class Event implements Serializable{

	private String deviceAddress;
	private String deviceName;
	
	public Event(){
		this.deviceAddress = "";
		this.deviceName = "";
		
	}
	
	public Event(String deviceAddress, String deviceName) {
		this.deviceAddress = deviceAddress;
		this.deviceName = deviceName;
	}
	
	public String getDeviceAddress() {
		return deviceAddress;
	}
	
	public void setDeviceAddress(String deviceAddress) {
		this.deviceAddress = deviceAddress;
	}
	
	public String getDeviceName() {
		return deviceName;
	}
	
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	
}
