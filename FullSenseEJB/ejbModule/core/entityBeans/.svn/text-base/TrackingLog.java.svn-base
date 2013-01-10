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
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("TrackingLog")
public class TrackingLog extends Log implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8589350050172943201L;

	public TrackingLog() {
	}
	@ManyToOne(targetEntity=Detector.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="DetectorId", referencedColumnName="Id") })	
	@Basic(fetch=FetchType.EAGER)	
	private Detector detector;
	
	@ManyToOne(targetEntity=Identifier.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="IdentifierId", referencedColumnName="Id") })	
	@Basic(fetch=FetchType.EAGER)	
	private Identifier identifier;
	
	public void setDetector(Detector value) {
		this.detector = value;
	}
	
	public Detector getDetector() {
		return detector;
	}
	
	public void setIdentifier(Identifier value) {
		this.identifier = value;
	}
	
	public Identifier getIdentifier() {
		return identifier;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
