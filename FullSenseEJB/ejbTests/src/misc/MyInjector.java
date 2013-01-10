package misc;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MyInjector {
     
	
	public static Object getEJBr(Class c){
		Object obj=null;
		InitialContext ctx;
		try {
			Properties properties = new Properties();
			properties.setProperty("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
			properties.setProperty("java.naming.provider.url", "localhost:1099"); //mes2.di.uminho.pt:1099 //fullsense.guecks.com:1099
			properties.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming rg.jnp.interfaces");

		    ctx = new InitialContext(properties);
		    obj = (Object) ctx.lookup(c.getSimpleName()+"/remote");

		} catch (NamingException ex) {
		    System.out.println(ex.getMessage());
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
		    System.out.println(ex.getMessage());
		}
		return obj;
	}
}
