package plugins.sessionBeans;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.ReflectionException;

import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

import fullsense.interfaces.actuator.ActuatorInterface;
import fullsense.interfaces.sensor.SensorInterface;
import fullsense.util.MethodExecuter;

import plugins.entityBeans.Bundle;
import plugins.sessionBeans.interfaces.BehaviorBeanRemote;
import plugins.sessionBeans.interfaces.PluginCoreBeanLocal;
import plugins.sessionBeans.interfaces.PluginCoreBeanRemote;
import test.MyInjector;

/**
 * Session Bean implementation class SignalSensorBean
 */
@Stateless
public class PluginCoreBean implements PluginCoreBeanRemote, PluginCoreBeanLocal {

	public static final String BLUETOOTH = "Bluetooth";
	public static final String RFID = "RFID";
	public static final String BIOMETRIC = "Biometric";
	BundleContext context;
	
    /**
     * Default constructor. 
     */
    public PluginCoreBean() {
    	MBeanServer mbs = org.jboss.mx.util.MBeanServerLocator.locateJBoss();
		try {
		
			ObjectInstance ccv = (ObjectInstance) (mbs.queryMBeans(new ObjectName("*:name=org.apache.felix.framework,*") , null).toArray())[0];
			try {
				Object o = mbs.getAttribute(ccv.getObjectName(), "Context");
				System.out.println("Atribute Object:"+o.getClass().getName());
				context = (BundleContext) o;
	
			} catch (AttributeNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedObjectNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReflectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MBeanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
	public void signalSensor(String type, Map<String, String> arguments) throws Exception {
		ServiceReference[] references =  null;
		try {
			references =  context.getServiceReferences(ActuatorInterface.class.getName(), "(name="+type+"Sensor)");
			if(references!=null && references.length>0){
				Object Actuator = context.getService(references[0]);

			Dictionary<String, Object> dic = new Hashtable<String, Object>();
			for(String arg : arguments.keySet()){
				dic.put(arg, arguments.get(arg));	
			}	
			MethodExecuter.doActionOnBundle(Actuator,"Event", dic);
				
			}else
				System.out.println("[FULLSENSE ERROR : CORE INTERFACE] No suitable interfaces found for "+type);	
		
		
		} catch (InvalidSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	public void startServices() throws Exception {
		
		BehaviorBeanRemote Behavior_interface = (BehaviorBeanRemote) MyInjector.getEJBl(BehaviorBean.class);
		List<Bundle> bundles = Behavior_interface.getAllBundles();
		
		
		ServiceReference[] references =  null;
		references = context.getAllServiceReferences(SensorInterface.class.getName(), null);

		
		
		for (Bundle bundle : bundles) {
			String name = bundle.getName();
			
			
			try {
				references =  context.getServiceReferences(SensorInterface.class.getName(), "(name="+name+")");
				
				
				if(references!=null && references.length>0){
					Object sensor = context.getService(references[0]);
					
					Dictionary<String, Object> dic = new Hashtable<String, Object>();
					dic.put("name", "BehaviorControler");
					dic.put("NAME", "BehaviorControler");
					MethodExecuter.addServiceListenerOnSensor(sensor, dic);
				}else
					System.out.println("[FULLSENSE MESSAGE] No suitable interfaces found when activating services for: "+name);	
			} catch (InvalidSyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
