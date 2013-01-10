package core.sessionBeans.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import core.entityBeans.Log;
import core.entityBeans.TrackingLog;

/**
 * Atenção, o polimorfismo explicito esta com bugs no Hibernate, pôr o 'strict' sempre a false sempre que possivel
 */


@Remote
public interface LogBeanRemote {
	
	
	/** COUNTS ALL LOGS BETWEEN DATES
	 * For example: int i = countLogs( SystemLog.class, false, date1, date2,..);
	 * This example call counts all SystemLogs and with strict=false it also returns SystemLogUser 
	 * and SystemLogResource. If strict=true it counts all SystemLogs except SystemLogUser 
	 * and SystemLogResource. NOTE: Because of Hibernate explicit polimorfism bug use strict=false. 
	 */
	public int countLog(Class<? extends Log> c, boolean strict, Date begin, Date end) throws Exception;
	
	/** RETURNS ALL LOGS BETWEEN DATES
	 * For example: List<SystemLog> tl = listLogs( SystemLog.class, false, date1, date2,..);
	 * This example call returns all SystemLogs and with strict=false it also returns SystemLogUser 
	 * and SystemLogResource. If strict=true it returns all SystemLogs except SystemLogUser 
	 * and SystemLogResource. NOTE: Because of Hibernate explicit polimorfism bug use strict=false.
	 */
	public <L extends Log> List<L> listLog(Class<L> c, boolean strict, Date begin, Date end, int offSet, int rowCount) throws Exception;

	/** ALL LOGS FROM User BETWEEN DATES*/
	public int countUserLogs(Class<? extends Log> c, boolean strict, String user, Date begin, Date end) throws Exception;
	public <L extends Log> List<L> listUserLogs(Class<L> c, boolean strict, String user, Date begin, Date end, int offSet, int rowCount) throws Exception;
		
	/** ALL LOGS FROM Resource BETWEEN DATES*/
	public int countResourceLogs(Class<? extends Log> c, boolean strict, String resource, Date begin, Date end) throws Exception;
	public <L extends Log> List<L> listResourceLogs(Class<L> c, boolean strict, String resource, Date begin, Date end, int offSet, int rowCount) throws Exception;
	
	/**
	 * @param protocol
	 * @param identifier
	 * @param detector
	 * @param x
	 * @param y
	 * @param time
	 * @return
	 * @throws Exception
	 * 
	 * NOTE:: the x and y are only for future implementations ( x y = GS coordinates or whatever )
	 * 
	 */
	public TrackingLog createTrackingLog(String protocol, String identifier, String detector, Float x, Float y, Date time, String desc) throws Exception;

	public<L extends Log> L create(L l) throws Exception;
	
}
