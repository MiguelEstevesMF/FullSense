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
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;




@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="User")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQueries({
	@NamedQuery(name="User.login",query="SELECT u From User u LEFT JOIN FETCH u.permissionGroups LEFT JOIN FETCH u.userIdentifiers WHERE u.user=:user AND u.password=:password AND u.enable<=current_timestamp() AND u.expire>= current_timestamp()"),
	@NamedQuery(name="User.countUsers",query="SELECT count(u) FROM User u WHERE u.expire>= current_timestamp() OR true=:filter"),
	@NamedQuery(name="User.getUsers",query="SELECT u From User u WHERE u.expire>= current_timestamp() OR true=:filter"),
	@NamedQuery(name="User.getUser",query="SELECT u From User u LEFT JOIN FETCH u.permissionGroups LEFT JOIN FETCH u.userIdentifiers WHERE u.user=:user"),
	@NamedQuery(name="User.softDelete",query="Update SystemLogUser set user = null WHERE user.user=:user"),
	@NamedQuery(name="User.countPermissionWithStationaryResource",query="SELECT count(u) From User u JOIN u.permissionGroups upgs JOIN upgs.permissions upgsps JOIN upgsps.resource r WHERE r.id=:srid AND u.user=:uid AND (u.expire>= current_timestamp() OR true=:filter)"),
	@NamedQuery(name="User.countUserInPermissionGroup",query="SELECT count(u) From User u JOIN u.permissionGroups upgs WHERE upgs.id=:pgId AND u.user=:userId AND (u.expire>= current_timestamp() OR true=:filter)")
})
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3593450134147904473L;

	public User() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof User))
			return false;
		User user = (User)aObj;
		if ((getUser() != null && !getUser().equals(user.getUser())) || (getUser() == null && user.getUser() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getUser() == null ? 0 : getUser().hashCode());
		return hashcode;
	}
	
	@Column(name="User", nullable=false)	
	@Id	
	private String user;
	
	@Column(name="Name", nullable=true, length=255)	
	private String name;
	
	@Column(name="Address", nullable=true, length=255)	
	private String address;
	
	@Column(name="Email", nullable=true, length=255)	
	private String email;
	
	@Column(name="PhoneNumber", nullable=true, length=255)	
	private String phoneNumber;
	
	@Column(name="Password", nullable=true, length=255)	
	private String password;
	
	@Column(name="LastLogin", nullable=true)	
	private java.util.Date lastLogin;
	
	@Column(name="ImageURL", nullable=true, length=255)	
	private String imageURL;
	
	@Column(name="Enable", nullable=true)	
	private java.util.Date enable;
	
	@Column(name="Expire", nullable=true)	
	private java.util.Date expire;
	
	@ManyToMany(mappedBy="users", targetEntity=PermissionGroup.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="PermissionGroup_User", joinColumns={ @JoinColumn(name="UserUser") }, inverseJoinColumns={ @JoinColumn(name="PermissionGroupId") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set<PermissionGroup> permissionGroups = new java.util.HashSet<PermissionGroup>();
	
	@OneToMany(targetEntity=UserIdentifier.class)
	@JoinColumns({ @JoinColumn(name="UserUser", referencedColumnName="User") })
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set<UserIdentifier> userIdentifiers = new HashSet<UserIdentifier>();
	
	@OneToMany(targetEntity=Request.class)
	@JoinColumns({ @JoinColumn(name="UserUser", referencedColumnName="User") })
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set<Request> requests = new HashSet<Request>();
	
	@OneToMany(targetEntity=SystemLogUser.class)
	@JoinColumns({ @JoinColumn(name="UserUser", referencedColumnName="User") })
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.ALL , org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set<SystemLogUser> systemLogUsers = new HashSet<SystemLogUser>();
	
	public void setUser(String value) {
		this.user = value;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getORMID() {
		return getUser();
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAddress(String value) {
		this.address = value;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String value) {
		this.phoneNumber = value;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setLastLogin(java.util.Date value) {
		this.lastLogin = value;
	}
	
	public java.util.Date getLastLogin() {
		return lastLogin;
	}
	
	public void setImageURL(String value) {
		this.imageURL = value;
	}
	
	public String getImageURL() {
		return imageURL;
	}
	
	public void setEnable(java.util.Date value) {
		this.enable = value;
	}
	
	public java.util.Date getEnable() {
		return enable;
	}
	
	public void setExpire(java.util.Date value) {
		this.expire = value;
	}
	
	public java.util.Date getExpire() {
		return expire;
	}
	
	public void setPermissionGroups(java.util.Set<PermissionGroup> value) {
		this.permissionGroups = value;
	}
	
	public java.util.Set<PermissionGroup> getPermissionGroups() {
		return permissionGroups;
	}
	
	
	public void setUserIdentifiers(java.util.Set<UserIdentifier> value) {
		this.userIdentifiers = value;
	}
	
	public java.util.Set<UserIdentifier> getUserIdentifiers() {
		return userIdentifiers;
	}
	
	
	public void setRequests(java.util.Set<Request> value) {
		this.requests = value;
	}
	
	public java.util.Set<Request> getRequests() {
		return requests;
	}
	
	
	@SuppressWarnings("unused")
	private void setSystemLogUsers(java.util.Set<SystemLogUser> value) {
		this.systemLogUsers = value;
	}
	
	public java.util.Set<SystemLogUser> getSystemLogUsers() {
		return systemLogUsers;
	}
	
	
	public String toString() {
		return String.valueOf(getUser());
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
