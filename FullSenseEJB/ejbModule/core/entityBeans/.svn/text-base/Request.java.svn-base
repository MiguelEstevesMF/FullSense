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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Request")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQueries({
	@NamedQuery(name="Request.countRequests",query="SELECT count(r) FROM Request r"),
	@NamedQuery(name="Request.getRequests",query="SELECT r From Request r"),
})
public class Request implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7236733602766628447L;

	public Request() {
	}
	
	@Column(name="Id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A8017D126A09144F104E3F")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A8017D126A09144F104E3F", strategy="native")	
	private int id;
	
	@Column(name="Begin", nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date begin;
	
	@Column(name="End", nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date end;
	
	@Column(name="Used", nullable=true)
	@Enumerated(value=EnumType.STRING)
	private ReqState state;
	
	@ManyToOne(targetEntity=Resource.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="ResourceId", referencedColumnName="Id") })	
	@Basic(fetch=FetchType.EAGER)	
	private Resource resource;
	
	@ManyToOne(targetEntity=User.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="UserUser", referencedColumnName="User") })	
	@Basic(fetch=FetchType.EAGER)	
	private User user;
	
	public void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setBegin(java.util.Date value) {
		this.begin = value;
	}
	
	public java.util.Date getBegin() {
		return begin;
	}
	
	public void setEnd(java.util.Date value) {
		this.end = value;
	}
	
	public java.util.Date getEnd() {
		return end;
	}
	
	public void setResource(Resource value) {
		this.resource = value;
	}
	
	public Resource getResource() {
		return resource;
	}
	
	public void setUser(User value) {
		this.user = value;
	}
	
	public User getUser() {
		return user;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
	public ReqState getState() {
		return state;
	}

	public void setState(ReqState state) {
		this.state = state;
	}

	public enum ReqState { RESERVED, LIFTED, DELIVERED }
	
}
