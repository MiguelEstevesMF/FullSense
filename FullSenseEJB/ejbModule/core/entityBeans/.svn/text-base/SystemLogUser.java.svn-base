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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("SystemLogUser")
public class SystemLogUser extends SystemLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -538197965042888118L;

	public SystemLogUser() {
	}
	
	@ManyToOne(targetEntity=User.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
	@JoinColumns({ @JoinColumn(name="UserUser", referencedColumnName="User") })
	@Basic(fetch=FetchType.EAGER)
	private User user;
	
	public void setUser(User value) {
		this.user = value;
	}
	
	public User getUser() {
		return user;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
