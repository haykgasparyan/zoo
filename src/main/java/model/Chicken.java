package model;

import java.util.Objects;

import model.animals.Bird;

public class Chicken extends Bird {

	private boolean isBroiler;

	public Chicken() {
	}

	public boolean isBroiler() {
		return isBroiler;
	}

	public void setBroiler(boolean isBroiler) {
		this.isBroiler = isBroiler;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isBroiler);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chicken other = (Chicken) obj;
		return isBroiler == other.isBroiler;
	}

	@Override
	public String toString() {
		return "Chicken [isBroiler=" + isBroiler + "]";
	}

}
