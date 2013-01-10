package plugins.entityBeans;

import java.io.Serializable;
import javax.persistence.*;

import plugins.util.PersistablePlugin;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Behavior")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQueries({
	@NamedQuery(name="Behavior.getAll", query="SELECT b FROM Behavior b JOIN b.source bs WHERE bs.id=:sid"),
	@NamedQuery(name="getRecords", query="SELECT tl FROM TrackingLog tl  WHERE tl.time >= :begin AND tl.time <= :end")
})
public class Behavior implements Serializable,PersistablePlugin {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2442330443668980735L;

	public Behavior() {
	}
	
	@Column(name="Id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VAC136FBD126A4CF189F04ABD")	
	@org.hibernate.annotations.GenericGenerator(name="VAC136FBD126A4CF189F04ABD", strategy="native")	
	private int id;
	
	@Column(name="Name", nullable=true, length=255)	
	private String name;
	
	@Column(name="Context", nullable=false)	
	private int context;
	
	@Column(name="`Condition`", nullable=true, length=255)	
	private String condition;
	
	@Column(name="Parameters", nullable=true, length=255)	
	private String parameters;
	
	@ManyToOne(targetEntity=Method.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="MethodId", referencedColumnName="Id") })	
	@Basic(fetch=FetchType.EAGER)	
	private Method action;
	
	@ManyToOne(targetEntity=Method.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="MethodId2", referencedColumnName="Id") })	
	@Basic(fetch=FetchType.EAGER)	
	private Method source;
	
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
	
	public void setContext(int value) {
		this.context = value;
	}
	
	public int getContext() {
		return context;
	}
	
	public void setCondition(String value) {
		this.condition = value;
	}
	
	public String getCondition() {
		return condition;
	}
	
	public void setParameters(String value) {
		this.parameters = value;
	}
	
	public String getParameters() {
		return parameters;
	}
	
	public void setAction(Method value) {
		this.action = value;
	}
	
	public Method getAction() {
		return action;
	}
	
	public void setSource(Method value) {
		this.source = value;
	}
	
	public Method getSource() {
		return source;
	}
	
	public String toString() {	
		return String.valueOf(getId());
	}
	
	public void addCondition(Object... objects){
		StringBuilder sb = new StringBuilder();		
		for (Object o : objects){
			sb.append(o);
			sb.append(':');
		}
		sb.setCharAt(sb.length()-1,'#');
		if(condition != null){
			if(condition.equals("")){
				condition = "#"+sb.toString();
			}
			else{
				condition = condition+sb.toString();
			}
		}
		else{
			condition = "#"+sb.toString();
		}
	}
	
	public void addParameters(Object... objects){
		StringBuilder sb = new StringBuilder();		
		for (Object o : objects){
			sb.append(o);
			sb.append(':');
		}
		sb.setCharAt(sb.length()-1,'#');
		if(parameters != null){
			if(parameters.equals("")){
				parameters = "#"+sb.toString();
			}
			else{
				parameters = parameters+sb.toString();
			}
		}
		else{
			parameters = "#"+sb.toString();
		}
	}
	
}
