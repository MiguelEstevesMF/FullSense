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

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("CompsiteShape")
public class CompositeShape extends Area implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4628500618415354780L;

	public CompositeShape() {
	}
	
	@OneToMany(targetEntity=SimpleShape.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumn(name="AreaId", nullable=true)	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set<SimpleShape> simpleShapes = new java.util.HashSet<SimpleShape>();
	
	public void setSimpleShapes(java.util.Set<SimpleShape> value) {
		this.simpleShapes = value;
	}
	
	public java.util.Set<SimpleShape> getSimpleShapes() {
		return simpleShapes;
	}
	
	
	public String toString() {
		return super.toString();
	}
	
}
