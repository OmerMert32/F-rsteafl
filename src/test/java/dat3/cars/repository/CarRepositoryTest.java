package dat3.cars.repository;

import dat3.cars.entity.Car;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;

    static int carId;
    static String carBrand;
    @BeforeAll
    public static void setupData(@Autowired CarRepository carRepository){
        Car car = new Car("Mercedes", "gla", 20, 7);
        carRepository.save(car);

        carBrand = car.getBrand();
        carId = car.getId();
    }

    @Test
    public void findById(){
        Car found = carRepository.findById(carId).get();
        assertEquals(carId, found.getId());
    }

    @Test
    public void findByBrand(){
        Car found = carRepository.findCarByBrand(carBrand);
        assertEquals(carBrand, found.getBrand());
    }

    @Test
    public void deleteById(){
        int antal = (int) carRepository.count();

        carRepository.delete(carRepository.findById(carId).get());

        assertEquals(antal - 1, 0);
    }

}