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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Type")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQueries({
	@NamedQuery(name="Type.countTypes",query="SELECT count(t) FROM Type t"),
	@NamedQuery(name="Type.getTypes",query="SELECT t From Type t"),
})
public class Type implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8104461012925964817L;

	public Type() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Type))
			return false;
		Type type = (Type)aObj;
		if ((getName() != null && !getName().equals(type.getName())) || (getName() == null && type.getName() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getName() == null ? 0 : getName().hashCode());
		return hashcode;
	}
	
	@Column(name="Name", nullable=false)	
	@Id	
	private String name; //Projector, TV, PC, Laptop, Table, Room, Lab, ConferenceRoom, WC, Auditorium, Bar
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public String getORMID() {
		return getName();
	}
	
	public String toString() {
		return String.valueOf(getName());
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
