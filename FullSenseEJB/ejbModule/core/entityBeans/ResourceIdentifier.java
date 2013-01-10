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
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("ResourceIdentifier")
@NamedQueries({
	@NamedQuery(name="ResourceIdentifier.countResourceIdentifiers",query="SELECT count(ri) FROM ResourceIdentifier ri"),
	@NamedQuery(name="ResourceIdentifier.getResourceIdentifiers",query="SELECT ri From ResourceIdentifier ri"),
})
public class ResourceIdentifier extends Identifier implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2092004881495734556L;

	public ResourceIdentifier() {
	}
	
	@ManyToOne(targetEntity=IdentifiableResource.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="ResourceId", referencedColumnName="Id") })	
	@Basic(fetch=FetchType.EAGER)	
	private IdentifiableResource identifiableResource;
	
	public void setIdentifiableResource(IdentifiableResource value) {
		this.identifiableResource = value;
	}
	
	public IdentifiableResource getIdentifiableResource() {
		return identifiableResource;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
