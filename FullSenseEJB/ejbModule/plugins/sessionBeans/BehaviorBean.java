package plugins.sessionBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import core.entityBeans.TrackingLog;
import plugins.entityBeans.Behavior;
import plugins.entityBeans.Bundle;
import plugins.entityBeans.Method;
import plugins.sessionBeans.interfaces.BehaviorBeanLocal;
import plugins.sessionBeans.interfaces.BehaviorBeanRemote;
import plugins.util.Pair;
import plugins.util.PersistablePlugin;


@Stateless
public class BehaviorBean implements BehaviorBeanRemote, BehaviorBeanLocal {

    @PersistenceContext
    private Session s;

    public BehaviorBean() {
    }
    
	public <PP extends PersistablePlugin> PP create(PP p) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.save(p);
			tx.commit();
			return p;
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
	}

	public <PP extends PersistablePlugin> boolean update(PP p) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.update(p);
			tx.commit();
			return true;
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
	}

	public <PP extends PersistablePlugin> boolean delete(PP p) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			s.refresh(p);
			s.delete(p);
			tx.commit();
			return true;
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Bundle> getAllBundles() throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			List<Bundle> lb = (List<Bundle>)s.getNamedQuery("Bundle.getAll").list();
			tx.commit();
			return lb;
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Behavior> getAllBehaviors(int bundleId, int sourceId) throws Exception {
		List<Behavior> lb = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			lb = (List<Behavior>)(s.getNamedQuery("Behavior.getAll")
					.setInteger("sid",sourceId)
					.list()
				);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return lb;
	}

	@SuppressWarnings("unchecked")
	public List<Method> getAllConditionMethods(String type) throws Exception {
		List<Method> lm = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			lm = (List<Method>)(s.getNamedQuery("Method.getCondition")
					.setString("bundleName","ConditionService")
					.setString("type",type+Pair.TAB+true)
					.list()
				);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return lm;
	}

	@SuppressWarnings("unchecked")
	public List<TrackingLog> getRecords(Date begin, Date end) throws Exception {
		List<TrackingLog> ltl = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			ltl = (List<TrackingLog>)(s.getNamedQuery("getRecords")
					.setDate("begin",begin)
					.setDate("end",end)
					.list()
					);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw(e);
		}
		return ltl;
	}
	
	public<C> int countPossibleValues(Class<C> c) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			int res = ((Integer)(s.createCriteria(c)
					.setProjection(Projections.rowCount())
					.uniqueResult())).intValue();
			tx.commit();
			return res;
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw e;
		}
	}	

	@SuppressWarnings("unchecked")
	public<C> List<C> getPossibleValues(Class<C> c, int offSet, int rowCount) throws Exception {
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			List<C> lc = (List<C>)(s.createCriteria(c)
				.setFirstResult(offSet)
				.setMaxResults(rowCount)
				.list());
			tx.commit();
			return lc;
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public <PP extends PersistablePlugin> PP read(Class<PP> c, Serializable id) throws Exception {
		PP p = null;
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			p = (PP)s.load(c,id);
			tx.commit();
			return p;
		}
		catch(Exception e){
			if(tx!=null) tx.rollback();
			throw e;
		}
	}

}
