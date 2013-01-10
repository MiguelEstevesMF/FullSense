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
@DiscriminatorValue("Rectangle")
public class Rectangle extends SimpleShape implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3659943993950209514L;

	public Rectangle() {
	}
	
	@Column(name="CieX", nullable=true)	
	private int cieX;
	
	@Column(name="CieY", nullable=true)	
	private int cieY;
	
	@Column(name="CsdX", nullable=true)	
	private int csdX;
	
	@Column(name="CsdY", nullable=true)	
	private int csdY;
	
	public void setCieX(int value) {
		this.cieX = value;
	}
	
	public int getCieX() {
		return cieX;
	}
	
	public void setCieY(int value) {
		this.cieY = value;
	}
	
	public int getCieY() {
		return cieY;
	}
	
	public void setCsdX(int value) {
		this.csdX = value;
	}
	
	public int getCsdX() {
		return csdX;
	}
	
	public void setCsdY(int value) {
		this.csdY = value;
	}
	
	public int getCsdY() {
		return csdY;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
