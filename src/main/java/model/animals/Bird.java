package model.animals;

import java.util.Objects;

import model.BirdType;

public class Bird extends Animal {

	private float lengthOfWings;
	private BirdType birdType;

	public Bird() {
	}

	public float getLengthOfWings() {
		return lengthOfWings;
	}

	public void setLengthOfWings(float lengthOfWings) {
		this.lengthOfWings = lengthOfWings;
	}

	public BirdType getBirdType() {
		return birdType;
	}

	public void setBirdType(BirdType birdType) {
		this.birdType = birdType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birdType, lengthOfWings);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bird other = (Bird) obj;
		return birdType == other.birdType
				&& Float.floatToIntBits(lengthOfWings) == Float.floatToIntBits(other.lengthOfWings);
	}

	@Override
	public String toString() {
		return "Birds [lengthOfWings=" + lengthOfWings + ", birdType=" + birdType + "]";
	}

}
