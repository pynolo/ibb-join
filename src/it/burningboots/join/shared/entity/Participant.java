package it.burningboots.join.shared.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class Participant extends Entity implements Serializable {
	private static final long serialVersionUID = -7816100274638131540L;
	
	@PrimaryKey
	private String key = "";
	@Persistent
	private String itemNumber = "";//Codice personale
	@Persistent
	private String email = "";
	@Persistent
	private String firstName = "";
	@Persistent
	private String lastName = "";
	@Persistent
	private Date created = null;
	@Persistent
	private String arrivalTime = "";
	@Persistent
	private String countryName = "";
	@Persistent
	private String foodRestrictions = "";
	@Persistent
	private String volunteering = "";
	@Persistent
	private Double amount = null;
	@Persistent
	private Date paymentDt = null;
	
	@Persistent(defaultFetchGroup = "true")
	private Collection<IpnResponse> ipnResponses;
	
	public Participant() {}
	
	public Participant(String key, String itemNumber, String email,
			String firstName, String lastName, Date created,
			String arrivalTime, String countryName, String foodRestrictions,
			String volunteering, Double amount, Date paymentDt,
			Collection<IpnResponse> ipnResponses) {
		this.key = key;
		this.itemNumber = itemNumber;
		this.email = email;
		this.firstName = firstName;
		this.created = created;
		this.arrivalTime = arrivalTime;
		this.countryName = countryName;
		this.foodRestrictions = foodRestrictions;
		this.volunteering = volunteering;
		this.amount = amount;
		this.paymentDt = paymentDt;
		this.ipnResponses = ipnResponses;
	}

	@Override
	public String getKey() {
		return key;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getFoodRestrictions() {
		return foodRestrictions;
	}

	public void setFoodRestrictions(String foodRestrictions) {
		this.foodRestrictions = foodRestrictions;
	}

	public String getVolunteering() {
		return volunteering;
	}

	public void setVolunteering(String volunteering) {
		this.volunteering = volunteering;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getPaymentDt() {
		return paymentDt;
	}

	public void setPaymentDt(Date paymentDt) {
		this.paymentDt = paymentDt;
	}

	public Collection<IpnResponse> getIpnResponses() {
		return ipnResponses;
	}

	public void setIpnResponses(Collection<IpnResponse> ipnResponses) {
		this.ipnResponses = ipnResponses;
	}

}
