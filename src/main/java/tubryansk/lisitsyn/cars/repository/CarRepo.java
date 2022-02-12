package tubryansk.lisitsyn.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tubryansk.lisitsyn.cars.entity.Car;

import java.util.List;

public interface CarRepo extends JpaRepository<Car,Long> {
    List<Car> findByModel(String model);
}
