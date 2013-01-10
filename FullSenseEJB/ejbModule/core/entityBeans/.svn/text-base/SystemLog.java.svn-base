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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("SystemLog")
public class SystemLog extends Log implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3097162462784200903L;

	public SystemLog() {
	}

	@Column(name="Type", nullable=true, length=255)
	@Enumerated(value=EnumType.STRING)
	private SLType type;

	public SLType getType() {
		return type;
	}

	public void setType(SLType type) {
		this.type = type;
	}
	
	public String toString() {
		return super.toString();
	}

	public enum SLType { DELETE, DROP, INSERT, UPDATE, LOGINFAIL, LOGIN, PHYSICALACCESSDENIED }
}
