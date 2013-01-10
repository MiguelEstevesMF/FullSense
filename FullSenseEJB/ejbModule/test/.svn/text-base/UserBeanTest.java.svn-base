package test;

import java.util.Date;
import java.util.HashMap;

import javassist.compiler.ast.Pair;

import plugins.entityBeans.Behavior;
import plugins.entityBeans.Method;

import core.entityBeans.Permission;
import core.entityBeans.PermissionGroup;
import core.entityBeans.Protocol;
import core.entityBeans.SystemLogResource;
import core.entityBeans.SystemLogUser;
import core.entityBeans.User;
import core.entityBeans.UserIdentifier;
import core.sessionBeans.UserBean;
import core.sessionBeans.interfaces.UserBeanRemote;



public class UserBeanTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		UserBeanRemote ubr = (UserBeanRemote)MyInjector.getEJBr(UserBean.class);
		CrudBeanRemote cb = (CrudBeanRemote)MyInjector.getEJBr(CrudBean.class);
		
		
		// INSERT a new USER
	   	User u = new User();
	   	/*
		u.setUser("darks1");
		u.setPassword("111");
		u.setName("Ricardo");
		u.setImageURL("link imagen de gaja boa");
		u.setPhoneNumber("123456781");
		u.setEnable(new Date());
		u.setExpire(new Date(System.currentTimeMillis()+365*24*60*60*1000));
		PermissionGroup pg = new PermissionGroup();
		pg.setId("ADMIN");

		u.getPermissionGroups().add(pg);
*/
/*	
		Protocol p = new Protocol();
		p.setName("RFID");
	
		cb.save(p);
		
		UserIdentifier ui = new UserIdentifier();
		ui.setId("121111");
		ui.setProtocol(p);
		
		//Teste ao create
		System.out.println(ubr.create(u));
*/		
		//Testar o update
	//	u.setAddress("qq coisa"); ???????????
	//	System.out.prinln(ubr.update(u));
		//Para que tem o segundo update?? - Nao testei o segundo..
		
	
	/*	//Teste ao login
		System.out.println(ubr.login("darks1","111").toString());
		//ToString do user nao deveria dar os seus campos todos??
		
		//Teste ao delete
		System.out.println(ubr.delete(u));
		//Testar countUser
		//O que é isto que esta dentro do counteruser filterActive
		//System.out.println(ubr.countUser(true)); - Aqui deveria dar 0 :S
		System.out.println(ubr.countUser(false));
		//Testar o drop
		System.out.println(ubr.drop(u));
		//System.out.println(ubr.login("darks2","113").toString());
		//ISto devia dar false?? ou se ele ja n existir??

		//Testar o listUser
		//for(User i : listUser(false,0,0))
		//System.out.println(i.toString());
		
		
	*/
	
/*		User u2 = new User();
		u2.setUser("darks2");
		u2.setPassword("112");
		u2.setName("Miguel");
		u2.setImageURL("link qq");
		u2.setPhoneNumber("123456782");
		u2.setEnable(new Date());
		u2.setExpire(new Date(System.currentTimeMillis()+365*24*60*60*1000));
		PermissionGroup pg = new PermissionGroup();
		pg.setId("ADMIN");
		u2.getPermissionGroups().add(pg);
		//UserIdentifier ui2 = new UserIdentifier();
		//ui2.setId("121112");
		//Protocol p = new Protocol();
		//p.setName("RFID");
	//	cb.save(p);
	//	ui2.setProtocol(p);
	//	System.out.println(ubr.create(u2));
		//Como funciona o setExpire da data?? 
		//Como sei quais os campos obrigatorios??
		//O userIdentifier não é obrigatorio...
*/		
		
		
		
		
		//		ubr.create(u);
		//		User u2 = ubr.login("darks2","123");
		//ubr.delete(u2);
		//		System.out.println(u2.getUserIdentifiers().getClass());
	/*	
		Behavior b = new Behavior();
		b.setCondition("cond1");
		b.setContext(1);
		b.setName("B1");
		b.setParameters("parameters");
		
		Method a = new Method();
		a.setDescription("m1");
		a.setName("m1");
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("a","a");
		map.put("b","b");
				
		a.setExitValues(map);
		
		b.setAction(a);
		
//		cb.save(b);
		
		Behavior bl = (Behavior)cb.load(Behavior.class,1);
		System.out.println(bl.getName());
		System.out.println(bl.getAction().getName());
		System.out.println(bl.getAction().getExitValues());
*/
		

	}

}
