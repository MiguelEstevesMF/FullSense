package test_;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.naming.Name;

import org.omg.PortableInterceptor.USER_EXCEPTION;



import com.sun.org.apache.bcel.internal.generic.NEW;

import misc.*;
import core.entityBeans.*;
import core.entityBeans.Request.ReqState;
import plugins.entityBeans.*;
import plugins.util.*;
import test.CrudBean;
import test.CrudBeanRemote;
import core.sessionBeans.*;
import core.sessionBeans.interfaces.*;

public class FillDatabase {
	UserBeanRemote userBeanRemote;
	CrudBeanRemote crudBeanRemote;
	DetectorBeanRemote detectorBeanRemote;
	ResourceBeanRemote resourceBeanRemote;
	LogBeanRemote logBeanRemote;
	
	public FillDatabase(){
		userBeanRemote = (UserBeanRemote) MyInjector.getEJBr(UserBean.class);
		crudBeanRemote = (CrudBeanRemote) MyInjector.getEJBr(CrudBean.class);
		detectorBeanRemote = (DetectorBeanRemote) MyInjector.getEJBr(DetectorBean.class);
		resourceBeanRemote = (ResourceBeanRemote) MyInjector.getEJBr(ResourceBean.class);
		logBeanRemote = (LogBeanRemote) MyInjector.getEJBr(LogBean.class);
	}
	
