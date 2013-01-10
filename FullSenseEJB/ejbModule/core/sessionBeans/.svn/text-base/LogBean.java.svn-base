package core.sessionBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.entityBeans.Detector;
import core.entityBeans.IdentifiableResource;
import core.entityBeans.Identifier;
import core.entityBeans.Log;
import core.entityBeans.Protocol;
import core.entityBeans.Resource;
import core.entityBeans.SystemLog;
import core.entityBeans.SystemLogResource;
import core.entityBeans.SystemLogUser;
import core.entityBeans.TrackingLog;
import core.entityBeans.User;
import core.entityBeans.SystemLog.SLType;
import core.sessionBeans.interfaces.LogBeanLocal;
import core.sessionBeans.interfaces.LogBeanRemote;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

/**
 * Session Bean implementation class LogBean
 */
@Stateless
public class LogBean implements LogBeanRemote, LogBeanLocal {

	@PersistenceContext
	Session s;

	public LogBean() {
		// TODO Auto-generated constructor stub
	}

	public int countLog(Class<? extends Log> c, boolean strict, Date begin,
			Date end) throws Exception {
		int res = 0;
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			Criteria crt = s.createCriteria(c, "c").setProjection(
					Projections.rowCount());

			if (strict)
				crt.add(Property.forName("c.class").eq(c));
			crt.add(Restrictions.ge("c.time", begin));
			crt.add(Restrictions.le("c.time", end));
			res = (Integer) crt.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw (e);
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	public <L extends Log> List<L> listLog(Class<L> c, boolean strict,
			Date begin, Date end, int offSet, int rowCount) throws Exception {
		List<L> ll = null;
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			Criteria crt = s.createCriteria(c, "c").setFirstResult(offSet)
					.setMaxResults(rowCount);
			if (strict)
				crt.add(Property.forName("c.class").eq(c));
			crt.add(Restrictions.ge("c.time", begin));
			crt.add(Restrictions.le("c.time", end));
			ll = (List<L>) crt.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw (e);
		}
		return ll;
	}

