package service;

import java.util.List;
import java.util.Optional;

import model.animals.Animal;

public interface IAnimalService {

	Optional<Animal> makeFriends(Animal animal, List<Animal> friends);

	void loseFriend(Animal animal);

}
