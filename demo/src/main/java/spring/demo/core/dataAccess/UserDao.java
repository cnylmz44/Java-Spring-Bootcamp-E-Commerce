package spring.demo.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.demo.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
