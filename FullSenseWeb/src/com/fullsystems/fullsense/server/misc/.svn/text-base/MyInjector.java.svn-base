package com.fullsystems.fullsense.server.misc;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MyInjector {
	
	public static Object getEJBr(Class c){
		Object obj=null;
		InitialContext ctx;
		try {
		    ctx = new InitialContext();
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
