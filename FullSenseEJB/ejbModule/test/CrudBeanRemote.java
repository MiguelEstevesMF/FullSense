package test;
import java.util.List;

import javax.ejb.Remote;

import org.hibernate.Session;

@Remote
public interface CrudBeanRemote {
	
	public Session getS();
	
	public void save(Object o);
	
	public void drop(Object o);
	
	public <T> T load(Class<T> c, Object id);
	
	public List createQuery(String ss);

}
