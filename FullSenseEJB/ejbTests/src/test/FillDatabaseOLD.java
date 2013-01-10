package test;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.naming.Name;

import com.sun.org.apache.bcel.internal.generic.NEW;

import misc.*;
//import fullsenseejb.entity_beans.*;
//import fullsenseejb.session_beans.crud.*;
//import fullsenseejb.session_beans.interfaces.*;

public class FillDatabaseOLD {
//	User_Remote user_Remote;
//	Permission_Remote permission_Remote;
//	Material_Remote material_Remote;
//	Group_Remote group_Remote;
//	BinObject_Remote binObj_Remote;
//	UniqueCredencial_Remote uniqueCredencial_Remote;
//	ResourceRecord_Remote resourceRecord_Remote;
//	InterfaceType_Remote interfaceType_Remote;
	
	public FillDatabaseOLD(){
//		user_Remote = (User_Remote) MyInjector.getEJBr(User_Bean.class);
//		permission_Remote = (Permission_Remote) MyInjector.getEJBr(Permission_Bean.class);
//		material_Remote = (Material_Remote) MyInjector.getEJBr(Material_Bean.class);
//		group_Remote = (Group_Remote) MyInjector.getEJBr(Group_Bean.class);
//		binObj_Remote = (BinObject_Remote) MyInjector.getEJBr(BinObject_Bean.class);
//		uniqueCredencial_Remote = (UniqueCredencial_Remote) MyInjector.getEJBr(UniqueCredencial_Bean.class);
//		resourceRecord_Remote = (ResourceRecord_Remote) MyInjector.getEJBr(ResourceRecord_Bean.class);
//		interfaceType_Remote = (InterfaceType_Remote) MyInjector.getEJBr(InterfaceType_Bean.class);
	}
	
