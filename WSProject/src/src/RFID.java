package src;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import plugins.sessionBeans.PluginCoreBean;
import plugins.sessionBeans.interfaces.PluginCoreBeanRemote;
import aid.MyInjector;

public class RFID {
    
	public static int cont = 0;
	
	public String newInput(String receiverId, String inputTime, String serialNumber) {
	
		long time = Long.valueOf(inputTime).longValue()*1000;
		Date d = new Date(time);
		
		try{
			PluginCoreBeanRemote log =(PluginCoreBeanRemote)MyInjector.getEJBr(PluginCoreBean.class);
			Map<String,String> map = new HashMap<String,String>();
			map.put(MyInjector.DEVICE_ID, receiverId);
			map.put(MyInjector.USER_ID, serialNumber);
			map.put(MyInjector.TIME, String.valueOf(time));
			
			log.signalSensor(PluginCoreBean.RFID, map);
			
		}catch(Exception e){
			System.out.println("####### ASNEIRA #########");
			e.printStackTrace();
		}
		
		return d.toString();
	}
    
	public String teste(){
    	
    	cont++;
    	return "Ok " + cont;
    }
}
