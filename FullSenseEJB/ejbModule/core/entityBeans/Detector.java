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
import javax.persistence.Column;
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
@Table(name="Detector")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQueries({
	@NamedQuery(name="Detector.countDetectors",query="SELECT count(d) FROM Detector d"),
	@NamedQuery(name="Detector.getDetectors",query="SELECT d From Detector d"),
	@NamedQuery(name="Detector.getDetectorFetchTrackinglogs",query="SELECT d From Detector d LEFT JOIN FETCH d.trackingLogs WHERE d.id=:id"),
})
public class Detector implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8814648363974101969L;

	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Detector))
			return false;
		Detector detector = (Detector)aObj;
		if ((getId() != null && !getId().equals(detector.getId())) || (getId() == null && detector.getId() != null))
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
	
	@ManyToOne(targetEntity=Area.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="AreaId", referencedColumnName="Id") })	
	@Basic(fetch=FetchType.EAGER)	
	private Area area;
	
	@OneToMany(targetEntity=TrackingLog.class)
	@JoinColumns({ @JoinColumn(name="DetectorId", referencedColumnName="Id") })	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set<TrackingLog> trackingLogs = new java.util.HashSet<TrackingLog>();
	
	public void setId(String value) {
		this.id = value;
	}
	
	public String getId() {
		return id;
	}
	
	public String getORMID() {
		return getId();
	}
	
	public void setArea(Area value) {
		this.area = value;
	}
	
	public Area getArea() {
		return area;
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