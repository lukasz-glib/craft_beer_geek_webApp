package lg.craftbeergeek.spring.craftbeergeek.domain.repositories;

import lg.craftbeergeek.spring.craftbeergeek.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "UPDATE User u SET u.active = true WHERE u.id = ?1")
    void statusActiveUser(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE User u SET u.active = false WHERE u.id = ?1")
    void statusBlockedUser(Long id);


}
