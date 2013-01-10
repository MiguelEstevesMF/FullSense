package core.sessionBeans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import core.entityBeans.*;


@Remote

public interface UserBeanRemote {
	
	/* Bean Features
	 * 	LOGIN
	 *  MANAGE USERS
	 *  MANAGE GROUPS
	 */
	
	//CRUD Groups
	public boolean create(PermissionGroup pg) throws Exception;
	public PermissionGroup readPermissionGroup(String id) throws Exception;
	public boolean update(PermissionGroup pg) throws Exception;
	public boolean delete(PermissionGroup id) throws Exception;
	
	public int countPermissionGroup() throws Exception;
	public List<PermissionGroup> listPermissionGroup(int offSet, int countRow) throws Exception;	
	
	
	/** loads user with simple fields(integer, string and date types), identifiers and permissionGroups */
	public User login(String ID, String password) throws Exception;


	//CRUD Users
	public boolean create(User user) throws Exception;
	
	/** loads user with simple fields(integer, string and date types), identifiers and permissionGroups */
	public User readUser(String id) throws Exception;
	public List<Request> readRequestsByUser(String id) throws Exception;
	public boolean delete(User userId) throws Exception;
	public boolean drop(User userId) throws Exception;
	public boolean update(User user) throws Exception;
	
	/**
	 * Updates a User with alterations on PermissionGroup, Request and UserIdentified Collections.<br>
	 * All but user argument can be null.<br>
	 * Does not accept transient arguments so: <br>
	 * persist and reload the objects PermissionGroup and UserIdentified before using in this method.
	 */
	public boolean update(User user, PermissionGroup permissionGroup, Request request, UserIdentifier userIdentifier) throws Exception;
	
	public int countUser(boolean filterActive) throws Exception;
	public List<User> listUser(boolean filterActive, int offSet, int rowCount) throws Exception;
	
	public boolean validateUserInPermissionGroup(String userId, String pgId, boolean filterActive)throws Exception;
	public boolean validateResourceInPermissionGroup(String resourceId, String pgId, boolean filterActive) throws Exception;
	public boolean validateIdentifierInPermissionGroup(String identifierId, String pgId, boolean filterActive) throws Exception;
	
	public List<User> getUsersFromGroup(String group) throws Exception;
}
