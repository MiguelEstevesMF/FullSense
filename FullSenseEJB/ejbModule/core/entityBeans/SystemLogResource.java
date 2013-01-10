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
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("SystemLogResource")
public class SystemLogResource extends SystemLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4674974226007933557L;

	public SystemLogResource() {
	}
	
	@ManyToOne(targetEntity=Resource.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="ResourceId", referencedColumnName="Id") })	
	@Basic(fetch=FetchType.EAGER)	
	private Resource resource;
	
	public void setResource(Resource value) {
		this.resource = value;
	}
	
	public Resource getResource() {
		return resource;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
