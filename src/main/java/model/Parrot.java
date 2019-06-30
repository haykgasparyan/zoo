package model;

import java.util.Objects;

import model.animals.Bird;

public class Parrot extends Bird {

	private boolean canSpeak;

	public Parrot() {
	}

	public boolean isCanSpeak() {
		return canSpeak;
	}

	public void setCanSpeak(boolean canSpeak) {
		this.canSpeak = canSpeak;
	}

	@Override
	public int hashCode() {
		return Objects.hash(canSpeak);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parrot other = (Parrot) obj;
		return canSpeak == other.canSpeak;
	}

	@Override
	public String toString() {
		return "Parrot [canSpeak=" + canSpeak + "]";
	}

}
