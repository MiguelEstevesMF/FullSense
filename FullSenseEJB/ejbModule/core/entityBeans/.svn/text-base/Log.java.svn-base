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
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Log")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Discriminator", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Log")
public class Log implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3502171739379557831L;

	public Log() {
	}
	
	@Column(name="Id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A8017D126A09144E104E3E")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A8017D126A09144E104E3E", strategy="native")	
	private int id;
	
	@Column(name="Time", nullable=true)	
	private java.util.Date time;
	
	@Column(name="`Desc`", nullable=true, length=255)	
	private String desc;
	
	public void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setTime(java.util.Date value) {
		this.time = value;
	}
	
	public java.util.Date getTime() {
		return time;
	}
	
	public void setDesc(String value) {
		this.desc = value;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
