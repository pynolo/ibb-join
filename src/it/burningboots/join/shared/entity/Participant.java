package it.burningboots.join.shared.entity;

import it.burningboots.join.shared.AppConstants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class Participant implements Serializable {
	private static final long serialVersionUID = -7816100274638131540L;
	
	@PrimaryKey
	private String itemNumberKey = "";//Codice personale
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
	@Persistent
	private Integer accommodationType = AppConstants.ACCOMMODATION_DEFAULT;
	
	@Persistent(defaultFetchGroup = "true")
	private ArrayList<IpnResponse> ipnResponses;
	
	
	public Participant() {
	}
	
	public Participant(String itemNumberKey) {
		this.itemNumberKey = itemNumberKey;
	}
	
	public Participant(String itemNumberKey, String email,
			String firstName, String lastName, Date created,
			String arrivalTime, String countryName, String foodRestrictions,
			String volunteering, Double amount, Date paymentDt,
			Integer accommodationType) {
		this.itemNumberKey = itemNumberKey;
		this.email = email;
		this.firstName = firstName;
		this.created = created;
		this.arrivalTime = arrivalTime;
		this.countryName = countryName;
		this.foodRestrictions = foodRestrictions;
		this.volunteering = volunteering;
		this.amount = amount;
		this.paymentDt = paymentDt;
		this.accommodationType = accommodationType;
	}

	public String getItemNumberKey() {
		return itemNumberKey;
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

	public Integer getAccommodationType() {
		return accommodationType;
	}

	public void setAccommodationType(Integer accommodationType) {
		this.accommodationType = accommodationType;
	}

	public ArrayList<IpnResponse> getIpnResponses() {
		return ipnResponses;
	}

	public void setIpnResponses(ArrayList<IpnResponse> ipnResponses) {
		this.ipnResponses = ipnResponses;
	}

}
