package plugins.entityBeans;

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
import java.util.Map;

import javax.persistence.*;

import org.hibernate.annotations.CollectionOfElements;

import plugins.util.PersistablePlugin;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Bundle")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQuery(name="Bundle.getAll", query="SELECT b FROM Bundle b")
public class Bundle implements Serializable, PersistablePlugin {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2090370869227038330L;

	public Bundle() {
	}
	
	@Column(name="Id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VAC136FBD126A4CF18AE04ABF")	
	@org.hibernate.annotations.GenericGenerator(name="VAC136FBD126A4CF18AE04ABF", strategy="native")	
	private int id;
	
	@Column(name="Name", nullable=true, length=255)	
	private String name;
	
	@Column(name="Url", nullable=true, length=255)	
	private String url;
	
	@Column(name="Description", nullable=true, length=255)	
	private String description;
	
	@OneToMany(targetEntity=Method.class)
	@JoinColumns({ @JoinColumn(name="BundleId", referencedColumnName="Id") })
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set<Method> actions = new HashSet<Method>();
	
	@SuppressWarnings("unused")
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setUrl(String value) {
		this.url = value;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	

	public void setActions(java.util.Set<Method> value) {
		this.actions = value;
	}
	
	public java.util.Set<Method> getActions() {
		return actions;
	}
	
	@CollectionOfElements
    @org.hibernate.annotations.MapKey( columns = { @Column( name="mapkey" ) } )
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private Map<String, String> properties;
	
	
	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
