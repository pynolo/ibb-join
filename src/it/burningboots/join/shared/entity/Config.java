package it.burningboots.join.shared.entity;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class Config extends Entity {
	
	@PrimaryKey
	private String key;
	@Persistent
	private String val;
	

	public Config(String key, String value) {
		this.key = key;
		this.val = value;
	}
	
	@Override
	public String getKey() {
		return key;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
		
}