	public void fillDB(){
		
		try {
			
			String[] images = new String[]{ "http://i140.photobucket.com/albums/r33/efaisalz/scarlet-johannson.jpg",
			"http://www.poster.net/alba-jessica/alba-jessica-photo-xl-jessica-alba-6234072.jpg",
			"http://home.freeuk.net/blindyouth/carrie.jpg"};
	
			//Users
			for(int i=1;i<31;i++) {
				User user = new User();
				user.setAddress("Address");
				user.setEmail("user"+i+"@email");
				user.setEnable(new Date("2/"+i+"/2010 04:03:51"));
				user.setExpire(new Date("12/"+i+"/2010 04:03:51"));
				user.setImageURL(images[i%images.length]);
				user.setUser("user"+i);
				user.setPassword("123");
				user.setPhoneNumber("00"+(i*1086579));
				user.setName("name"+i);
				userBeanRemote.create(user);
			}
			
			//Protocols
			String[] protocols = new String[]{ "WIFI", "Fingerprint", "Bluetooth", "Camera", "RFID" };
			for(int i=0;i<protocols.length;i++) {
				Protocol protocol = new Protocol();
				protocol.setName(protocols[i]);
				detectorBeanRemote.create(protocol);
			}
			
			//Type
			String[] Rtypes = new String[]{ "PC", "Notebook", "Projector", "Classroom", "Lab", "Office", "WC", "Table", "Chair", "Detector-Bluetooth", "Router-WIFI", "Detector-Camera", "Detector-RFID", "Detector-Fingerprint"};
			for(int i=0;i<Rtypes.length;i++) {
				Type type = new Type();
				type.setName(Rtypes[i]);
				resourceBeanRemote.create(type);
			}
			

			//GROUPS
			int u_id=1;
			for(int i=1; i<6; i++){
				PermissionGroup pg = new PermissionGroup();
				pg.setId("group"+i);
				
				HashSet<Permission> perms = new HashSet<Permission>();
				for(int j=0; j<10; j++){
					Permission p = new Permission();
					p.getPermissionGroups().add(pg);
					perms.add(p);
				}
				
				pg.setPermissions(perms);
				
				userBeanRemote.create(pg);
				
				for(int u=u_id; u<i*6+1; u++, u_id++)
					userBeanRemote.update(userBeanRemote.readUser("user"+u), userBeanRemote.readPermissionGroup("group"+i), null, null);
			}
			

			//WEB_PERMISSIONS_GROUP
			u_id=1;
			String[] Ptypes = new String[]{ "User", "Human", "Resources", "Logs Manager" };
			for(int i=1;i<=Ptypes.length;i++) {
				PermissionGroup pg = new PermissionGroup();
				pg.setId(Ptypes[i-1]);
				
				userBeanRemote.create(pg);
				
				for(int u=u_id; u<i*2+1; u++, u_id++)
					userBeanRemote.update(userBeanRemote.readUser("user"+u), userBeanRemote.readPermissionGroup(Ptypes[i-1]), null, null);
			}
			
			//UserIdentifier
			for(int i=1; i<31; i++){
				Random rand_uid = new Random();
				int idents = rand_uid.nextInt(5);
				
				User user = userBeanRemote.readUser("user"+i);
				
				for(int j=0; j<idents; j++){
					UserIdentifier uid = new UserIdentifier();
					uid.setId("user_ident"+i+"_"+(j+1));
					int p = rand_uid.nextInt(5);
					uid.setProtocol(detectorBeanRemote.listProtocols(p, 1).get(0));
					user.getUserIdentifiers().add(uid);
					userBeanRemote.update(user);
				}
			}
		
			//Resources (Identifiable && Stationary) && Requests
			int d_id=1;
			for(int i=1, o=0; i<51; i++, o++){
				Random rand_r = new Random(System.currentTimeMillis());
				
				Resource r = new Resource();
				
				if(i<26) r = new IdentifiableResource();
				else r = new StationaryResource();
				r.setId("resource"+i);
				r.setActive(true);
				r.setDesc("desc_resource"+i);
				r.setName("resource_name"+i);
				Type t = resourceBeanRemote.readType(Rtypes[rand_r.nextInt(Rtypes.length)]);
				HashSet<Permission> perms = new HashSet<Permission>(resourceBeanRemote.listPermissions(o, 1));
				r.setPermissions(perms);
				r.setType(t);
				
				resourceBeanRemote.create(r);
				
				ReqState[] reqState = {ReqState.DELIVERED, ReqState.LIFTED, ReqState.RESERVED};
				int req = rand_r.nextInt(3)+1;
				
				for(int j=0; j<req; j++){
					Request request = new Request();
					request.setState(reqState[rand_r.nextInt(3)]);
					request.setUser(userBeanRemote.readUser("user"+(rand_r.nextInt(30)+1)));
					request.setBegin(new Date(System.currentTimeMillis()-rand_r.nextInt(1000000000)));
					request.setEnd(new Date(System.currentTimeMillis()+rand_r.nextInt(1000000000)));
					request.setResource(resourceBeanRemote.readResource("resource"+i));
					resourceBeanRemote.create(request);
				}
				
				if (i>25){
					Circle c = new Circle();
					c.setcX(rand_r.nextInt(100));
					c.setcY(rand_r.nextInt(100));
					c.setRadius(rand_r.nextInt(100));
					c.setFloor(rand_r.nextInt(4));
					c.setStationaryResource((StationaryResource) resourceBeanRemote.readResource("resource"+i));
					
					int d = rand_r.nextInt(4)+1;
					for(int j=0; j<d; j++, d_id++){
						Detector det = new Detector();
						det.setId("detector"+d_id);
						det.setArea(c);
						detectorBeanRemote.create(det);
					}
				}
				
			}

			
			//ResourceIdentifier
			for(int i=1; i<26; i++){
				Random rand_uid = new Random();
				int idents = rand_uid.nextInt(5);
				
				IdentifiableResource ir = (IdentifiableResource) resourceBeanRemote.readResource("resource"+i);
				
				for(int j=0; j<idents; j++){
					ResourceIdentifier rid = new ResourceIdentifier();
					rid.setId("resource_ident"+i+"_"+(j+1));
					int p = rand_uid.nextInt(5);
					rid.setProtocol(detectorBeanRemote.listProtocols(p, 1).get(0));
					rid.setIdentifiableResource(ir);
					detectorBeanRemote.create(rid);
					resourceBeanRemote.update(ir);
				}
			}
			
			//PermissionGroups per Users for WEB
			String[] us = new String[]{"user1", "user2", "user3", "user4"};
			String[] pgs = new String[]{"User", "Human", "Resources", "Logs Manager"};
			for(int i=0;i<4;i++)
				try {
					userBeanRemote.update(userBeanRemote.readUser(us[i]), userBeanRemote.readPermissionGroup(pgs[i]), null, null);
				} catch(Exception e) {}
			
			
			//TrackingLogs
			for(int i=1;i<5;i++) {
				TrackingLog tl = new TrackingLog();
				tl.setDesc("desc-tl");
				tl.setTime(new Date());
				tl.setDetector(detectorBeanRemote.readDetector("detector"+i));
				tl.setIdentifier(detectorBeanRemote.listIdentifiers(0,4).get(i-1));
				logBeanRemote.create(tl);
			}
			
			
			
			//User PI
			User pi = new User();
			pi.setEmail("pi_rules999@hotmail.com");
			pi.setName("Pedro Gomes");
			pi.setImageURL("http://dl.getdropbox.com/u/1426591/Foto0018.jpg");
			pi.setUser("pi");
			pi.setPassword("123");
			pi.setEnable(new Date(110,1,20));
			pi.setExpire(new Date(110,4,20));
			userBeanRemote.create(pi);
			
			PermissionGroup pg = new PermissionGroup();
			pg.setId("Handicap");
			userBeanRemote.create(pg);
			
			userBeanRemote.update(pi, pg, null, null);
			userBeanRemote.update(pi, userBeanRemote.readPermissionGroup("User"), null, null);
			
			
			List<Request> lr = resourceBeanRemote.listRequests(0, 1000);
			int o=1;
			for(Request r : lr) {
				r.setState(ReqState.DELIVERED);
				try{if(r.getResource().getId().equals("resource"+o)) r.setState(ReqState.LIFTED);}catch(Exception e) {}
				o++;
				resourceBeanRemote.update(r);
			}
		
			
			//Specific Detector for Sensor testing
			StationaryResource sr = new StationaryResource();
			sr.setActive(true);
			sr.setDesc("desc-SR1");
			sr.setId("H1");
			sr.setName("Hall-de-entrada");
			sr.setType(resourceBeanRemote.readType("WC"));
			
			Circle c = new Circle();
			c.setFloor(1);
			c.setcX(1);
			c.setcY(1);
			c.setRadius(10.0d);
			c.setStationaryResource(sr);
			
			Detector d = new Detector();
			d.setId("R1");
			d.setArea(c);
			
			detectorBeanRemote.create(d);
			
			//Specific bluetooth Detector for Sensor testing
			StationaryResource sr2 = new StationaryResource();
			sr2.setActive(true);
			sr2.setDesc("desc- Auditorium");
			sr2.setId("A1");
			sr2.setName("Auditorium");
			sr2.setType(resourceBeanRemote.readType("WC"));
			
			Circle c2 = new Circle();
			c2.setFloor(1);
			c2.setcX(1);
			c2.setcY(1);
			c2.setRadius(10.0d);
			c2.setStationaryResource(sr2);
			
			Detector db = new Detector();
			db.setId("B1");
			db.setArea(c2);
			
			detectorBeanRemote.create(db);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("DBFILLED");
	}
	
	public void action1() {
		System.out.println("ACTION1");
		UserIdentifier ui = new UserIdentifier();
		ui.setId("ui1");
		crudBeanRemote.save(ui);
		
		ResourceIdentifier ri = new ResourceIdentifier();
		ri.setId("ri1");
		crudBeanRemote.save(ri)	;
		
		
		Identifier identifier = (Identifier) crudBeanRemote.load(Identifier.class, "ri1");
		
		if( identifier instanceof UserIdentifier) {
			UserIdentifier ui2 = (UserIdentifier) identifier;
			System.out.println(ui2.getUser());
		}
		
	}
	
	public void action2() {
		System.out.println("ACTION2");


		Bundle webServiceBundle = new Bundle();
		webServiceBundle.setName("WebUtilities");
		webServiceBundle.setDescription("A bundle that contains several methods to be used by the web components. Here we can find:" +
				"<br>  listDevices: a method that allows the user to retreive all devices from a certain type detected in the next t time.");
		webServiceBundle.setUrl("file://bundleLocation");
		webServiceBundle.setProperties(new Hashtable<String, String>());
		
		//Bundle methods
		Method listDevices =  new Method();
		listDevices.setBundle(webServiceBundle);
		listDevices.setName("scanDevices");
		listDevices.setDescription("a method that allows the user to retreive all devices from a certain type detected in the next t time");
		//method parameters 
		Map<String,Pair> listDevices_parameters =  new TreeMap<String,Pair>();
		Pair p = new Pair("String", true);
		
//		crudBeanRemote.save(p);
//		p = crudBeanRemote.load(Pair.class, p.getId());
		listDevices_parameters.put("DEVICE_TYPE", p);
		listDevices.setParameters(listDevices_parameters);

		
		Map<String,String> exitValues =  new TreeMap<String, String>();
		exitValues.put("DEVICE_TYPE","String");
		listDevices.setExitValues(exitValues);
		
		//crudBeanRemote.save(listDevices);


		
		Set<Method> webActionMethods = new HashSet<Method>();
		webActionMethods.add(listDevices);
		
		webServiceBundle.setActions(webActionMethods);
		
		crudBeanRemote.save(webServiceBundle);
		
		
		
		
	}
	
	public void action3() {
		System.out.println("ACTION3");	
		try {
			User u = userBeanRemote.login("user1", "123");
			System.out.println(u.getUser());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void action4() {
		System.out.println("ACTION4");
		try {
//			User u = userBeanRemote.readUser("user1");
//			System.out.println(u.getPermissionGroups().size());
//			u.getPermissionGroups().add(crudBeanRemote.load(PermissionGroup.class, "Administrator"));
//			userBeanRemote.update(u);

//			PermissionGroup pg = userBeanRemote.readPermissionGroup("Administrator");
//			User u = userBeanRemote.readUser("user1");
//			System.out.println(u.getPermissionGroups().size());
//			System.out.println(pg.getId());
//			pg.getUsers().add(u);
//			System.out.println(u.getPermissionGroups().size());
//			//userBeanRemote.update(u);
//			userBeanRemote.update(pg);
			
			Request request1 = new Request();
			request1.setBegin(new Date());
			request1.setEnd(new Date());
			request1.setState(Request.ReqState.RESERVED);
			crudBeanRemote.save(request1);
			request1 = crudBeanRemote.load(Request.class,request1.getId());
			UserIdentifier ui = new UserIdentifier();
			ui.setId("ui5");
//			crudBeanRemote.save(ui);
			
//			Request request1 = crudBeanRemote.load(Request.class,1);
			PermissionGroup pg1 = new PermissionGroup();//.readPermissionGroup("Administrator");
			pg1.setId("GrupoFix");
//			UserIdentifier ui = crudBeanRemote.load(UserIdentifier.class,"ui1");
			
			User u = userBeanRemote.readUser("user1");
			u.setName("userXXYX");
			//u.getRequests().add(request1);
			//crudBeanRemote.save(request1);

			//userBeanRemote.update(u);
			userBeanRemote.update(u,null,request1,ui);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
					
	}
	
	public void action5() {
		System.out.println("ACTION5");
		try{
		for(int i=20; i<24; i++){
			PermissionGroup pg1 = userBeanRemote.readPermissionGroup("GrupoFix1");
		
		PermissionGroup pg2 = userBeanRemote.readPermissionGroup("GrupoFix2");
		User u = userBeanRemote.readUser("user"+i);
		
		userBeanRemote.update(u,pg1,null,null);
		userBeanRemote.update(u,pg2,null,null);
		}
		}catch(Exception e){}
			
		//WEB_PERMISSIONS_GROUP
		try {
			int u_id=1;
			String[] Ptypes = new String[]{ "Super-administrator", "Administrator", "Human-resource-manager", "Material-resource-manager", "Default" };
			for(int i=1;i<=Ptypes.length;i++) {
				PermissionGroup pg = new PermissionGroup();
				pg.setId(Ptypes[i-1]);
				
				HashSet<User> users = new HashSet<User>();
				for(int u=u_id; u<i*2+1; u++, u_id++){
					//User user = userBeanRemote.readUser("user"+u);
					//user.getPermissionGroups().add(pg);
					//userBeanRemote.update(user);
					users.add(userBeanRemote.readUser("user"+u));
				}
				pg.setUsers(users);
				userBeanRemote.create(pg);
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void action6() {
		System.out.println("ACTION6");

		 try {
				LogBeanRemote logBeanRemote = (LogBeanRemote) MyInjector.getEJBr(LogBean.class);
				List<SystemLog> tl = logBeanRemote.listUserLogs( SystemLog.class, false, "user1", new Date("2/1/2010 04:03:51"), new Date(),0,20 );
				for(SystemLog lo : tl)
				System.out.println(lo.getDesc()+","+lo.getId()+","+lo.getTime().toString());
				}catch(Exception e) {e.printStackTrace();}
		
		try {
			
			ArrayList<Resource> rs = new ArrayList<Resource>(
					resourceBeanRemote.listResources(null, null, new Date(110,1,20), new Date(110,1,21,15,0), true, 0, 50));
			
			
			//System.out.println(new Date(110,1,15));
			//System.out.println(new Date(110,1,16));
			System.out.println("TAMANHO: "+rs.size());
			System.out.println("LISTA: "+rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void action7() {
		System.out.println("ACTION7");

		
		try {
//			StationaryResource sr = new StationaryResource();
//			sr.setActive(true);
//			sr.setId("SR-1");
//			resourceBeanRemote.create(sr);
			
			StationaryResource sr = (StationaryResource) resourceBeanRemote.readResource("SR-1");
			
			Permission per = new Permission();
			per.setResource(sr);
			resourceBeanRemote.create(per);
			per = resourceBeanRemote.readPermission(54);
			resourceBeanRemote.update(per, userBeanRemote.readPermissionGroup("group1"));
			
			
			Identifier identifier = detectorBeanRemote.readIdentifier("user_ident1_1");
			boolean b = detectorBeanRemote.validatePermission(identifier, sr, false, false);
			System.out.print(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	public void action8() {
		System.out.println("ACTION8");

		try {
			Request req = new core.entityBeans.Request();
			req.setBegin(new Date());
			req.setEnd(new Date());
			
			req.setUser(userBeanRemote.readUser("user1"));
			
			req.setResource(resourceBeanRemote.readResource("resource1")) ;
			req.setState(ReqState.RESERVED);
			resourceBeanRemote.create(req);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void action9() {
		try{	

//			List l = userBeanRemote.readRequestsByUser("user1");
//			System.out.println(l.size());
			
//			boolean b = detectorBeanRemote.validatePermission("user_ident13_3", "resource26", false, true);
//			System.out.println(b);
//			
//			Date d1 = new Date("3/20/2010 00:01");
//			Date d2 = new Date("3/21/2010 00:01");
//			
//			Request request = new Request();
//			request.setBegin(d1);
//			request.setEnd(d2);
//			request.setResource(resourceBeanRemote.readResource("H1"));
//			request.setUser(userBeanRemote.readUser("pi"));
//			resourceBeanRemote.create(request);
			
			Date begin = new Date("3/21/2010 00:01");
			System.out.println(begin);
			Date end = new Date("3/21/2010 10:01");
			System.out.println(end);
			List<Resource> lr = resourceBeanRemote.listResources(null, null, begin, end, true, 0, 1000);
			System.out.println(lr.size());
			for(Resource r : lr) {
				System.out.println(r.getId());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void action10() {
		try{	


//			TrackingLog tl = logBeanRemote.createTrackingLog("bluetooth", "identifierBT", "detectorBT", null,null, new Date(), "desc");
//			System.out.println(tl.getId());
			
			List<User> lu = userBeanRemote.listUser(false, 0, 1000);
			for(User u : lu)
				System.out.println(u.getPermissionGroups());
			
//			User u = crudBeanRemote.load(User.class,"user1");
//			System.out.println(u.getUser());
//			
//			System.out.println(u.getPermissionGroups());
//			System.out.println(u.getPermissionGroups());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}