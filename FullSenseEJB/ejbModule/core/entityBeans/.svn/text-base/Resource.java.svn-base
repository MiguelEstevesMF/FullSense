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

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Resource")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQueries({
	@NamedQuery(name="Resource.getResourceFetchPermissions",query="SELECT r From Resource r LEFT JOIN FETCH r.permissions WHERE r.id=:id"),
	@NamedQuery(name="Resource.getResourceFetchRequests",query="SELECT r From Resource r LEFT JOIN FETCH r.requests WHERE r.id=:id"),
	@NamedQuery(name="Resource.countResources",query="SELECT count(r) FROM Resource r"),
	@NamedQuery(name="Resource.getResources",query="SELECT r From Resource r"),
	@NamedQuery(name="Resource.countActiveResources",query="SELECT count(r) FROM Resource r WHERE r.active=true OR false=:filter"),
	@NamedQuery(name="Resource.getActiveResources",query="SELECT r From Resource r WHERE r.active=true OR false=:filter"),
	@NamedQuery(name="Resource.softDelete",query="Update SystemLogResource set resource = null WHERE resource.id=:resource"),
	
	@NamedQuery(name="Resource.countActiveResources++",query="SELECT count(r) FROM Resource r WHERE not exists ( SELECT rq FROM Request rq JOIN rq.resource rqr WHERE rqr.id=r.id AND ( (rq.begin > :begin AND rq.begin < :end) OR (rq.end > :begin AND rq.end < :end) OR (:begin > rq.begin AND :end < rq.end) OR :begin = rq.begin OR :end = rq.end) AND str(rq.state)!='DELIVERED' )  AND (r.active=true OR false=:filter)"),
	@NamedQuery(name="Resource.getActiveResources++",query="SELECT r FROM Resource r WHERE not exists ( SELECT rq FROM Request rq JOIN rq.resource rqr WHERE rqr.id=r.id AND ( (rq.begin > :begin AND rq.begin < :end) OR (rq.end > :begin AND rq.end < :end) OR (:begin > rq.begin AND :end < rq.end) OR :begin = rq.begin OR :end = rq.end) AND str(rq.state)!='DELIVERED' ) AND (r.active=true OR false=:filter)"),
	@NamedQuery(name="Resource.countActiveResources++ByRID",query="SELECT count(r) FROM Resource r WHERE not exists ( SELECT rq FROM Request rq JOIN rq.resource rqr WHERE rqr.id=r.id AND ( (rq.begin > :begin AND rq.begin < :end) OR (rq.end > :begin AND rq.end < :end) OR (:begin > rq.begin AND :end < rq.end) OR :begin = rq.begin OR :end = rq.end) AND str(rq.state)!='DELIVERED' ) AND r.id=:resourceId AND (r.active=true OR false=:filter)"),
	@NamedQuery(name="Resource.getActiveResources++ByRID",query="SELECT r FROM Resource r WHERE not exists ( SELECT rq FROM Request rq JOIN rq.resource rqr WHERE rqr.id=r.id AND ( (rq.begin > :begin AND rq.begin < :end) OR (rq.end > :begin AND rq.end < :end) OR (:begin > rq.begin AND :end < rq.end) OR :begin = rq.begin OR :end = rq.end) AND str(rq.state)!='DELIVERED' ) AND r.id=:resourceId AND (r.active=true OR false=:filter)"),
	@NamedQuery(name="Resource.countActiveResources++ByType",query="SELECT count(r) FROM Resource r WHERE not exists ( SELECT rq FROM Request rq JOIN rq.resource rqr WHERE rqr.id=r.id AND ( (rq.begin > :begin AND rq.begin < :end) OR (rq.end > :begin AND rq.end < :end) OR (:begin > rq.begin AND :end < rq.end) OR :begin = rq.begin OR :end = rq.end) AND str(rq.state)!='DELIVERED' ) AND r.type=:type AND (r.active=true OR false=:filter)"),
	@NamedQuery(name="Resource.getActiveResources++ByType",query="SELECT r FROM Resource r WHERE not exists ( SELECT rq FROM Request rq JOIN rq.resource rqr WHERE rqr.id=r.id AND ( (rq.begin > :begin AND rq.begin < :end) OR (rq.end > :begin AND rq.end < :end) OR (:begin > rq.begin AND :end < rq.end) OR :begin = rq.begin OR :end = rq.end) AND str(rq.state)!='DELIVERED' ) AND r.type=:type AND (r.active=true OR false=:filter)"),
	
	
	@NamedQuery(name="Resource.countStationaryResources",query="SELECT count(sr) FROM StationaryResource sr"),
	@NamedQuery(name="Resource.getStationaryResources",query="SELECT sr From StationaryResource sr"),
	@NamedQuery(name="Resource.countActiveStationaryResources",query="SELECT count(sr) FROM StationaryResource sr WHERE sr.active=true OR false=:filter"),
	@NamedQuery(name="Resource.getActiveStationaryResources",query="SELECT sr From StationaryResource sr WHERE sr.active=true OR false=:filter"),
	
	@NamedQuery(name="Resource.countIdentifiableResources",query="SELECT count(ir) FROM IdentifiableResource ir"),
	@NamedQuery(name="Resource.getIdentifiableResources",query="SELECT ir From IdentifiableResource ir"),
	@NamedQuery(name="Resource.countActiveIdentifiableResources",query="SELECT count(ir) FROM IdentifiableResource ir WHERE ir.active=true OR false=:filter"),
	@NamedQuery(name="Resource.getActiveIdentifiableResources",query="SELECT ir From IdentifiableResource ir WHERE ir.active=true OR false=:filter"),
	
	//@NamedQuery(name="Resource.softDelete",query="Update SystemLogResource set user = null WHERE user.user=:user"),
	//@NamedQuery(name="Resource.countSystemLogResource",query="SELECT count(slu) FROM SystemLogUser slu WHERE slu.user.user=:user"),
	@NamedQuery(name="Resource.getSystemLogResource",query="SELECT slr FROM SystemLogResource slr WHERE slr.resource.id=:id"),
	@NamedQuery(name="Resource.getUser",query="SELECT distinct u.user FROM Request r JOIN r.user u JOIN r.resource rs WHERE rs.id=:id AND rs.active=true AND str(r.state)='LIFTED'"),
	
	@NamedQuery(name="Resource.countResourceInPermissionGroup",query="SELECT count(r) From Resource r JOIN r.permissionGroups rpgs WHERE rpgs.id=:pgId AND r.id=:rid AND (r.active=true OR false=:filter)")
})
@DiscriminatorColumn(name="Discriminator", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Resource")
public class Resource implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1563767851844996572L;

	public Resource() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Resource))
			return false;
		Resource resource = (Resource)aObj;
		if ((getId() != null && !getId().equals(resource.getId())) || (getId() == null && resource.getId() != null))
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
	
	@Column(name="Name", nullable=true, length=255)	
	private String name;
	
	@Column(name="`Desc`", nullable=true, length=255)	
	private String desc;
	
	@Column(name="Active", nullable=true)	
	private boolean active;
	
	@ManyToOne(targetEntity=Type.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="TypeName", referencedColumnName="Name") })	
	@Basic(fetch=FetchType.EAGER)	
	private Type type;
	
	@OneToMany(targetEntity=Request.class)
	@JoinColumns({ @JoinColumn(name="ResourceId", referencedColumnName="Id") })	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set<Request> requests = new HashSet<Request>();
	
	@OneToMany(targetEntity=SystemLogResource.class)
	@JoinColumns({ @JoinColumn(name="ResourceId", referencedColumnName="Id") })	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set<SystemLogResource> systemLogResources = new HashSet<SystemLogResource>();
	
	@OneToMany(targetEntity=Permission.class)
	@JoinColumns({ @JoinColumn(name="ResourceId", referencedColumnName="Id") })	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set<Permission> permissions = new HashSet<Permission>();
	
	public void setId(String value) {
		this.id = value;
	}
	
	public String getId() {
		return id;
	}
	
	public String getORMID() {
		return getId();
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDesc(String value) {
		this.desc = value;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setRequests(java.util.Set<Request> value) {
		this.requests = value;
	}
	
	public java.util.Set<Request> getRequests() {
		return requests;
	}
	
	
	public void setSystemLogResources(java.util.Set<SystemLogResource> value) {
		this.systemLogResources = value;
	}
	
	public java.util.Set<SystemLogResource> getSystemLogResources() {
		return systemLogResources;
	}
	
	
	public void setType(Type value) {
		this.type = value;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setPermissions(java.util.Set<Permission> value) {
		this.permissions = value;
	}
	
	public java.util.Set<Permission> getPermissions() {
		return permissions;
	}
	
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
