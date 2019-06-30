package zoo;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import model.AnimalType;
import model.Chicken;
import model.Dog;
import model.DogType;
import model.Parrot;
import model.animals.Animal;
import service.IAnimalService;
import service.impl.AnimalServiceImpl;
import utils.ZooUtils;

public class ZooTest {

	static Logger log = Logger.getLogger(ZooTest.class);

	private final IAnimalService service = new AnimalServiceImpl();

	Dog dog;
	Parrot parrot;
	Chicken chicken;
	List<Animal> animals;

	@BeforeEach
	void setup() {
		log.info("Creating all animals");
		dog = ZooUtils.createDog("Killian", DogType.HUNTING_DOG, "Meat", null, AnimalType.DOG);
		parrot = ZooUtils.createParrot("Parrot One", false, "Grain", 0.25f, null, AnimalType.PARROT);
		chicken = ZooUtils.createChicken("Chicken One", true, "Corn", 0.75f, null, AnimalType.CHICKEN);

		animals = Arrays.asList(dog, parrot, chicken);
	}

	@Test
	@Order(2)
	@DisplayName("Dog making friends")
	void dogMakingFriendshipSuccesfully() {
		Optional<Animal> animalList = service.makeFriends(dog, animals);
		assertTrue(animalList.isPresent());
		assertTrue(!dog.getFriendList().isEmpty());
	}

	@Test
	@Order(1)
	@DisplayName("Dog losing friends")
	void dogLosingFriends() {
		dog.setFriendList(animals);
		service.loseFriend(dog);
		assertNotEquals(dog.getFriendList().size(), animals.size());
	}

}
