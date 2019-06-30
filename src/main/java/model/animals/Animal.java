package model.animals;

import java.util.List;
import java.util.Objects;

import model.AnimalType;

public class Animal {

	private String name;
	private String favoriteFood;
	private List<Animal> friendList;
	private AnimalType animalType;

	public Animal() {
	}

	public Animal(String name, String favoriteFood, List<Animal> friendList) {
		this.name = name;
		this.favoriteFood = favoriteFood;
		this.friendList = friendList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public List<Animal> getFriendList() {
		return friendList;
	}

	public void setFriendList(List<Animal> friendList) {
		this.friendList = friendList;
	}

	public AnimalType getAnimalType() {
		return animalType;
	}

	public void setAnimalType(AnimalType animalType) {
		this.animalType = animalType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(animalType, favoriteFood, friendList, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return animalType == other.animalType && Objects.equals(favoriteFood, other.favoriteFood)
				&& Objects.equals(friendList, other.friendList) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", favoriteFood=" + favoriteFood + ", friendList=" + friendList
				+ ", animalType=" + animalType + "]";
	}

}
