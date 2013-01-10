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
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Circle")
public class Circle extends SimpleShape implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1183999067409468118L;

	public Circle() {
	}
	
	@Column(name="CX", nullable=true)	
	private int cX;
	
	@Column(name="CY", nullable=true)	
	private int cY;
	
	@Column(name="Radius", nullable=true)	
	private double radius;
	
	public void setcX(int value) {
		this.cX = value;
	}
	
	public int getcX() {
		return cX;
	}
	
	public void setcY(int value) {
		this.cY = value;
	}
	
	public int getcY() {
		return cY;
	}
	
	public void setRadius(double value) {
		this.radius = value;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
