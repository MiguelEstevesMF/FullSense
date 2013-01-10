package core.sessionBeans.interfaces;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import core.entityBeans.IdentifiableResource;
import core.entityBeans.Permission;
import core.entityBeans.PermissionGroup;
import core.entityBeans.Request;
import core.entityBeans.Resource;
import core.entityBeans.StationaryResource;
import core.entityBeans.Type;
import core.entityBeans.User;

@Remote
public interface ResourceBeanRemote {
	
	/* Bean Features
	 *  CRUD Resources
	 *  Manage Resource Request
	 *  Manage Resource Occupation
	 *  Manage Group Permissions
	 */
	
//
//	
//	//ALL RESOURCES available between begin and end
//	public int countResourceBeginEnd(Date begin, Date end) throws Exception;
//	public List<Resource> listResourceBeginEnd(Date begin, Date end, int offSet, int rowCount) throws Exception;
//	
//	//ALL RESOURCES by Type
//	public int countResourceType(String type) throws Exception;
//	public List<Resource> getResourceType(String type, int offSet, int rowCount) throws Exception;
//	
//	//ALL RESOURCES by Type available between begin and end
//	public int countResourceTypeBeginEnd(String type, Date begin, Date end) throws Exception;
//	public List<Resource> getResourceTypeBeginEnd(String type, Date begin, Date end, int offSet, int rowCount) throws Exception;
//	
//	//CRUD Permission ( listar, adicionar, remover permissoes de um grupo para um recurso)
//	// atencao aos loads, tem de ser possivel tirar remover um grupo ( tirar-lhe a permissao)
//	public List<Permission> getPermission(Resource r) throws Exception;
//	public List<Permission> getPermission(Resource r, PermissionGroup pg) throws Exception;
//	public boolean updatePermission(Permission p) throws Exception;
//	

//	
//	//Retrieve Request from Resource
//	public List<Request> getRequests(String resourceId, Date begin, Date end) throws Exception;
//	


	/**
	 * Counts all resources free by resourceId, type of resource, begin date and end date.
	 * All fields can be null and either resourceId or type fields cannot be not null at the same call.
	 */
	public int countResources(String resourceId, String type, Date begin, Date end, boolean filterActive) throws Exception;
	/**
	 * List all resources free by resourceId, type of resource, begin date and end date.
	 * All fields can be null and either resourceId or type fields cannot be not null at the same call.
	 */
	public List<Resource> listResources(String resourceId, String type, Date begin, Date end, boolean filterActive, int offSet, int rowCount) throws Exception;
	
	
	//ALL RESOURCES
	public int countResources(boolean filterActive) throws Exception;
	public List<Resource> listResources(boolean filterActive, int offSet, int rowCount) throws Exception;
	
	//LIST IDENTIFIABLE RESOURCES
	public int countIdentifiableResources(boolean filterActive) throws Exception;
	public List<IdentifiableResource> listIdentifiableResources(boolean filterActive, int offSet, int rowCount) throws Exception;
	
	//LIST STATIONARY RESOURCES
	public int countStationaryResources(boolean filterActive) throws Exception;
	public List<StationaryResource> listStationaryResources(boolean filterActive, int offSet, int rowCount) throws Exception;
	
	//CRUD - Resource
	public boolean create(Resource resource) throws Exception;
	public boolean delete(Resource resource)throws Exception;
	public boolean drop(Resource resource)throws Exception;
	public boolean update(Resource resource) throws Exception;
	
	/**
	 * Updates a Resource with alterations on Request and Permission Collections.<br>
	 * All but resource argument can be null.<br>
	 * Does not accept transient arguments so: <br>
	 * persist and reload the objects Request and Permission before using in this method.
	 */
	public boolean update(Resource resource, Request request, Permission permission) throws Exception;
	public Resource readResource(String id) throws Exception;
	public Resource readResourceFetchPermissions(String id) throws Exception;
	public Resource readResourceFetchRequests(String id) throws Exception;
	
	
	
	//ALL RESOURCE TYPES
	public int countTypes() throws Exception;
	public List<Type> listTypes(int offSet, int rowCount) throws Exception;
	
	//CRUD Resource Types
	public boolean create(Type type) throws Exception;
	public boolean drop(Type type)throws Exception;
	public Type readType(String name) throws Exception;


	//ALL PERMISSIONS
	public int countPermissions() throws Exception;
	public List<Permission> listPermissions(int offSet, int rowCount) throws Exception;
	
	
	/**
	 * Retrieves all permissions from user User relative to Resource R ( to evaluate if a user can or cannot do.. )
	 */
	public List<Permission> getPermissions(Resource r, User u) throws Exception;
	
	public List<Permission> getPermissions(Resource r) throws Exception;
	public List<Permission> getPermissions(Resource r, PermissionGroup pg) throws Exception;
	public List<PermissionGroup> getPermissionGroups(Permission p) throws Exception;
		
	
	//CRUD - Permission
	public boolean create(Permission permission) throws Exception;
	public boolean drop(Permission permission)throws Exception;
	public boolean update(Permission permission) throws Exception;
	
	/**
	 * Updates a Permission with alterations on PermissionGroups Collections.<br>
	 * All but permission argument can be null.<br>
	 * Does not accept transient arguments so: <br>
	 * persist and reload the object PermissionGroup before using in this method.
	 * Note: this method only needs to be used if permission did not fetch PermissionGroups Collection
	 */
	public boolean update(Permission permission, PermissionGroup permissionGroup) throws Exception;
	public Permission readPermission(int id) throws Exception;
	public Permission readPermissionFetchPermissionGroups(int id) throws Exception;
	
	
	//ALL REQUESTS
	public int countRequests() throws Exception;
	public List<Request> listRequests(int offSet, int rowCount) throws Exception;
	
	
	//CRUD - Request
	public boolean create(Request request) throws Exception;
	public boolean drop(Request request)throws Exception;
	public boolean update(Request request) throws Exception;
	public Request readRequest(int id) throws Exception;
	
	public String getUserIdByResourceId(String rid)throws Exception;
}
