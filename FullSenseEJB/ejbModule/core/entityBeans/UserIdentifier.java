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
@DiscriminatorValue("UserIdentifier")
@NamedQueries({
	@NamedQuery(name="UserIdentifier.countUserIdentifiers",query="SELECT count(ui) FROM UserIdentifier ui"),
	@NamedQuery(name="UserIdentifier.getUserIdentifiers",query="SELECT ui From UserIdentifier ui"),
})
public class UserIdentifier extends Identifier implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4013278242510418327L;

	public UserIdentifier() {
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
