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
import java.util.HashSet;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;




@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Identifier")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Discriminator", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Identifier")
@NamedQueries({
	@NamedQuery(name="Identifier.countIdentifiers",query="SELECT count(i) FROM Identifier i"),
	@NamedQuery(name="Identifier.getIdentifiers",query="SELECT i From Identifier i"),
	@NamedQuery(name="Identifier.getIdentifierFetchTrackinglogs",query="SELECT i From Identifier i LEFT JOIN FETCH i.trackingLogs WHERE i.id=:id"),
	@NamedQuery(name="Identifier.unlinked",query="SELECT i FROM Identifier i JOIN i.trackingLogs itl JOIN i.protocol ip WHERE ip.name=:protocol AND i.class=Identifier AND itl.time>=:begin AND itl.time<=:end")
})
public class Identifier implements Serializable {

	private static final long serialVersionUID = -6132663371732848123L;

	public Identifier() {
		// TODO Auto-generated constructor stub
	}

	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Identifier))
			return false;
		Identifier identifier = (Identifier)aObj;
		if ((getId() != null && !getId().equals(identifier.getId())) || (getId() == null && identifier.getId() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getId() == null ? 0 : getId().hashCode());
		return hashcode;
	}
	
	@Column(name="Id", nullable=false)	
	@Id	
	private String id;
	
	@ManyToOne(targetEntity=Protocol.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="ProtocolName", referencedColumnName="Name") })	
	@Basic(fetch=FetchType.EAGER)	
	private Protocol protocol;
	
	@OneToMany(targetEntity=TrackingLog.class)
	@JoinColumns({ @JoinColumn(name="IdentifierId", referencedColumnName="Id") })
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set<TrackingLog> trackingLogs = new HashSet<TrackingLog>();
	
	public void setId(String value) {
		this.id = value;
	}
	
	public String getId() {
		return id;
	}
	
	public String getORMID() {
		return getId();
	}
	
	public void setProtocol(Protocol value) {
		this.protocol = value;
	}
	
	public Protocol getProtocol() {
		return protocol;
	}
	
	public void setTrackingLogs(java.util.Set<TrackingLog> value) {
		this.trackingLogs = value;
	}
	
	public java.util.Set<TrackingLog> getTrackingLogs() {
		return trackingLogs;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
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
