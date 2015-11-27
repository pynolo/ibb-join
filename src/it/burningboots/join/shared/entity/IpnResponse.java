package it.burningboots.join.shared.entity;

import java.io.Serializable;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class IpnResponse extends Entity implements Serializable {
	private static final long serialVersionUID = 6665621291812512821L;
	
	@PrimaryKey
	private String key;
	@Persistent
	private String itemNumber;
	@Persistent
	private String paymentStatus;
	@Persistent
	private String payerEmail;
	@Persistent
	private String mcGross;
	@Persistent
	private String mcCurrency;
	@Persistent
	private String paymentDate;
	@Persistent
	private String pendingReason;
	@Persistent
	private String paymentType;
	
	@Persistent
	private Participant participant;
	
	public IpnResponse() {
	}
	
	public IpnResponse(String key, String itemNumber, String paymentStatus, String payerEmail,
			String mcGross, String mcCurrency, String paymentDate,
			String pendingReason, String paymentType) {
		this.key = key;
		this.itemNumber = itemNumber;
		this.paymentStatus = paymentStatus;
		this.payerEmail = payerEmail;
		this.mcGross = mcGross;
		this.mcCurrency = mcCurrency;
		this.paymentDate = paymentDate;
		this.pendingReason = pendingReason;
		this.paymentType = paymentType;
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

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPayerEmail() {
		return payerEmail;
	}

	public void setPayerEmail(String payerEmail) {
		this.payerEmail = payerEmail;
	}

	public String getMcGross() {
		return mcGross;
	}

	public void setMcGross(String mcGross) {
		this.mcGross = mcGross;
	}

	public String getMcCurrency() {
		return mcCurrency;
	}

	public void setMcCurrency(String mcCurrency) {
		this.mcCurrency = mcCurrency;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPendingReason() {
		return pendingReason;
	}

	public void setPendingReason(String pendingReason) {
		this.pendingReason = pendingReason;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
}
