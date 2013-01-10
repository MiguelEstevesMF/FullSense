package aid;

import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MyInjector {
     
	static public final String DEVICE_TYPE = "_DEVICE_TYPE";
	static public final String DEVICE_ID = "_DEVICE_ID";
	static public final String USER_ID = "_USER_ID"; 
	static public final String GROUP_ID = "_GROUP_ID";
	static public final String TIME = "_TIME"; 
	
	public static Object getEJBr(Class c){
		Object obj=null;
		InitialContext ctx;
		try {
			Properties properties = new Properties();
			properties.setProperty("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
//			properties.setProperty("java.naming.provider.url", "localhost:1099");
			properties.setProperty("java.naming.provider.url", "mes2.di.uminho.pt:1099");
			properties.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:rg.jnp.interfaces");

		    ctx = new InitialContext(properties);
		    obj = (Object) ctx.lookup(c.getSimpleName()+"/remote");

		} catch (NamingException ex) {
		    System.out.println("MyInjector : " + ex.getMessage());
		}
		return obj;
	}

	public static Object getEJBl(Class c){
		Object obj=null;
		InitialContext ctx;
		try {
		    ctx = new InitialContext();
		    obj = (Object) ctx.lookup(c.getSimpleName()+"/local");

		} catch (NamingException ex) {
		    System.out.println("MyInjector : " + ex.getMessage());
		}
		return obj;
	}
}
