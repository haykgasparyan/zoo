package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.AnimalType;
import model.Chicken;
import model.Dog;
import model.DogType;
import model.Parrot;
import model.animals.Animal;

public class ZooUtils {

	public static List<Animal> getRandomAnimal(List<Animal> friends) {
		Random rand = new Random();
		List<Animal> result = new ArrayList<>();
		for (int i = 0; i < rand.nextInt(friends.size()) + 1; i++) {
			result.add(friends.get(i));
		}
		return result;
	}

	public static Parrot createParrot(String name, boolean canSpeak, String faveFood, float f,
			List<Animal> friendList, AnimalType animalType) {
		Parrot parrot = new Parrot();
		parrot.setName(name);
		parrot.setCanSpeak(canSpeak);
		parrot.setFavoriteFood(faveFood);
		parrot.setLengthOfWings(f);
		parrot.setFriendList(friendList);
		parrot.setAnimalType(animalType);
		return parrot;
	}

	public static Dog createDog(String name, DogType dogType, String favoriteFood, List<Animal> friendList,
			AnimalType animalType) {
		Dog dog = new Dog();
		dog.setName(name);
		dog.setDogType(dogType);
		dog.setFavoriteFood(favoriteFood);
		dog.setFriendList(friendList);
		dog.setAnimalType(animalType);
		return dog;
	}

	public static Chicken createChicken(String name, boolean isBroiler, String faveFood, float wingLength,
			List<Animal> friendList, AnimalType animalType) {
		Chicken chicken = new Chicken();
		chicken.setName(name);
		chicken.setBroiler(isBroiler);
		chicken.setFavoriteFood(faveFood);
		chicken.setLengthOfWings(wingLength);
		chicken.setFriendList(friendList);
		chicken.setAnimalType(animalType);
		return chicken;
	}

}
