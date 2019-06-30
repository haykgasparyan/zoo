package model;

import java.util.Objects;

import model.animals.Animal;

public class Dog extends Animal {

	private DogType dogType;

	public Dog() {
	}

	public DogType getDogType() {
		return dogType;
	}

	public void setDogType(DogType dogType) {
		this.dogType = dogType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dogType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		return dogType == other.dogType;
	}

	@Override
	public String toString() {
		return "Dog [dogType=" + dogType + "]";
	}

}
