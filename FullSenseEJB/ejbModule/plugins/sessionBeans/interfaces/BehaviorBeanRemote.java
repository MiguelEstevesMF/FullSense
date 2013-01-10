package plugins.sessionBeans.interfaces;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import core.entityBeans.TrackingLog;

import plugins.entityBeans.Behavior;
import plugins.entityBeans.Bundle;
import plugins.entityBeans.Method;
import plugins.util.PersistablePlugin;
import java.io.Serializable;

@Remote
public interface BehaviorBeanRemote {
	
	public <PP extends PersistablePlugin> PP create(PP p) throws Exception;
	public <PP extends PersistablePlugin> PP read(Class<PP> c,Serializable id) throws Exception;
	public <PP extends PersistablePlugin> boolean update(PP p) throws Exception;
	public <PP extends PersistablePlugin> boolean delete(PP p) throws Exception;
	// TODO CASCADE DELETE OF ORPHAN
	
	public List<Behavior> getAllBehaviors(int bundleId, int methodId) throws Exception;
	
	public List<TrackingLog> getRecords(Date begin, Date end) throws Exception;
	
	public List<Bundle> getAllBundles() throws Exception;
	
	public List<Method> getAllConditionMethods(String type) throws Exception;
	
	public <C> int countPossibleValues(Class<C> c) throws Exception;
	public <C> List<C> getPossibleValues(Class<C> c, int offSet, int rowCount) throws Exception;
	//este metodo da todos os users, todos os resources, todos os coisa

}
