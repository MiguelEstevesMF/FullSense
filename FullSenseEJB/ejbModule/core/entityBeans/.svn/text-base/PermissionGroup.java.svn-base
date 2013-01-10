package core.entityBeans;
/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Anonymous
 * License Type: Purchased
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="PermissionGroup")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQueries({
	@NamedQuery(name="PermissionGroup.countPermissionGroups",query="SELECT count(pg) FROM PermissionGroup as pg"),
	@NamedQuery(name="PermissionGroup.getPermissionGroups",query="SELECT pg FROM PermissionGroup as pg"),
	@NamedQuery(name="PermissionGroup.getPermissionGroup",query="SELECT pg FROM PermissionGroup as pg LEFT JOIN FETCH pg.users pgu WHERE pg.id=:name"),
	
	@NamedQuery(name="PermissionGroup.getPermissionGroupsFromPermission",query="SELECT pg FROM PermissionGroup pg JOIN pg.permissions pgps WHERE :p_id IN (pgps)"),
})
public class PermissionGroup implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8326474235838637857L;

	public PermissionGroup() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof PermissionGroup))
			return false;
		PermissionGroup permissiongroup = (PermissionGroup)aObj;
		if ((getId() != null && !getId().equals(permissiongroup.getId())) || (getId() == null && permissiongroup.getId() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getId() == null ? 0 : getId().hashCode());
		return hashcode;
	}
	
	@Column(name="Id", nullable=false)	
	@Id	
	private String id;
	
	@ManyToMany(mappedBy="permissionGroups", targetEntity=Permission.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set<Permission> permissions = new java.util.HashSet<Permission>();
	
	@ManyToMany(targetEntity=User.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set<User> users = new java.util.HashSet<User>();
	
	@ManyToMany(targetEntity=IdentifiableResource.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set<IdentifiableResource> identifiableResources = new java.util.HashSet<IdentifiableResource>();
	
	
	
	public java.util.Set<IdentifiableResource> getIdentifiableResources() {
		return identifiableResources;
	}

	public void setIdentifiableResources(
			java.util.Set<IdentifiableResource> identifiableResources) {
		this.identifiableResources = identifiableResources;
	}

	public void setId(String value) {
		this.id = value;
	}
	
	public String getId() {
		return id;
	}
	
	public String getORMID() {
		return getId();
	}
	
	public void setPermissions(java.util.Set<Permission> value) {
		this.permissions = value;
	}
	
	public java.util.Set<Permission> getPermissions() {
		return permissions;
	}
	
	
	public void setUsers(java.util.Set<User> value) {
		this.users = value;
	}
	
	public java.util.Set<User> getUsers() {
		return users;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
	@Transient	
	private boolean _saved = false;
	
	public void onSave() {
		_saved=true;
	}
	
	
	public void onLoad() {
		_saved=true;
	}
	
	
	public boolean isSaved() {
		return _saved;
	}
	
	
}
