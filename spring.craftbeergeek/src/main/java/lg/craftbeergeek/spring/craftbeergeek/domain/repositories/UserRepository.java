package lg.craftbeergeek.spring.craftbeergeek.domain.repositories;

import lg.craftbeergeek.spring.craftbeergeek.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
