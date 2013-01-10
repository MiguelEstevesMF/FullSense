package core.sessionBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

import core.entityBeans.*;
import core.entityBeans.SystemLog.SLType;
import core.sessionBeans.interfaces.UserBeanLocal;
import core.sessionBeans.interfaces.UserBeanRemote;


/**
 * Session Bean implementation class UserBean
 */
@Stateless
public class UserBean implements UserBeanRemote, UserBeanLocal {


	@PersistenceContext
	Session s;
	
    public UserBean() {
        // TODO Auto-generated constructor stub
    }
    
    public User login(String userName, String password) throws Exception{
		User u = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			u = (User)(s.getNamedQuery("User.login")
					.setString("user",userName)
					.setString("password",password)
					.uniqueResult());
			Date d = new Date();
			if(u == null){
				SystemLogUser slu = new SystemLogUser();
				slu.setTime(new Date());
				slu.setType(SLType.LOGINFAIL);
				slu.setDesc(userName+"ACCESS DENIED");
				s.save(slu);
			}
			else{
				SystemLogUser slu = new SystemLogUser();
				slu.setTime(new Date());
				slu.setUser(u);
				slu.setType(SLType.LOGIN);
				slu.setDesc(u.getUser()+" : "+u.getName());
				u.getSystemLogUsers().add(slu);
				u.setLastLogin(d);		
				s.update(u);
			}
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}	
		return u;	
	}
    
    public boolean create(User user) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			SystemLogUser slu = new SystemLogUser();
			slu.setTime(new Date());
			slu.setType(SLType.INSERT);
			slu.setDesc(user.getUser()+" : "+user.getName());
			user.getSystemLogUsers().add(slu);
			s.save(user);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}

	public boolean delete(User user) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.refresh(user);
			user.setExpire(new Date());
			user.getPermissionGroups().clear();
			SystemLogUser slu = new SystemLogUser();
			slu.setTime(new Date());
			slu.setType(SLType.DELETE);
			slu.setDesc(user.getUser()+" : "+user.getName());
			user.getSystemLogUsers().add(slu);
			s.update(user);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;	
	}
	
	public boolean drop(User user) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.refresh(user);
			int updt = s.getNamedQuery("User.softDelete").setString("user",user.getUser()).executeUpdate();
			s.delete(user);
			SystemLogUser slu = new SystemLogUser();
			slu.setTime(new Date());
			slu.setType(SLType.DROP);
			slu.setDesc(user.getUser()+" : "+user.getName()+"("+updt+" logs updated)");
			s.save(slu);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}
	
	public boolean update(User user) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.update(user);
			SystemLogUser slu = new SystemLogUser();
			slu.setTime(new Date());
			slu.setType(SLType.UPDATE);
			slu.setDesc(user.getUser()+" : "+user.getName());
			user.getSystemLogUsers().add(slu);
			s.update(user);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}
	
	public boolean update(User user, PermissionGroup permissionGroup, Request request, UserIdentifier userIdentifier) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.update(user);
			SystemLogUser slu = new SystemLogUser();
			slu.setTime(new Date());
			slu.setType(SLType.UPDATE);
			slu.setDesc(user.getUser()+" : "+user.getName());
			user.getSystemLogUsers().add(slu);
			if(permissionGroup!=null) { permissionGroup.getUsers().add(user); s.update(permissionGroup); }
			if(request!=null) { s.saveOrUpdate(request); user.getRequests().add(request); }
			if(userIdentifier!=null) user.getUserIdentifiers().add(userIdentifier);
			s.update(user);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}
    
	public int countUser(boolean filterActive) throws Exception{
		int res = 0;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();	
			res = ((Long)(s.getNamedQuery("User.countUsers")
					.setBoolean("filter",filterActive)
					.uniqueResult()
				)).intValue();
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> listUser(boolean filterActive, int offSet, int rowCount) throws Exception{
		List<User> lu = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			lu = (List<User>)(s.getNamedQuery("User.getUsers")
					.setBoolean("filter",filterActive)
					.setFirstResult(offSet)
					.setMaxResults(rowCount)
					.list()
				);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return lu;
	}

	public boolean create(PermissionGroup pg) throws Exception {
		Transaction tx = null;		
		try{
			tx = s.beginTransaction();
			SystemLog sl = new SystemLogUser();
			sl.setTime(new Date());
			sl.setType(SLType.INSERT);
			sl.setDesc("PermissionGroup: "+pg.getId());
			s.save(pg);
			s.save(sl);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}

	public boolean delete(PermissionGroup pg) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.refresh(pg);
			SystemLog sl = new SystemLogUser();
			sl.setTime(new Date());
			sl.setType(SLType.DROP);
			sl.setDesc("PermissionGroup: "+pg.getId());
			s.delete(pg);
			s.save(sl);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}
	
	public int countPermissionGroup() throws Exception {
		int res = 0;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();	
			res = ((Long)(s.getNamedQuery("PermissionGroup.countPermissionGroups").uniqueResult())).intValue();
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	public List<PermissionGroup> listPermissionGroup(int offSet, int rowCount) throws Exception {
		List<PermissionGroup> lpg = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			lpg = (List<PermissionGroup>)(s.getNamedQuery("PermissionGroup.getPermissionGroups")
					.setFirstResult(offSet)
					.setMaxResults(rowCount)
					.list());
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return lpg;		
	}

	public PermissionGroup readPermissionGroup(String id) throws Exception {
		PermissionGroup pg = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			pg = (PermissionGroup)(s.getNamedQuery("PermissionGroup.getPermissionGroup")
					.setString("name",id)
					.uniqueResult());
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return pg;
		
	}

	public boolean update(PermissionGroup pg) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			SystemLog sl = new SystemLogUser();
			sl.setTime(new Date());
			sl.setType(SLType.UPDATE);
			sl.setDesc("PermissionGroup: "+pg.getId());
			s.update(pg);
			s.save(sl);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}

	public User readUser(String id) throws Exception {
		User u = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			u = (User)(s.getNamedQuery("User.getUser")
					.setString("user",id)
					.uniqueResult());
			tx.commit();
		}
		catch (Exception e) {
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return u;
	}

	public List<Request> readRequestsByUser(String id) throws Exception {
		User u = (User) s.get(User.class, id);
		Transaction tx = null;
		List<Request> lr = null;
		try{
			tx = s.beginTransaction();		
			lr = new ArrayList<Request>(u.getRequests());
			tx.commit();
		}
		catch (Exception e) {
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return lr;
	}
	
	public boolean validateUserInPermissionGroup(String userId, String pgId, boolean filterActive)
			throws Exception {
		
		
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			int res = ( (Long)(s.getNamedQuery("User.countUserInPermissionGroup")
					.setBoolean("filter",filterActive)
					.setString("userId",userId)
					.setString("pgId",pgId)
					.uniqueResult()	) ).intValue();
			tx.commit();
			if(res>0)return true;
			else return false;
		}
		catch (Exception e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			throw(e);
		}
	}
	
	
	public boolean validateResourceInPermissionGroup(String resourceId, String pgId, boolean filterActive) throws Exception {
		
		Transaction tx = null;
	
		try{
			tx = s.beginTransaction();		
			int res = ( (Long)(s.getNamedQuery("Resource.countResourceInPermissionGroup")
					.setBoolean("filter",filterActive)
					.setString("rid",resourceId)
					.setString("pgId",pgId)
					.uniqueResult()	) ).intValue();
			tx.commit();
			if(res>0)return true;
			else return false;
		}
		catch (Exception e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			throw(e);
		}
	}
	
		
	
	public boolean validateIdentifierInPermissionGroup(String identifierId, String pgId, boolean filterActive) throws Exception {
		Transaction tx = null;
		boolean res=false;
	
		Identifier i = null;
		try{
			tx = s.beginTransaction();
			i = (Identifier) s.get(Identifier.class, identifierId);
			tx.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			if(tx!=null) tx.rollback();
		}
		
			tx = null;
			if(i!=null){
			if(i instanceof UserIdentifier) 
				res = validateUserInPermissionGroup(((UserIdentifier)i).getUser().getUser(), pgId, filterActive);
			if(i instanceof ResourceIdentifier) 
				res = validateResourceInPermissionGroup(((ResourceIdentifier)i).getIdentifiableResource().getId(), pgId, filterActive);
			}
	
			return res;

	}

	public List<User> getUsersFromGroup(String group) throws Exception {
		List<User> res = new ArrayList<User>(readPermissionGroup(group).getUsers());
		return res;
	}

}
