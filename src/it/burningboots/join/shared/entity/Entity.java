package it.burningboots.join.shared.entity;

public abstract class Entity {

	public abstract String getKey();
	
	public boolean equals(Object object) {
		if (!(object instanceof Config)) {
			return false;
		}
		Config other = (Config) object;
		if ((this.getKey() == null && other.getKey() != null)
				|| (this.getKey() != null && !this.getKey().equals(other.getKey()))) {
			return false;
		}
		return true;
	}
	
	public String toString() {
		return this.getClass().getSimpleName()+"[key=" + getKey() + "]";
	}
}
