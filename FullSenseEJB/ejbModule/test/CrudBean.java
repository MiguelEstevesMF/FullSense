package test;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

import core.entityBeans.SystemLogUser;
import core.entityBeans.SystemLog.SLType;


/**
 * Session Bean implementation class CrudBean
 */
@Stateless
public class CrudBean implements CrudBeanRemote {

    /**
     * Default constructor. 
     */
    public CrudBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    Session s;

	public Session getS() {
		return s;
	}
    
    public void save(Object o) {
	    Transaction tx = s.beginTransaction();
		s.saveOrUpdate(o);
		tx.commit();
	}
    
    public void drop(Object o) {
	    Transaction tx = s.beginTransaction();
		s.delete(o);
		tx.commit();
	}
    
    public <T> T load(Class<T> c, Object id) {
	    Transaction tx = s.beginTransaction();
		Object o = s.get(c, (Serializable)id);
		tx.commit();
		return c.cast(o);
	}
    
    public List createQuery(String ss) {
	    Transaction tx = s.beginTransaction();
		List l = s.createQuery(ss).list();
		tx.commit();
		return l;
	}
}
