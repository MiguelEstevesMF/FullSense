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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Area")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Discriminator", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Area")
public class Area implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3678022202695568052L;
	
	@Transient
	private boolean inUpdate = false;

	public Area() {
	}
	
	@Column(name="Id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A8017D126A09144D104E3D")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A8017D126A09144D104E3D", strategy="native")	
	private int id;
	
	@Column(name="Floor", nullable=false)	
	private int floor;
	
	@OneToOne(mappedBy="area", targetEntity=StationaryResource.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="ResourceId") })	
	@Basic(fetch=FetchType.EAGER)	
	private StationaryResource stationaryResource;
	
	@OneToMany(targetEntity=Detector.class)
	@JoinColumns({ @JoinColumn(name="AreaId", referencedColumnName="Id") })
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set<Detector> detectors = new HashSet<Detector>();
	
	public void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setFloor(int value) {
		this.floor = value;
	}
	
	public int getFloor() {
		return floor;
	}
	
	public void setStationaryResource(StationaryResource value) {
		if(!inUpdate){
			inUpdate = true;
			value.setArea(this);
			inUpdate = false;
			this.stationaryResource = value;
		}
	}
	
	public StationaryResource getStationaryResource() {
		return stationaryResource;
	}
	
	public void setDetectors(java.util.Set<Detector> value) {
		this.detectors = value;
	}
	
	public java.util.Set<Detector> getDetectors() {
		return detectors;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
