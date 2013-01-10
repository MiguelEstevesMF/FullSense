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

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;




@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("IdentifiableResource")
@NamedQueries({
	@NamedQuery(name="IdentifiableResource.countPermissionWithStationaryResource",query="SELECT count(ir) From IdentifiableResource ir JOIN ir.permissionGroups irpgs JOIN irpgs.permissions irpgsps JOIN irpgsps.resource r WHERE r.id=:srid AND ir.id=:irid AND (ir.active=true OR false=:filter)"),
})	
public class IdentifiableResource extends Resource implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7565295056486400085L;

	public IdentifiableResource() {
	}
	
	@OneToMany(targetEntity=ResourceIdentifier.class)
	@JoinColumns({ @JoinColumn(name="ResourceId", referencedColumnName="Id") })	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set<ResourceIdentifier> resourceIdentifiers = new HashSet<ResourceIdentifier>();
	

	@ManyToMany(mappedBy="identifiableResources", targetEntity=PermissionGroup.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="PermissionGroup_identifiableResources", joinColumns={ @JoinColumn(name="ID") }, inverseJoinColumns={ @JoinColumn(name="PermissionGroupId") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set<PermissionGroup> permissionGroups = new java.util.HashSet<PermissionGroup>();
	
	
	
	public java.util.Set<PermissionGroup> getPermissionGroups() {
		return permissionGroups;
	}

	public void setPermissionGroups(java.util.Set<PermissionGroup> permissionGroups) {
		this.permissionGroups = permissionGroups;
	}

	public void setResourceIdentifiers(java.util.Set<ResourceIdentifier> value) {
		this.resourceIdentifiers = value;
	}
	
	public java.util.Set<ResourceIdentifier> getResourceIdentifiers() {
		return resourceIdentifiers;
	}
	
	
	public String toString() {
		return super.toString();
	}
	
}
