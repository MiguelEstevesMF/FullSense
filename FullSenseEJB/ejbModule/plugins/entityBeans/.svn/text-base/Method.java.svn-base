package plugins.entityBeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.*;

import org.hibernate.annotations.CollectionOfElements;
import plugins.util.FSMap;
import plugins.util.Pair;
import plugins.util.PersistablePlugin;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Method")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQuery(name="Method.getCondition", query="SELECT m FROM Method m LEFT JOIN FETCH m.bundle mb WHERE mb.name=:bundleName AND size(m.parametersPersist)=1 AND :type = any elements(m.parametersPersist)")
public class Method implements Serializable, PersistablePlugin {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7466122544968570588L;

	public Method() {
		parametersPersist = new HashMap<String, String>();
		
	}
	
	@Column(name="Id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VAC136FBD126A4CF189F04ABE")	
	@org.hibernate.annotations.GenericGenerator(name="VAC136FBD126A4CF189F04ABE", strategy="native")	
	private int id;
	
	@Column(name="Name", nullable=true, length=255)	
	private String name;
	
	@Column(name="Description", nullable=true, length=255)	
	private String description;
	
	@Column(name="Modifier", nullable=true, length=255)
	private String modifier;
	
	@ManyToOne(targetEntity=Bundle.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK,org.hibernate.annotations.CascadeType.SAVE_UPDATE})	
	@JoinColumns({ @JoinColumn(name="BundleId", referencedColumnName="Id") })	
	@Basic(fetch=FetchType.EAGER)	
	private Bundle bundle;
	
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
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setBundle(Bundle value) {
		this.bundle = value;
	}
	
	public Bundle getBundle() {
		return bundle;
	}
	
	@CollectionOfElements
    @org.hibernate.annotations.MapKey( columns = { @Column( name="mapkey" ) } )
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private Map<String, String> exitValues;
	
	
	
	public Map<String, String> getExitValues() {
		return exitValues;
	}

	public void setExitValues(Map<String, String> exitValues) {
		this.exitValues = exitValues;
	}

	@Transient
	transient private FSMap parameters;
	
	@CollectionOfElements
    @org.hibernate.annotations.MapKey( columns = { @Column( name="mapkey" ) } )
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)
	private Map<String, String> parametersPersist;
	

	@SuppressWarnings("unused")
	private Map<String, String> getParametersPersist() {
		return parametersPersist;
	}

	@SuppressWarnings("unused")
	private void setParametersPersist(Map<String, String> parameters) {
		parametersPersist = parameters;
	}

	public String toString() {
		return String.valueOf(getId());
	}

	public void setParameters(Map<String, Pair> parameters) {
		this.parameters = new FSMap(parameters);
		parametersPersist = this.parameters.getMap();
	}

	public Map<String, Pair> getParameters() {
		parameters = new FSMap(parametersPersist,true);
		return parameters;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getModifier() {
		return modifier;
	}
	
}
