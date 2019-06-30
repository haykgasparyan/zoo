package app;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import model.AnimalType;
import model.Chicken;
import model.Dog;
import model.DogType;
import model.Parrot;
import model.animals.Animal;
import service.impl.AnimalServiceImpl;
import utils.ZooUtils;

public class Zoo {

	static Logger log = Logger.getLogger(Zoo.class);

	public static void main(String[] args) {

		AnimalServiceImpl animalService = new AnimalServiceImpl();

		Dog dog1 = ZooUtils.createDog("Killian", DogType.HUNTING_DOG, "Meat", null, AnimalType.DOG);
		Dog dog2 = ZooUtils.createDog("Rocky", DogType.WORKING_DOG, "Freash Meat", null, AnimalType.DOG);
		Dog dog3 = ZooUtils.createDog("Peter", DogType.SPORT_DOG, "Pedigree", null, AnimalType.DOG);
		Parrot parrot1 = ZooUtils.createParrot("Parrot One", false, "Grain", 0.25f, null, AnimalType.PARROT);
		Parrot parrot2 = ZooUtils.createParrot("Parrot Two", true, "Corn", 0.5f, null, AnimalType.PARROT);
		Chicken chicken1 = ZooUtils.createChicken("Chicken One", true, "Corn", 0.75f, null, AnimalType.CHICKEN);
		Chicken chicken2 = ZooUtils.createChicken("Chicken Two", false, "Corn", 0.75f, null, AnimalType.CHICKEN);

		List<Animal> animals = Arrays.asList(dog1, dog2, dog3, parrot1, parrot2, chicken1, chicken2);

		animalService.makeFriends(dog1, animals);
		animalService.loseFriend(dog1);
		log.info("*****************");
		animalService.makeFriends(dog2, animals);
		animalService.loseFriend(dog2);
		animalService.makeFriends(dog3, animals);
		animalService.loseFriend(dog3);
		log.info("*****************");
		animalService.makeFriends(parrot1, animals);
		animalService.loseFriend(parrot1);
		animalService.makeFriends(parrot2, animals);
		animalService.loseFriend(parrot2);
		log.info("*****************");
		animalService.makeFriends(chicken1, animals);
		animalService.loseFriend(chicken1);
		animalService.makeFriends(chicken2, animals);
		animalService.loseFriend(chicken2);

	}

}
