package tubryansk.lisitsyn.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tubryansk.lisitsyn.cars.entity.Car;
import tubryansk.lisitsyn.cars.entity.CarDrive;
import tubryansk.lisitsyn.cars.entity.CarEngineType;

import java.util.List;

public interface CarRepo extends JpaRepository<Car,Long> {
    List<Car> findByModel(String model);
    List<Car> findAllByYear(Integer year);
    List<Car> findAllByEngineType(CarEngineType engineType);
    List<Car> findAllByDrive(CarDrive engineType);
    List<Car> findAllByEngineHp(Integer engineHP);
    List<Car> findAllByColor(String color);
    Car findById(Integer id);
}
