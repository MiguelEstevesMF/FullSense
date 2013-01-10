package src;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import plugins.sessionBeans.PluginCoreBean;
import plugins.sessionBeans.interfaces.PluginCoreBeanRemote;
import aid.MyInjector;

public class FingerPrint {

	private static int count = 0;
	
	public FingerPrint(){
		
	}
	
	public String registEvent(String date, String hardwareId, String personId, 
			String eventDescription){
		
		long time = Long.valueOf(date).longValue()*1000;
		
		Date d = new Date(time);
		Map<String,String> map = new HashMap<String,String>();
		try{
			PluginCoreBeanRemote log =(PluginCoreBeanRemote)MyInjector.getEJBr(PluginCoreBean.class);
			
			map.put(MyInjector.DEVICE_ID, hardwareId);
			map.put(MyInjector.USER_ID, personId);
			map.put(MyInjector.TIME, String.valueOf(time));
			log.signalSensor(PluginCoreBean.BIOMETRIC, map);
			
		}catch(Exception e){
			System.out.println("##### ASNEIRAAA ");
			e.printStackTrace();
		}      
		 
	return d.toString();
	}
	
	public String verifyAccess(String hardwareId, String personId){
		
		
		return "Ok " + count;
	}
	
	public String addAccess(String date, String hardwareId, String personId){
		
		return "Ok " + count;
	}
	
	public String removeAccess(String date, String hardwareId, String personId){
		
		return "Ok " + count;
	}
}
