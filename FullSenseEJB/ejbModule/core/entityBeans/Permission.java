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

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Permission")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQueries({
	@NamedQuery(name="Permission.countPermissions",query="SELECT count(p) FROM Permission p"),
	@NamedQuery(name="Permission.getPermissions",query="SELECT p From Permission p"),
	@NamedQuery(name="Permission.getPermissionFetchPermissionGroups",query="SELECT p From Permission p LEFT JOIN FETCH p.permissionGroups WHERE p.id=:id"),
	
	@NamedQuery(name="Permission.getPermissionsFromUserResource",query="SELECT p FROM Permission p JOIN p.permissionGroups pgs JOIN pgs.users pus JOIN p.resource pr WHERE pr.id=:r_id AND :user IN (pus.user)"),	
	@NamedQuery(name="Permission.getPermissionsFromResource",query="SELECT p FROM Permission p JOIN p.resource pr WHERE pr.id=:r_id"),
	@NamedQuery(name="Permission.getPermissionsFromResourcePermissionGroup",query="SELECT p FROM Permission p JOIN p.permissionGroups pgs JOIN p.resource pr WHERE pr.id=:r_id AND :pg_id IN (pgs.id)"),
})
public class Permission implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4328133760498230375L;

	public Permission() {
	}
	
	@Column(name="Id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A8017D126A09144C204E3C")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A8017D126A09144C204E3C", strategy="native")	
	private int id;
	
	@Column(name="Type", nullable=true, length=255)	
	private String type;
	
	@ManyToOne(targetEntity=Resource.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="ResourceId", referencedColumnName="Id") })	
	@Basic(fetch=FetchType.EAGER)	
	private Resource resource;
	
	@ManyToMany(targetEntity=PermissionGroup.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Permission_PermissionGroup", joinColumns={ @JoinColumn(name="PermissionId") }, inverseJoinColumns={ @JoinColumn(name="PermissionGroupId") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set<PermissionGroup> permissionGroups = new java.util.HashSet<PermissionGroup>();
	
	public void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setType(String value) {
		this.type = value;
	}
	
	public String getType() {
		return type;
	}
	
	public void setResource(Resource value) {
		this.resource = value;
	}
	
	public Resource getResource() {
		return resource;
	}
	
	public void setPermissionGroups(java.util.Set<PermissionGroup> value) {
		this.permissionGroups = value;
	}
	
	public java.util.Set<PermissionGroup> getPermissionGroups() {
		return permissionGroups;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
