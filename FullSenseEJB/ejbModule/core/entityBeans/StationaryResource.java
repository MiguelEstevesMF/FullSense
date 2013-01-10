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
import javax.persistence.OneToOne;
import javax.persistence.Transient;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("StationaryResource")
public class StationaryResource extends Resource implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5307447591996728233L;
	
	@Transient
	private boolean inUpdate = false;

	public StationaryResource() {
	}
	
	@OneToOne(targetEntity=Area.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@Basic(fetch=FetchType.EAGER)	
	private Area area;
	
	public void setArea(Area value) {
		if(!inUpdate){
			inUpdate = true;
			value.setStationaryResource(this);
			inUpdate = false;
			this.area = value;
		}
	}
	
	public Area getArea() {
		return area;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
