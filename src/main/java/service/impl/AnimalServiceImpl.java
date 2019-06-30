package service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import model.Chicken;
import model.Dog;
import model.Parrot;
import model.animals.Animal;
import service.IAnimalService;
import utils.Constants;
import utils.ZooUtils;

public class AnimalServiceImpl implements IAnimalService {

	static Logger log = Logger.getLogger(AnimalServiceImpl.class);

	/**
	 * Make friends for animals
	 * 
	 * @animal actual animal
	 * @List<Animal> friends make friends from given list of animals
	 */
	@Override
	public Optional<Animal> makeFriends(Animal animal, List<Animal> friends) {
		log.info("***** Start finding new friends *****");
		if (animal instanceof Dog) {
			Dog dog = (Dog) animal;
			makeFriends(friends, dog);
		} else if (animal instanceof Chicken) {
			Chicken chicken = (Chicken) animal;
			makeFriends(friends, chicken);
		} else if (animal instanceof Parrot) {
			Parrot parrot = (Parrot) animal;
			makeFriends(friends, parrot);
		}

		return Optional.of(animal);

	}

	/**
	 * Unfriend animal friendship method
	 * 
	 * @Animal actual animal
	 */
	@Override
	public void loseFriend(Animal animal) {
		log.info("***** Start breaking relationships *****");
		removeFriendFrom(animal);
	}

	/**
	 * Remove friends for Animals
	 * 
	 * @param animal
	 */
	private void removeFriendFrom(Animal animal) {
		if (animal instanceof Dog) {
			Dog dog = (Dog) animal;
			unfriendAnimals(dog);
		} else if (animal instanceof Chicken) {
			Chicken chicken = (Chicken) animal;
			unfriendAnimals(chicken);
		} else if (animal instanceof Parrot) {
			Parrot parrot = (Parrot) animal;
			unfriendAnimals(parrot);

		}
	}

	/**
	 * Animals make friends method
	 * 
	 * @param friends
	 * @param animals
	 */
	private void makeFriends(List<Animal> friends, Animal animal) {
		Collection<Animal> possibleFriends = friends.stream().filter(e -> !e.equals(animal))
				.collect(Collectors.toList());
		List<Animal> newFriends = ZooUtils.getRandomAnimal((List<Animal>) possibleFriends);
		animal.setFriendList(newFriends);
		for (int i = 0; i < newFriends.size(); i++) {
			newFriends.get(i).setFriendList(Arrays.asList(animal));
			log.info(animal.getAnimalType() + " " + Constants.HAS_ESTABLISHED_FRIENDSHIP + newFriends.get(i).getName());
			log.info(newFriends.get(i).getAnimalType() + " " + newFriends.get(i).getName() + " "
					+ Constants.HAS_ESTABLISHED_FRIENDSHIP + animal.getName());
		}
	}

	/**
	 * Remove friends for dog
	 * 
	 * @param dog
	 */
	private void unfriendAnimals(Animal animal) {
		Collection<Animal> friendList = animal.getFriendList().stream().filter(e -> !e.equals(animal))
				.collect(Collectors.toList());
		List<Animal> friendToUnfriend = ZooUtils.getRandomAnimal((List<Animal>) friendList);
		for (int i = 0; i < friendToUnfriend.size(); i++) {
			friendList.remove(friendToUnfriend.get(i));
			log.info(animal.getAnimalType() + " " + Constants.HAS_LOST_FRIENDSHIP + friendToUnfriend.get(i).getName());
		}
		animal.setFriendList((List<Animal>) friendList);
	}

}
