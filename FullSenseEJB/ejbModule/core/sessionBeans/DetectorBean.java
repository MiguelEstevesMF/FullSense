package core.sessionBeans;

import java.util.Date;
import java.util.List;

import core.entityBeans.Detector;
import core.entityBeans.IdentifiableResource;
import core.entityBeans.Identifier;
import core.entityBeans.Protocol;
import core.entityBeans.Resource;
import core.entityBeans.ResourceIdentifier;
import core.entityBeans.StationaryResource;
import core.entityBeans.SystemLogResource;
import core.entityBeans.SystemLogUser;
import core.entityBeans.User;
import core.entityBeans.UserIdentifier;
import core.entityBeans.SystemLog.SLType;
import core.sessionBeans.interfaces.DetectorBeanLocal;
import core.sessionBeans.interfaces.DetectorBeanRemote;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Session Bean implementation class DetectorBean
 */
@Stateless
public class DetectorBean implements DetectorBeanRemote, DetectorBeanLocal {

	
	@PersistenceContext
	Session s;
	
    /**
     * Default constructor. 
     */
    public DetectorBean() {
        // TODO Auto-generated constructor stub
    }
    
	
    public Protocol readProtocol(String id) throws Exception {
		Protocol u = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			u = (Protocol)(s.get(Protocol.class, id));
			tx.commit();
		}
		catch (Exception e) {
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return u;
	}
    
	public boolean create(Protocol protocol) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.save(protocol);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}
	
	public int countProtocols() throws Exception{
		int res = 0;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();	
			res = ((Long)(s.getNamedQuery("Protocol.countProtocols")
					.uniqueResult()))
					.intValue();
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return res;
	}
	
	public boolean drop(Protocol protocol) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.refresh(protocol);
			s.delete(protocol);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Protocol> listProtocols(int offSet, int rowCount) throws Exception{
		List<Protocol> lp = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			lp = (List<Protocol>)(s.getNamedQuery("Protocol.getProtocols")
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
	//count, list, create, drop - protocol


	public int countDetectors() throws Exception {
		int res = 0;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();	
			res = ((Long)(s.getNamedQuery("Detector.countDetectors")
					.uniqueResult()))
					.intValue();
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return res;
	}


	public int countIdentifiers() throws Exception {
		int res = 0;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();	
			res = ((Long)(s.getNamedQuery("Identifier.countIdentifiers")
					.uniqueResult()))
					.intValue();
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return res;
	}

	public Identifier readIdentifier(String id) throws Exception {
		Identifier u = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			u = (Identifier)(s.get(Identifier.class, id));
			tx.commit();
		}
		catch (Exception e) {
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return u;
	}
	
	public Detector readDetector(String id) throws Exception {
		Detector u = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			u = (Detector)(s.get(Detector.class, id));
			tx.commit();
		}
		catch (Exception e) {
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return u;
	}

	public boolean create(Identifier identifier) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.save(identifier);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}


	public boolean create(Detector detector) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.save(detector);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}


	public boolean drop(Identifier identifier) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.refresh(identifier);
			s.delete(identifier);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}


	public boolean drop(Detector detector) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.refresh(detector);
			s.delete(detector);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}


	@SuppressWarnings("unchecked")
	public List<Detector> listDetectors(int offSet, int rowCount) throws Exception {
		List<Detector> lp = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			lp = (List<Detector>)(s.getNamedQuery("Detector.getDetectors")
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
	public List<Identifier> listIdentifiers(int offSet, int rowCount) throws Exception {
		List<Identifier> lp = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();		
			lp = (List<Identifier>)(s.getNamedQuery("Identifier.getIdentifiers")
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


	public boolean update(Identifier identifier) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.update(identifier);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}


	public boolean update(Detector detector) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.update(detector);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return true;
	}

	
	public boolean validatePermission(Identifier identifier, StationaryResource stationaryResource,  boolean defaultValue , boolean createSystemLog, boolean filterActive) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.refresh(identifier);

			if(identifier instanceof UserIdentifier) { 
				User user = ((UserIdentifier) identifier).getUser();
				
				int res = ( (Long)(s.getNamedQuery("User.countPermissionWithStationaryResource")
							.setBoolean("filter",filterActive)
							.setString("srid",stationaryResource.getId())
							.setString("uid",user.getUser())
							.uniqueResult()	) ).intValue();
				
				if(res>0) return true;
				else {
					if(createSystemLog==true) {
						SystemLogUser slu = new SystemLogUser();
						slu.setTime(new Date());
						slu.setType(SLType.PHYSICALACCESSDENIED);
						slu.setDesc("identifier: "+identifier.getId());
						user.getSystemLogUsers().add(slu);
						s.save(user);
					}
					return false;
				}
			}
			
			if(identifier instanceof ResourceIdentifier) { 
				Resource resource = ((ResourceIdentifier) identifier).getIdentifiableResource();
				
				int res = ( (Long)(s.getNamedQuery("IdentifiableResource.countPermissionWithStationaryResource")
							.setBoolean("filter",filterActive)
							.setString("srid",stationaryResource.getId())
							.setString("irid",resource.getId())
							.uniqueResult()	) ).intValue();
				
				if(res>0) return true;
				else {
					if(createSystemLog==true) {
						SystemLogResource slr = new SystemLogResource();
						slr.setTime(new Date());
						slr.setType(SLType.PHYSICALACCESSDENIED);
						slr.setDesc("identifier: "+identifier.getId());
						resource.getSystemLogResources().add(slr);
						s.save(resource);
					}
					return false;
				}
			}
			
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return defaultValue;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Identifier> listUnlinkIdentifiers(String protocol, Date begin, Date end) throws Exception{
		List<Identifier> li = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			li = (List<Identifier>)(s.getNamedQuery("Identifier.unlinked")
					.setString("protocol",protocol)
					.setDate("begin",begin)
					.setDate("end",end)
					.list());
			tx.commit();
			return li;
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public<T extends Identifier> T changeTo(Identifier i,Class<T> nc, String id) throws Exception{
		Transaction tx = null;
		T t = null;
		try{
			tx = s.beginTransaction();
			s.evict(i);
			s.createQuery("UPDATE Identifier SET Discriminator="+nc.getSimpleName()+" WHERE id='"+i.getId()+"'").executeUpdate();
			t = (T) s.get(nc,i.getId());
			if(t instanceof UserIdentifier){
				((UserIdentifier)t).setUser((User)s.get(User.class,id));
			}
			if(t instanceof ResourceIdentifier){
				((ResourceIdentifier)t).setIdentifiableResource((IdentifiableResource)s.load(IdentifiableResource.class,id));
			}
			s.update(t);
			tx.commit();
			return t;
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
	}


	public int readDetectorFloor(String id) throws Exception {
		Detector detector = readDetector(id);
		if(detector!=null){
			return detector.getArea().getFloor();
		}
		return -1;
	}


	public String readDetectorResourceId(String id) throws Exception {
		Detector detector = readDetector(id);
		if(detector!=null && detector.getArea() !=null && detector.getArea().getStationaryResource() !=null){
		     
			return detector.getArea().getStationaryResource().getId();
		}
		return "NOT FOUND";
	}


	public boolean validatePermission(String identifier, String stationaryResource, boolean defaultValue , boolean createSystemLog, boolean filterActive) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			Identifier i = (Identifier) s.load(Identifier.class, identifier);
			StationaryResource sr = (StationaryResource) s.load(StationaryResource.class,stationaryResource);
			
			return validatePermission(i, sr, defaultValue ,createSystemLog, filterActive);
			
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
	}

}
