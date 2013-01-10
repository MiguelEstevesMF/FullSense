package com.fullsystems.fullsense.client.utility;

public class FullSenseNames {
	public static String getHeading(RoleID id) {
		switch (id) {
		case HumanManager: 
			return "Human Resources Manager";
		case LogsManager:
			return "Logs Manager";
		case User:
			return "User";
		case ResourcesManager:
			return "Technical Resources Manager";
		default:
			return "NULL";
		}
	}
	
	public static String getServiceName(ServiceID id){
		switch(id){
		case ChangeUserInfo:
			return "Change User Info";
		case CheckyourLog:
			return "Check your Log";
		case EndofResourceRenting:
			return "End of Resource Renting";
		case ExportLog:
			return "Export Log";
		case FindResource:
			return "Find Resource";
		case NewResourceRegistration:
			return "New Resource Registration";
		case NewTemporaryUserRegistration:
			return "New Temporary User Registration";
		case NewUserRegistration:
			return "New User Registration";
		case RemoveResource:
			return "Remove Resource";
		case RemoveTemporaryUser:
			return "Remove Temporary User";
		case RemoveUser:
			return "Remove User";
		case RentResource:
			return "Rent Resource";
		case RequestResource:
			return "Request Resource";
		case ViewLog:
			return "View Log";
		case ViewRegister:
			return "View Register";
			default:
				return "NULL";
		}
	}
}
