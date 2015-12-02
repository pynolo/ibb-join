package it.burningboots.join.shared.entity;

import java.io.Serializable;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class Config implements Serializable {
	private static final long serialVersionUID = 2573558514344018622L;
	
	@PrimaryKey
	private String nameKey;
	@Persistent
	private String val;
	
	public Config() {
	}
	
	public Config(String nameKey, String value) {
		this.nameKey = nameKey;
		this.val = value;
	}

	public String getNameKey() {
		return nameKey;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
		
}
