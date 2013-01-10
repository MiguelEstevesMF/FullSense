package com.fullsystems.fullsense.client.utility;

public enum ServiceID {
	ViewLog(0),
	ViewRegister(1),
	ExportLog(2),
	NewUserRegistration(3),
	NewTemporaryUserRegistration(4),
	RemoveTemporaryUser(5),
	RemoveUser(6),
	NewResourceRegistration(7),
	RemoveResource(8),
	RentResource(9),
	FindResource(10),
	EndofResourceRenting(11),
	CheckyourLog(12),
	ChangeUserInfo(13),
	RequestResource(14);
	
	private int code;
	
	private ServiceID(int c){
		code = c;
	}
	
	public int getCode(){
		return code;
	}
}
