package src;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import plugins.sessionBeans.PluginCoreBean;
import plugins.sessionBeans.interfaces.PluginCoreBeanRemote;

import core.sessionBeans.LogBean;
import core.sessionBeans.interfaces.LogBeanRemote;


import aid.MyInjector;

public class BlueTooth {
	
	private static int count = 0;
	
	public BlueTooth(){
		
	}

	public Event getSightings(){
		return new Event("a","b");
	}
	
	public Event getSightings2(){
		return new Event("a","b");
	}
	
	public String addScanning(String scannerId, String scanningReportTime, 
			Event[] eventList){
		
		long l = Long.valueOf(scanningReportTime).longValue()*1000;
		
		Date d = new Date(l);

		Calendar c = null;
		Map<String,String> map = new HashMap<String,String>();
		
		try{
			 PluginCoreBeanRemote log =(PluginCoreBeanRemote)MyInjector.getEJBr(PluginCoreBean.class);
			 
			for(Event e : eventList){
				map.put(MyInjector.DEVICE_ID, scannerId);
				map.put(MyInjector.USER_ID, e.getDeviceAddress());
				map.put(MyInjector.TIME, String.valueOf(l));
				log.signalSensor(PluginCoreBean.BLUETOOTH, map);
				map = new HashMap<String,String>();
			}
			
			
		}catch(Exception e){
			System.out.println("########PROBLEMMMMM####### " + e.getLocalizedMessage());
			e.printStackTrace();
		}
			
		count++;
	return d.toString();
	}
}