	public int countUserLogs(Class<? extends Log> c, boolean strict,
			String user, Date begin, Date end) throws Exception {
		int res = 0;
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			DetachedCriteria tl = null;
			DetachedCriteria slu = null;

			try {
				TrackingLog.class.asSubclass(c);
				if (!strict || c.equals(TrackingLog.class)) {
					tl = DetachedCriteria.forClass(User.class, "u")
							.createAlias("u.userIdentifiers", "uui")
							.createAlias("uui.trackingLogs", "uuitl")
							.setProjection(Property.forName("uuitl.id")).add(
									Property.forName("uuitl.time").ge(begin))
							.add(Property.forName("uuitl.time").le(end)).add(
									Property.forName("u.user").eq(user));
				}
			} catch (Exception e) {
				;
			}

			try {
				SystemLogUser.class.asSubclass(c);
				if (!strict || c.equals(SystemLogUser.class)) {
					slu = DetachedCriteria.forClass(User.class, "u")
							.createAlias("u.systemLogUsers", "uslu")
							.setProjection(Property.forName("uslu.id")).add(
									Property.forName("uslu.time").ge(begin))
							.add(Property.forName("uslu.time").le(end)).add(
									Property.forName("u.user").eq(user));
				}
			} catch (Exception e) {
				;
			}

			Criteria crt = s.createCriteria(c, "c").setProjection(
					Projections.rowCount());
			if (strict)
				crt.add(Property.forName("c.class").eq(c));
			crt.add(Restrictions.ge("c.time", begin));
			crt.add(Restrictions.le("c.time", end));
			if (tl != null && slu != null)
				crt.add(Restrictions.or(Property.forName("c.id").in(slu),
						Property.forName("c.id").in(tl)));
			if (tl == null && slu != null)
				crt.add(Property.forName("c.id").in(slu));
			if (tl != null && slu == null)
				crt.add(Property.forName("c.id").in(tl));

			if (tl == null && slu == null) {
				res = 0;
			} else {
				res = (Integer) crt.uniqueResult();
			}

			tx.commit();
			return res;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw (e);
		}
	}

	@SuppressWarnings("unchecked")
	public <L extends Log> List<L> listUserLogs(Class<L> c, boolean strict,
			String user, Date begin, Date end, int offSet, int rowCount)
			throws Exception {
		List<L> res = null;
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			DetachedCriteria tl = null;
			DetachedCriteria slu = null;

			try {
				TrackingLog.class.asSubclass(c);
				if (!strict || c.equals(TrackingLog.class)) {
					tl = DetachedCriteria.forClass(User.class, "u")
							.createAlias("u.userIdentifiers", "uui")
							.createAlias("uui.trackingLogs", "uuitl")
							.setProjection(Property.forName("uuitl.id")).add(
									Property.forName("uuitl.time").ge(begin))
							.add(Property.forName("uuitl.time").le(end)).add(
									Property.forName("u.user").eq(user));
				}
			} catch (Exception e) {
				;
			}

			try {
				SystemLogUser.class.asSubclass(c);
				if (!strict || c.equals(SystemLogUser.class)) {
					slu = DetachedCriteria.forClass(User.class, "u")
							.createAlias("u.systemLogUsers", "uslu")
							.setProjection(Property.forName("uslu.id")).add(
									Property.forName("uslu.time").ge(begin))
							.add(Property.forName("uslu.time").le(end)).add(
									Property.forName("u.user").eq(user));
				}
			} catch (Exception e) {
				;
			}

			Criteria crt = s.createCriteria(c, "c").setFirstResult(offSet)
					.setMaxResults(rowCount);
			if (strict)
				crt.add(Property.forName("c.class").eq(c));
			crt.add(Restrictions.ge("c.time", begin));
			crt.add(Restrictions.le("c.time", end));
			if (tl != null && slu != null)
				crt.add(Restrictions.or(Property.forName("c.id").in(slu),
						Property.forName("c.id").in(tl)));
			if (tl == null && slu != null)
				crt.add(Property.forName("c.id").in(slu));
			if (tl != null && slu == null)
				crt.add(Property.forName("c.id").in(tl));

			if (tl == null && slu == null) {
				res = new ArrayList();
			} else {
				res = (List<L>) crt.list();
				;
			}

			tx.commit();
			return res;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw (e);
		}
	}

	public int countResourceLogs(Class<? extends Log> c, boolean strict,
			String resource, Date begin, Date end) throws Exception {
		int res = 0;
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			DetachedCriteria tl = null;
			DetachedCriteria slr = null;

			try {
				TrackingLog.class.asSubclass(c);
				if (!strict || c.equals(TrackingLog.class)) {
					tl = DetachedCriteria.forClass(IdentifiableResource.class,
							"ir").createAlias("ir.resourceIdentifiers", "irui")
							.createAlias("irui.trackingLogs", "iruitl")
							.setProjection(Property.forName("iruitl.id")).add(
									Property.forName("iruitl.time").ge(begin))
							.add(Property.forName("iruitl.time").le(end)).add(
									Property.forName("ir.id").eq(resource));
				}
			} catch (Exception e) {
				;
			}

			try {
				SystemLogResource.class.asSubclass(c);
				if (!strict || c.equals(SystemLogResource.class)) {
					slr = DetachedCriteria.forClass(Resource.class, "r")
							.createAlias("r.systemLogResources", "rslr")
							.setProjection(Property.forName("rslr.id")).add(
									Property.forName("rslr.time").ge(begin))
							.add(Property.forName("rslr.time").le(end)).add(
									Property.forName("r.id").eq(resource));
				}
			} catch (Exception e) {
				;
			}

			Criteria crt = s.createCriteria(c, "c").setProjection(
					Projections.rowCount());
			if (strict)
				crt.add(Property.forName("c.class").eq(c));
			crt.add(Restrictions.ge("c.time", begin));
			crt.add(Restrictions.le("c.time", end));
			if (tl != null && slr != null)
				crt.add(Restrictions.or(Property.forName("c.id").in(slr),
						Property.forName("c.id").in(tl)));
			if (tl == null && slr != null)
				crt.add(Property.forName("c.id").in(slr));
			if (tl != null && slr == null)
				crt.add(Property.forName("c.id").in(tl));

			if (tl == null && slr == null) {
				res = 0;
			} else {
				res = (Integer) crt.uniqueResult();
			}

			tx.commit();
			return res;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw (e);
		}
	}

	@SuppressWarnings("unchecked")
	public <L extends Log> List<L> listResourceLogs(Class<L> c, boolean strict,
			String resource, Date begin, Date end, int offSet, int rowCount)
			throws Exception {
		List<L> res = null;
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			DetachedCriteria tl = null;
			DetachedCriteria slr = null;

			try {
				TrackingLog.class.asSubclass(c);
				if (!strict || c.equals(TrackingLog.class)) {
					tl = DetachedCriteria.forClass(IdentifiableResource.class,
							"ir").createAlias("ir.resourceIdentifiers", "irui")
							.createAlias("irui.trackingLogs", "iruitl")
							.setProjection(Property.forName("iruitl.id")).add(
									Property.forName("iruitl.time").ge(begin))
							.add(Property.forName("iruitl.time").le(end)).add(
									Property.forName("ir.id").eq(resource));
				}
			} catch (Exception e) {
				;
			}

			try {
				SystemLogResource.class.asSubclass(c);
				if (!strict || c.equals(SystemLogResource.class)) {
					slr = DetachedCriteria.forClass(Resource.class, "r")
							.createAlias("r.systemLogResources", "rslr")
							.setProjection(Property.forName("rslr.id")).add(
									Property.forName("rslr.time").ge(begin))
							.add(Property.forName("rslr.time").le(end)).add(
									Property.forName("r.id").eq(resource));
				}
			} catch (Exception e) {
				;
			}

			Criteria crt = s.createCriteria(c, "c").setFirstResult(offSet)
					.setMaxResults(rowCount);
			if (strict)
				crt.add(Property.forName("c.class").eq(c));
			crt.add(Restrictions.ge("c.time", begin));
			crt.add(Restrictions.le("c.time", end));
			if (tl != null && slr != null)
				crt.add(Restrictions.or(Property.forName("c.id").in(slr),
						Property.forName("c.id").in(tl)));
			if (tl == null && slr != null)
				crt.add(Property.forName("c.id").in(slr));
			if (tl != null && slr == null)
				crt.add(Property.forName("c.id").in(tl));

			if (tl == null && slr == null) {
				res = new ArrayList<L>();
			} else {
				res = (List<L>) crt.list();
			}

			tx.commit();
			return res;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw (e);
		}
	}

	public TrackingLog createTrackingLog(String protocol, String identifier,
			String detector, Float x, Float y, Date time, String desc)
			throws Exception {

		Transaction tx = null;
		TrackingLog res = null;
		Identifier i  = null;
		
		try {		
			tx = s.beginTransaction();
			i = (Identifier) s.get(Identifier.class, identifier);
		
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
			
			
			try {	
			
				tx = s.beginTransaction();
				Detector d = (Detector) s.get(Detector.class, detector);
				
			if (i == null) {
			 i = createIdentifier(protocol, identifier, time);
			}

			res = new TrackingLog();
			res.setDetector(d);
			res.setIdentifier(i);
			res.setTime(time);
			res.setDesc(desc);
			s.save(res);
			tx.commit();
			return res;

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			// throw(e);
		}

		return null;
	}

	public Identifier createIdentifier(String protocol, String identifier,
			Date time) {
	

		try {
			
			Identifier i = new Identifier();
			Protocol p = (Protocol) s.load(Protocol.class, protocol);
			i.setProtocol(p);
			i.setId(identifier);
			SystemLog sl = new SystemLog();
			sl.setTime(time);
			sl.setType(SLType.INSERT);
			sl.setDesc("");
			s.save(i);
			s.save(sl);
	
			return i;

     	} catch (Exception e) {
			e.printStackTrace();
		//	if (tx != null)
			//	tx.rollback();
			// throw(e);
		}
		return null;

	}

	public TrackingLog createTrackingLog1(String protocol, String identifier,
			String detector, Float x, Float y, Date time, String desc)
			throws Exception {

		TrackingLog res = null;
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			Identifier i = (Identifier) s.get(Identifier.class, identifier);
			Detector d = (Detector) s.get(Detector.class, detector);

			if (i == null) {

			}

			res = new TrackingLog();
			res.setDetector(d);
			res.setIdentifier(i);
			res.setTime(time);
			res.setDesc(desc);
			s.save(res);
			tx.commit();
			return res;

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			// throw(e);
		}
		return res;

	}

	public <L extends Log> L create(L l) throws Exception {
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(l);
			tx.commit();
			return l;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}

}