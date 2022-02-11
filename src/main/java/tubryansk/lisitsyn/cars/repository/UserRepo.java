package tubryansk.lisitsyn.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tubryansk.lisitsyn.cars.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String Username);
}
