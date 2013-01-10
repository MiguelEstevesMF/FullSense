package core.sessionBeans.interfaces;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import core.entityBeans.Detector;
import core.entityBeans.Identifier;
import core.entityBeans.Protocol;
import core.entityBeans.StationaryResource;

@Remote
public interface DetectorBeanRemote {
	
	public Protocol readProtocol(String id) throws Exception;
	public boolean create(Protocol protocol) throws Exception;
	public boolean drop(Protocol protocol) throws Exception;
	public int countProtocols() throws Exception;
	public List<Protocol> listProtocols(int offSet, int rowCount) throws Exception;
	
	public Identifier readIdentifier(String id) throws Exception;
	public boolean create(Identifier identifier) throws Exception;
	public boolean update(Identifier identifier) throws Exception;
	public boolean drop(Identifier identifier) throws Exception;
	public int countIdentifiers() throws Exception;
	public List<Identifier> listIdentifiers(int offSet, int rowCount) throws Exception;

	public Detector readDetector(String id) throws Exception;
	public int readDetectorFloor(String id)  throws Exception;
	public String readDetectorResourceId(String id) throws Exception;
	
	public boolean create(Detector detector) throws Exception;
	public boolean update(Detector detector) throws Exception;
	public boolean drop(Detector detector) throws Exception;
	public int countDetectors() throws Exception;
	public List<Detector> listDetectors(int offSet, int rowCount) throws Exception;
	

	/**
	 * If createSystemLog=true a PHYSICALACCESSDENIED kind of SystemLog is created if permission is denied.
	 * If filterActive=true it only searches identifiers within active users of resources.
	 * Returns false if permission is denied. 
	 */
	public boolean validatePermission(Identifier identifier, StationaryResource stationaryResource, boolean defaultValue,boolean createSystemLog, boolean filterActive) throws Exception;
	public boolean validatePermission(String identifier, String stationaryResource,boolean defaultValue, boolean createSystemLog, boolean filterActive) throws Exception; 
	
	
	public List<Identifier> listUnlinkIdentifiers(String protocol, Date begin, Date end) throws Exception;
	public<T extends Identifier> T changeTo(Identifier i,Class<T> nc, String id) throws Exception;
}
