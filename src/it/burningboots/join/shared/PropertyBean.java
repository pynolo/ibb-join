package it.burningboots.join.shared;

import java.io.Serializable;

public class PropertyBean implements Serializable {
	private static final long serialVersionUID = 5717993261825827825L;
	
	private String version = null;
	private boolean closed = true;
	private int bedAvailableFrom = -1;
	private int bedAvailableUntil = -1;
	private int tentAvailableFrom = -1;
	private int tentAvailableUntil = -1;
	
	public PropertyBean() {
	}
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public boolean getClosed() {
		return closed;
	}
	public void setClosed(boolean closed) {
		this.closed = closed;
	}
	public int getBedAvailableFrom() {
		return bedAvailableFrom;
	}
	public void setBedAvailableFrom(String bedAvailableFrom) {
		this.bedAvailableFrom = Integer.parseInt(bedAvailableFrom);
	}
	public int getTentAvailableFrom() {
		return tentAvailableFrom;
	}
	public void setTentAvailableFrom(String tentAvailableFrom) {
		this.tentAvailableFrom = Integer.parseInt(tentAvailableFrom);
	}
	public int getBedAvailableUntil() {
		return bedAvailableUntil;
	}
	public void setBedAvailableUntil(String bedAvailableUntil) {
		this.bedAvailableUntil = Integer.parseInt(bedAvailableUntil);
	}
	public int getTentAvailableUntil() {
		return tentAvailableUntil;
	}
	public void setTentAvailableUntil(String tentAvailableUntil) {
		this.tentAvailableUntil = Integer.parseInt(tentAvailableUntil);
	}
	
}