	public void fillDB(){
//		try {
//			
//			//PERMISSIONS
//			permission_Remote.save(new Permission("Super-administrator","logic"));
//			permission_Remote.save(new Permission("Administrator","logic"));
//			permission_Remote.save(new Permission("Human-resource-manager","logic"));
//			permission_Remote.save(new Permission("Material-resource-manager","logic"));
//			permission_Remote.save(new Permission("Default","logic"));
//	
//			
//			//INTERFACE_TYPE
//			interfaceType_Remote.save(new InterfaceType("Bluetooth"));
//			interfaceType_Remote.save(new InterfaceType("Fingerprint"));
//			interfaceType_Remote.save(new InterfaceType("Camera"));
//			interfaceType_Remote.save(new InterfaceType("Wifi"));
//			
//			InterfaceType it1 = interfaceType_Remote.getInterfaceTypeByORMID("Bluetooth");
//			InterfaceType it2 = interfaceType_Remote.getInterfaceTypeByORMID("Fingerprint");
//			InterfaceType it3 = interfaceType_Remote.getInterfaceTypeByORMID("Camera");
//			InterfaceType it4 = interfaceType_Remote.getInterfaceTypeByORMID("Wifi");
//			
//			
//			//MATERIAL (DEVICE_CAPTOR) && UNIQUE_CREDENCIAL
//			ArrayList<Unique_Credencial> credencialList = new ArrayList<Unique_Credencial>();
//			
//			for(int dc_id=1; dc_id<31; dc_id++){	
//				HashSet<Unique_Credencial> credencials = new HashSet<Unique_Credencial>();
//				
//				Material device = new Material("deviceCaptor"+dc_id, "deviceCaptorName"+dc_id, "locationDC"+dc_id, null, credencials, null);
//				material_Remote.save(device);
//				
//				/*
//				Random randType = new Random();
//				int t = randType.nextInt(3);
//				String type = "";
//				if (t==0) type = it1.getID();
//				if (t==1) type = it2.getID();
//				if (t==2) type = it3.getID();
//				if (t==3) type = it4.getID();
//				
//				
//				Unique_Credencial uniqueCredencial = new Unique_Credencial(type+":"+address,interfaceType_Remote.getInterfaceTypeByORMID(type), null, device, null, null);
//				uniqueCredencial_Remote.save(uniqueCredencial);
//				
//				Unique_Credencial unique = new Unique_Credencial();
//				unique = uniqueCredencial_Remote.getUnique_CredencialByORMID(d_id);
//				credencials.add(unique);
//				device.setUnique_credencials(credencials);
//				material_Remote.save(device);
//				d_id++;
//				*/		
//			}
//			
//			
//			//MATERIAL (LIKE PROJECTORS, PC, ETC) && UNIQUE_CREDENCIAL
//			for(int i=1; i<=15; i++){
//				HashSet<Unique_Credencial> uniqueCredencials = new HashSet<Unique_Credencial>();
//				
//				Material material = new Material("material"+i, "materialname"+i, "local"+i, null, uniqueCredencials, null);
//				material_Remote.save(material);
//
//				
//				Random randUC_material = new Random();
//				int uc_material = randUC_material.nextInt(3)+1;
//				
//				for(int uc_m = 0; uc_m<uc_material; uc_m++){
//					/*
//					Random randDeviceID = new Random();
//					int deviceID = randDeviceID.nextInt(30)+1;
//					Material device = material_Remote.getMaterialFetchUnique_credencials("deviceCaptor"+deviceID);
//					
//					InterfaceType interfaceType = new InterfaceType();
//					Set<Unique_Credencial> uniques = device.getUnique_credencials();
//
//					for(Unique_Credencial unique_c:uniques){
//						interfaceType = unique_c.getInterfaceType();
//					}
//					*/
//					
//					Random randType = new Random();
//					int t = randType.nextInt(3);
//					String type = "";
//					if (t==0) type = it1.getID();
//					if (t==1) type = it2.getID();
//					if (t==2) type = it3.getID();
//					if (t==3) type = it4.getID();
//					
//					Random randAddress = new Random();
//					int address = randAddress.nextInt(1000000);
//					
//					HashSet<ResourceRecord> rr = new HashSet<ResourceRecord>();
//					Random rand_r = new Random();
//					int r_i = rand_r.nextInt(3);
//					
//					ArrayList<Date> dates = new ArrayList<Date>();
//					for(int dt=0; dt<r_i; dt++){
//						Random randRR = new Random();
//						int rr_time = randRR.nextInt();
//						dates.add(new Date(System.currentTimeMillis()-rr_time));
//					}
//					
//					ArrayList<Integer> dc = new ArrayList<Integer>();
//					for(int dm=0; dm<r_i; dm++){
//						Random randDC = new Random();
//						int dc_id = randDC.nextInt(30)+1;
//						dc.add(dc_id);
//					}
//					
//					for(int r=0; r<r_i; r++){
//						
//						Material device = new Material();
//						device = material_Remote.getMaterialByORMID("deviceCaptor"+dc.get(r));
//						
//						ResourceRecord resourceRecord = new ResourceRecord(dates.get(r), null, device, device.getLocation());
//						resourceRecord_Remote.save(resourceRecord);
//						
//						rr.add(resourceRecord);
//					}
//					
//					
//					Unique_Credencial uniqueCredencial = new Unique_Credencial(type+":"+address, interfaceType_Remote.getInterfaceTypeByORMID(type), null, material, rr);
//					uniqueCredencial_Remote.save(uniqueCredencial);
//					
//					uniqueCredencials.add(uniqueCredencial);
//					credencialList.add(uniqueCredencial);
//				}
//				
//				material.setUnique_credencials(uniqueCredencials);
//				material_Remote.save(material);
//			}
//			
//			//USER && UNIQUE_CREDENCIAL
//			Permission perm1 = permission_Remote.getPermissionByORMID("Super-administrator");
//			Permission perm2 = permission_Remote.getPermissionByORMID("Administrator");
//			Permission perm3 = permission_Remote.getPermissionByORMID("Human-resource-manager");
//			Permission perm4 = permission_Remote.getPermissionByORMID("Material-resource-manager");
//			Permission perm5 = permission_Remote.getPermissionByORMID("Default");
//			
//			HashSet<Permission> permissions = new HashSet<Permission>();
//			permissions.add(perm1);
//			permissions.add(perm2);
//			permissions.add(perm3);
//			permissions.add(perm4);
//			permissions.add(perm5);
//			
//			HashSet<Material> admin_owned = new HashSet<Material>();
//			for(int i=1; i<=15; i++){
//				admin_owned.add(material_Remote.getMaterialByORMID("material"+i));
//			}
//			
//			Random randtel_admin = new Random();
//			int tel_admin = randtel_admin.nextInt(899999)+100000;
//			
//			User admin = new User("admin", "useradmin", "DI", admin_owned, null, null, null, "admin", permissions, "adminlink", "adminPersonalID", "Universidade do Minho", "253"+tel_admin,"admin@mail.com");
//			user_Remote.save(admin);
//			
//			for(int i=1; i<=10; i++){
//				HashSet<Permission> user_permissions = new HashSet<Permission>();
//				for(int m=0; m<3; m++){
//					Random r = new Random();
//					int j = r.nextInt(5);
//					int k = 0;
//					for(Permission p:permissions){
//						if (k==j) user_permissions.add(p);
//						k++;
//					}
//				}
//				
//	
//				Random randtel = new Random();
//				int tel = randtel.nextInt(899999)+100000;
//				
//				HashSet<Material> ownedResources = new HashSet<Material>();
//				
//				for(int o=0; o<3; o++){
//					Random randOwned = new Random();
//					int owned = randOwned.nextInt(15)+1;
//					ownedResources.add(material_Remote.getMaterialByORMID("material"+owned));
//				}
//				
//				HashSet<Material> lentResources = new HashSet<Material>();
//				
//				
//				for(int l=0; l<3; l++){
//					Random randLent = new Random();
//					int lent = randLent.nextInt(15)+1;
//					Material mat = new Material();
//					mat = material_Remote.getMaterialByORMID("material"+lent);
//					
//					boolean equals = false;
//					for(Material m:ownedResources){
//						if (m.getID().equals(mat.getID())) equals = true;
//					}
//					if (!equals)
//						lentResources.add(mat);
//					equals = false;
//				}
//				
//				HashSet<Unique_Credencial> uniqueCredencials = new HashSet<Unique_Credencial>();
//				
//				User user = new User("user"+i, "username"+i, "local"+i, ownedResources, uniqueCredencials, lentResources, null, "123", user_permissions, "link"+i, "personal_ID"+i, "address"+i, "253"+tel,"user"+i+"@mail.com");
//				
//				user_Remote.save(user);
//
//				Random randUC_user = new Random();
//				int uc_user = randUC_user.nextInt(5)+1;
//				
//				for(int uc_u = 0; uc_u<uc_user; uc_u++){
//					/*Random randDeviceID = new Random();
//					int deviceID = randDeviceID.nextInt(30)+1;
//					Material device = material_Remote.getMaterialFetchUnique_credencials("deviceCaptor"+deviceID);
//					
//					
//					InterfaceType interfaceType = new InterfaceType();
//					Set<Unique_Credencial> uniques = device.getUnique_credencials();
//
//					for(Unique_Credencial unique_c:uniques){
//						interfaceType = unique_c.getInterfaceType();
//					}
//					
//					Unique_Credencial uniqueCredencial = new Unique_Credencial(interfaceType, null, user, device, null);
//					uniqueCredencial_Remote.save(uniqueCredencial);
//					
//					uniqueCredencials.add(uniqueCredencial_Remote.getUnique_CredencialByORMID(d_id));
//					*/
//					Random randType = new Random();
//					int t = randType.nextInt(3);
//					String type = "";
//					if (t==0) type = it1.getID();
//					if (t==1) type = it2.getID();
//					if (t==2) type = it3.getID();
//					if (t==3) type = it4.getID();
//					
//					Random randAddress = new Random();
//					int address = randAddress.nextInt(1000000);
//					
//					HashSet<ResourceRecord> rr = new HashSet<ResourceRecord>();
//					Random rand_r = new Random();
//					int r_i = rand_r.nextInt(3);
//					
//					ArrayList<Date> dates = new ArrayList<Date>();
//					for(int dt=0; dt<r_i; dt++){
//						Random randRR = new Random();
//						int rr_time = randRR.nextInt();
//						dates.add(new Date(System.currentTimeMillis()-rr_time));
//					}
//					
//					ArrayList<Integer> dc = new ArrayList<Integer>();
//					for(int dm=0; dm<r_i; dm++){
//						Random randDC = new Random();
//						int dc_id = randDC.nextInt(30)+1;
//						dc.add(dc_id);
//					}
//					
//					for(int r=0; r<r_i; r++){
//						
//						Material device = new Material();
//						device = material_Remote.getMaterialByORMID("deviceCaptor"+dc.get(r));
//						
//						ResourceRecord resourceRecord = new ResourceRecord(dates.get(r), null, device, device.getLocation());
//						resourceRecord_Remote.save(resourceRecord);
//						
//						rr.add(resourceRecord);
//					}
//					
//					Unique_Credencial uniqueCredencial = new Unique_Credencial(type+":"+address, interfaceType_Remote.getInterfaceTypeByORMID(type), null, user, rr);
//					uniqueCredencial_Remote.save(uniqueCredencial);
//					
//					uniqueCredencials.add(uniqueCredencial);
//					credencialList.add(uniqueCredencial);
//				}
//				
//				user.setUnique_credencials(uniqueCredencials);
//				user_Remote.save(user);
//			}
//			
//			
//			//GROUP
//			for(int i_group=1; i_group<6; i_group++){
//				HashSet<Abstract_Resource> ars = new HashSet<Abstract_Resource>();
//				for(int ug=0; ug<6; ug++){
//					Random randUsersGroup = new Random();
//					int user_group = randUsersGroup.nextInt(10)+1;
//					
//					ars.add(user_Remote.getUserByORMID("user"+user_group));
//				}
//				
//				for(int mg=0; mg<6; mg++){
//					Random randMaterialsGroup = new Random();
//					int material_group = randMaterialsGroup.nextInt(15)+1;
//					
//					ars.add(material_Remote.getMaterialByORMID("material"+material_group));
//				}
//				
//				HashSet<Permission> group_permissions = new HashSet<Permission>();
//				
//				for(int pg=0; pg<4; pg++){
//					Random randPermissionsGroup = new Random();
//					int permission_group = randPermissionsGroup.nextInt(5);
//					
//					group_permissions.add(((Permission) permissions.toArray()[permission_group]));
//				}
//				
//				Group group = new Group("group"+i_group, group_permissions, ars);
//				group_Remote.save(group);
//			}
//			
//			/*//RESOURCERECORD
//			TreeSet<Date> dates = new TreeSet<Date>();
//			for(int r=0; r<1000; r++){
//				Random randRR = new Random();
//				int rr = randRR.nextInt();
//				dates.add(new Date(System.currentTimeMillis()-rr));
//			}
//			
//			for(Date d:dates){
//				Random randUC = new Random();
//				int uc_id = randUC.nextInt(credencialList.size());
//				Unique_Credencial uc = credencialList.get(uc_id);
//				
//				Random randDC = new Random();
//				int dc = randDC.nextInt(30)+1;
//				
//				Material device = new Material();
//				device = material_Remote.getMaterialByORMID("deviceCaptor"+dc);
//				
//				ResourceRecord resourceRecord = new ResourceRecord(d, uc, device, device.getLocation());
//				resourceRecord_Remote.save(resourceRecord);
//				
//				HashSet<ResourceRecord> ucs = new HashSet<ResourceRecord>();
//				ucs = new HashSet<ResourceRecord>(uc.getResourceRecords());
//				ucs.add(resourceRecord);
//				uc.setResourceRecords(ucs);
//				
//				uniqueCredencial_Remote.save(uc);
//			}*/
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}
	
//	public void action1() {
//		System.out.println("ACTION1");
//		fillDB();
//
//		try {
//		
//			User u = user_Remote.validateLogin("user1", "123");
//			
//			System.out.println(u);
//			System.out.println(u.getName());
//			System.out.println(u.getUser_permissions().size());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//	}
//	
//	public void action2() {
//		System.out.println("ACTION2");
//		try {
//			User u = user_Remote.getUserFetchPermissions("user1");
//			System.out.println(u);
//			System.out.println(u.getName());
//			for( Object p : u.getUser_permissions() ){
//				Permission per = (Permission) p;
//				System.out.println(per.getID()+ ":"+ per.getType());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public void action3() {
//		System.out.println("ACTION3");
//		user_Remote.initIterator(null,"ID");
//		while(user_Remote.hasNext())
//			System.out.println(user_Remote.next().getID());
//	}
//	
//	public void action4() {
//		System.out.println("ACTION4");
//		String c1 = "'Administrator'= any elements (User.user_permissions))";
//		user_Remote.initIterator("user_permissions | unique_credencials",c1,null);
//		int i = user_Remote.alterSize(c1);
//		System.out.println(i);
//		while(user_Remote.hasNext()) {
//			User u = user_Remote.next();
//			System.out.println(u.getID());
//			System.out.println(u.getUser_permissions().size());
//			System.out.println(u.getUnique_credencials().size());
//		}
//			
//	}
//	
//	public void action5() {
//		System.out.println("ACTION5");
//		try {
//			User user =user_Remote.getUserFetch("user1","user_permissions|unique_credencials");
//
//			System.out.println(user.getID());
//			for (Object p : user.getUser_permissions())
//				System.out.println(((Permission)p).getID());
//			for (Object p : user.getUnique_credencials()){
//				System.out.println(((Unique_Credencial)p).getID());
//				System.out.println("ui");
//				System.out.println( ((Unique_Credencial)p).getIdentifyed_Resource().getID() );
//			}
//						
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public void action6() {
//		System.out.println("ACTION6");
//		String lastseentime = "2009-12-02T17:33:16.828125+00:00"; 
//		String routerid="deviceCaptor555";
//		String userid="user555";
//		String username="artur faísca";
//		String deviceClass="Bluetooth";
//		try {
//			resourceRecord_Remote.putResourceRecord(lastseentime,routerid,userid,username,deviceClass);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void action7() {
//		System.out.println("ACTION7");
//		try {
//
//			//resourceRecord_Remote.initIterator(null, 
//				//	"ResourceRecord.uniqueDeviceID.identifyed_Resource='user666'", null);
//			
//			resourceRecord_Remote.initResourceRecords("user1");
//			System.out.println("ID\tdata\tidentifyedResource\tCaptorId\tIterfaceType\tLocation");
//			
//			
//			while(resourceRecord_Remote.hasNext()) {
//				
//				ResourceRecord r = resourceRecord_Remote.next();
//				System.out.println(r.getUniqueDeviceID().getID() +"\t"+r.getLastSeenTime()
//						+"\t"+r.getUniqueDeviceID().getIdentifyed_Resource().getID()
//						+"\t"+r.getUniqueDeviceID().getInterfaceType().getID()
//						+"\t"+r.getLocation() );
//			}
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void action8() {
//		System.out.println("ACTION8");
//		try {
///*
//			Object o =resourceRecord_Remote.createQuery("Select Count(distinct u) From User as u where 'Administrator'= any elements (u.user_permissions))");
//			
//			System.out.println(new Long((Long)o));
//			
//			Object[] us = resourceRecord_Remote.createQuery2("Select distinct User  From User as User left join fetch User.user_permissions where User.id='user1'").toArray();
//			
//			System.out.println(us.length);
//			System.out.println( ((User) us[0]).getID() );
//			System.out.println( ((User) us[1]).getID() );
//			*/
//			
//			Object[] us = resourceRecord_Remote.createQuery2("Select distinct User From User as User left join fetch User.user_permissions left join fetch User.unique_credencials Order By User.ID").toArray();
//			
//			System.out.println(us.length);
//			System.out.println( ((User) us[0]).getID() );
//			System.out.println( ((User) us[1]).getID() );
//			System.out.println( ((User) us[1]).getUser_permissions().size() );
//			
//			
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void action9() {
//		try {
//			Date t1,t2;
//			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			t1 = new Date("1/10/2010 04:03:51");
//			
//			t2 = new Date("1/12/2010 6:0:0");
//			resourceRecord_Remote.alterSize("uniqueDeviceID.identifyed_Resource='user1'");
//			
//			System.out.println(ft.format(t1));
//			System.out.println(ft.format(t2));
//			
//
//			resourceRecord_Remote.initResourceRecords("material1", t1);
//
//			
//			System.out.println("ID\tdata\tidentifyedResource\tCaptorId\tIterfaceType\tLocation");
//			System.out.println(resourceRecord_Remote.getSize());
//						
//			while(resourceRecord_Remote.hasNext()) {
//				
//				ResourceRecord r = resourceRecord_Remote.next();
//				System.out.println(r.getUniqueDeviceID().getID()+"\t"+r.getLastSeenTime()
//						+"\t"+r.getUniqueDeviceID().getIdentifyed_Resource().getID()
//						+"\t"+r.getUniqueDeviceID().getInterfaceType().getID()
//						+"\t"+r.getLocation() );
//			}
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		
//	}
//	
//	
//	public void action10() {
//		try {
//
//			
//			resourceRecord_Remote.initIterator();
//			System.out.println(resourceRecord_Remote.getSize());
//			while(resourceRecord_Remote.hasNext()) {
//				
//				ResourceRecord r = resourceRecord_Remote.next();
//				
//				if(r.getUniqueDeviceID()!=null) {
//					
//				
//				System.out.println(r.getUniqueDeviceID().getID()+"\t"+r.getLastSeenTime()
//						+"\t"+r.getUniqueDeviceID().getIdentifyed_Resource().getID()
//						+"\t"+r.getUniqueDeviceID().getInterfaceType().getID()
//						+"\t"+r.getLocation() ); }
//			}
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		
//	}
	
	
}