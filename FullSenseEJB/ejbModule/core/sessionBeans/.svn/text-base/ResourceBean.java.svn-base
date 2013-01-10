package core.sessionBeans;

import java.util.Date;
import java.util.List;

import core.entityBeans.IdentifiableResource;
import core.entityBeans.Permission;
import core.entityBeans.PermissionGroup;
import core.entityBeans.Request;
import core.entityBeans.Resource;
import core.entityBeans.StationaryResource;
import core.entityBeans.SystemLogResource;
import core.entityBeans.Type;
import core.entityBeans.User;
import core.entityBeans.Request.ReqState;
import core.entityBeans.SystemLog.SLType;
import core.sessionBeans.interfaces.ResourceBeanLocal;
import core.sessionBeans.interfaces.ResourceBeanRemote;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Session Bean implementation class ResourceBean
 */
@Stateless
public class ResourceBean implements ResourceBeanRemote, ResourceBeanLocal {


	@PersistenceContext
	Session s;
	 
	
	public boolean create(Resource resource) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			SystemLogResource slr = new SystemLogResource();
			slr.setTime(new Date());
			slr.setType(SLType.INSERT);
			resource.getSystemLogResources().add(slr);
			s.save(resource);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}

	public boolean delete(Resource resource) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			resource.getRequests().clear();
			resource.getPermissions().clear();
			SystemLogResource slr = new SystemLogResource();
			slr.setTime(new Date());
			slr.setType(SLType.DELETE);
			resource.getSystemLogResources().add(slr);
			resource.setActive(false);
			s.update(resource);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;	
	}
	
	@SuppressWarnings("unchecked")
	public boolean drop(Resource resource) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.refresh(resource);
			List<SystemLogResource> lslr = (List<SystemLogResource>)(s.getNamedQuery("Resource.getSystemLogResource")
					.setString("id",resource.getId())
					.list());
			for(SystemLogResource slr : lslr){
				slr.setResource(null);
				s.update(slr);
			}
			s.delete(resource);
			SystemLogResource slr = new SystemLogResource();
			slr.setTime(new Date());
			slr.setType(SLType.DROP);
			s.save(slr);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}
	
	public boolean update(Resource resource) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			SystemLogResource slr = new SystemLogResource();
			slr.setResource(resource);
			slr.setTime(new Date());
			slr.setType(SLType.UPDATE);
			s.update(resource);
			s.save(slr);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}
	
	public boolean update(Resource resource, Request request, Permission permission) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.update(resource);
			SystemLogResource slr = new SystemLogResource();
			slr.setTime(new Date());
			slr.setType(SLType.UPDATE);
			slr.setDesc(resource.getId()+" : "+resource.getName());
			resource.getSystemLogResources().add(slr);
			if(request!=null) { s.saveOrUpdate(request); resource.getRequests().add(request); }
			if(permission!=null) { s.saveOrUpdate(permission); resource.getPermissions().add(permission); }
			s.update(resource);
			s.save(slr);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}
	
	
	public int countResources(String resourceId, String type, Date begin, Date end, boolean filterActive) throws Exception {
		int res = 0;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();	
			if(resourceId==null && type==null)
				res = ( (Long)(s.getNamedQuery("Resource.countActiveResources++")
						.setBoolean("filter",filterActive)
						.setParameter("begin",begin)
						.setParameter("end",end)
						.uniqueResult()	) ).intValue();
			if(resourceId==null && type!=null)
				res = ( (Long)(s.getNamedQuery("Resource.countActiveResources++ByType")
						.setBoolean("filter",filterActive)
						.setString("type",type)
						.setParameter("begin",begin)
						.setParameter("end",end)
						.uniqueResult()	) ).intValue();
			if(resourceId!=null && type==null)
				res = ( (Long)(s.getNamedQuery("Resource.countActiveResources++ByRID")
						.setBoolean("filter",filterActive)
						.setString("resourceId",resourceId)
						.setParameter("begin",begin)
						.setParameter("end",end)
						.uniqueResult()	) ).intValue();
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Resource> listResources(String resourceId, String type, Date begin, Date end, boolean filterActive, int offSet, int rowCount) throws Exception {
		List<Resource> lr = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			if(resourceId==null && type==null)
				lr = (List<Resource>)(s.getNamedQuery("Resource.getActiveResources++")
						.setBoolean("filter",filterActive)
						.setParameter("begin",begin)
						.setParameter("end",end)
						.setFirstResult(offSet)
						.setMaxResults(rowCount)
						.list()
					);
			if(resourceId==null && type!=null)
				lr = (List<Resource>)(s.getNamedQuery("Resource.getActiveResources++ByType")
						.setBoolean("filter",filterActive)
						.setString("type",type)
						.setParameter("begin",begin)
						.setParameter("end",end)
						.setFirstResult(offSet)
						.setMaxResults(rowCount)
						.list()
					);
			if(resourceId!=null)
				lr = (List<Resource>)(s.getNamedQuery("Resource.getActiveResources++ByRID")
						.setBoolean("filter",filterActive)
						.setString("resourceId",resourceId)
						.setParameter("begin",begin)
						.setParameter("end",end)
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
		return lr;
	}
	
	
	public int countResources(boolean filterActive) throws Exception{
		int res = 0;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();	
			res = ( (Long)(s.getNamedQuery("Resource.countActiveResources")
					.setBoolean("filter",filterActive)
					.uniqueResult()	) ).intValue();
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Resource> listResources(boolean filterActive, int offSet, int rowCount) throws Exception{
		List<Resource> lr = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			lr = (List<Resource>)(s.getNamedQuery("Resource.getActiveResources")
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
		return lr;
	}
	
	public int countIdentifiableResources(boolean filterActive) throws Exception{
		int res = 0;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();	
			res = ( (Long)(s.getNamedQuery("Resource.countIdentifiableResources")
					.setBoolean("filter",filterActive)
					.uniqueResult()	) ).intValue();
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<IdentifiableResource> listIdentifiableResources(boolean filterActive, int offSet, int rowCount) throws Exception{
		List<IdentifiableResource> lr = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			lr = (List<IdentifiableResource>)(s.getNamedQuery("Resource.getIdentifiableResources")
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
		return lr;
	}
	
	
	public int countStationaryResources(boolean filterActive) throws Exception{
		int res = 0;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();	
			res = ( (Long)(s.getNamedQuery("Resource.countStationaryResources")
					.setBoolean("filter",filterActive)
					.uniqueResult()	) ).intValue();
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<StationaryResource> listStationaryResources(boolean filterActive, int offSet, int rowCount) throws Exception{
		List<StationaryResource> lr = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			lr = (List<StationaryResource>)(s.getNamedQuery("Resource.getStationaryResources")
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
		return lr;
	}
	
	
	public Resource readResource(String id) throws Exception {
		Resource u = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			u = (Resource)(s.get(Resource.class, id));
			tx.commit();
		}
		catch (Exception e) {
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return u;
	}
	
	public Resource readResourceFetchPermissions(String id) throws Exception {
		Resource r = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			r = (Resource)(s.getNamedQuery("Resource.getResourceFetchPermissions")
					.setString("id",id)
					.uniqueResult());
			tx.commit();
		}
		catch (Exception e) {
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return r;
	}
	
	public Resource readResourceFetchRequests(String id) throws Exception {
		Resource r = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			r = (Resource)(s.getNamedQuery("Resource.getResourceFetchRequests")
					.setString("id",id)
					.uniqueResult());
			tx.commit();
		}
		catch (Exception e) {
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return r;
	}
	
	
	///////////////////////////////////////////////////////////////////////////////
	
	public int countTypes() throws Exception{
		int res = 0;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();	
			res = ( (Long)(s.getNamedQuery("Type.countTypes")
					.uniqueResult()	) ).intValue();
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Type> listTypes(int offSet, int rowCount) throws Exception{
		List<Type> lt = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			lt = (List<Type>)(s.getNamedQuery("Type.getTypes")
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
		return lt;
	}
	
	
	
	public boolean create(Type type) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.save(type);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}
	

	public boolean drop(Type type) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.refresh(type);
			s.delete(type);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}

	public Type readType(String id) throws Exception {
		Type u = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			u = (Type)(s.get(Type.class, id));
			tx.commit();
		}
		catch (Exception e) {
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return u;
	}
	
	
	///////////////////////////////////////////////////////////////////////////////
	
	public int countPermissions() throws Exception {
		int res = 0;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();	
			res = ( (Long)(s.getNamedQuery("Permission.countPermissions")
					.uniqueResult()	) ).intValue();
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Permission> listPermissions(int offSet, int rowCount) throws Exception {
		List<Permission> lp = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			lp = (List<Permission>)(s.getNamedQuery("Permission.getPermissions")
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
		return lp;
	}
	
	@SuppressWarnings("unchecked")
	public List<Permission> getPermissions(Resource r, User u) throws Exception {
		List<Permission> lp = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			lp = (List<Permission>)(s.getNamedQuery("Permission.getPermissionsFromUserResource")
					.setString("r_id", r.getId())
					.setString("user", u.getUser())
					.list()
				);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return lp;
	}
	
	@SuppressWarnings("unchecked")
	public List<Permission> getPermissions(Resource r) throws Exception {
		List<Permission> lp = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			lp = (List<Permission>)(s.getNamedQuery("Permission.getPermissionsFromResource")
					.setString("r_id", r.getId())
					.list()
				);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return lp;
	}
	
	@SuppressWarnings("unchecked")
	public List<Permission> getPermissions(Resource r, PermissionGroup pg) throws Exception {
		List<Permission> lp = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			lp = (List<Permission>)(s.getNamedQuery("Permission.getPermissionsFromResourcePermissionGroup")
					.setString("r_id", r.getId())
					.setString("pg_id", pg.getId())
					.list()
				);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return lp;
	}
	
	@SuppressWarnings("unchecked")
	public List<PermissionGroup> getPermissionGroups(Permission p) throws Exception {
		List<PermissionGroup> lpg = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			lpg = (List<PermissionGroup>)(s.getNamedQuery("PermissionGroup.getPermissionGroupsFromPermission")
					.setInteger("p_id", p.getId())
					.list()
				);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return lpg;
	}
	
	
	
	public boolean create(Permission permission) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.save(permission);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}
	
	public boolean drop(Permission permission)throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.refresh(permission);
			s.delete(permission);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}
	
	public boolean update(Permission permission) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.update(permission);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}
	
	public boolean update(Permission permission, PermissionGroup permissionGroup) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.update(permission);
			if(permissionGroup!=null) { s.saveOrUpdate(permissionGroup); permission.getPermissionGroups().add(permissionGroup); }
			s.update(permission);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}
	
	public Permission readPermission(int id) throws Exception {
		Permission u = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			u = (Permission)(s.get(Permission.class, id));
			tx.commit();
		}
		catch (Exception e) {
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return u;
	}
	
	public Permission readPermissionFetchPermissionGroups(int id) throws Exception {
		Permission p = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			p = (Permission)(s.getNamedQuery("Permission.getPermissionFetchPermissionGroups")
					.setInteger("id",id)
					.uniqueResult());
			tx.commit();
		}
		catch (Exception e) {
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return p;
	}
	
	
	///////////////////////////////////////////////////////////////////////////////
	
	public int countRequests() throws Exception{
		int res = 0;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();	
			res = ( (Long)(s.getNamedQuery("Request.countRequests")
					.uniqueResult()	) ).intValue();
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Request> listRequests(int offSet, int rowCount) throws Exception{
		List<Request> lr = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			lr = (List<Request>)(s.getNamedQuery("Request.getRequests")
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
		return lr;
	}
	
	public boolean create(Request request) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.save(request);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}
	public boolean drop(Request request)throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.refresh(request);
			s.delete(request);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}
	
	public boolean update(Request request) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.update(request);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}
	
	public Request readRequest(int id) throws Exception { 
		Request u = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			u = (Request)(s.get(Request.class, id));
			tx.commit();
		}
		catch (Exception e) {
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return u;
	}

	public String getUserIdByResourceId(String rid) throws Exception {
		Transaction tx = null;
		String ss="";
		try{
			tx = s.beginTransaction();		
			ss = (String)(s.getNamedQuery("Resource.getUser")
					.setString("id", rid)
					.uniqueResult()
				);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return ss;
	}
	
	
}
