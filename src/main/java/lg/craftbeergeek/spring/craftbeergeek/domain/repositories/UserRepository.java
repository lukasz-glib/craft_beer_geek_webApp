package lg.craftbeergeek.spring.craftbeergeek.domain.repositories;

import lg.craftbeergeek.spring.craftbeergeek.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

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


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users (active, email, password, username) " +
            "VALUES (true,'admin@gmail.com', '{noop}admin', 'admin')", nativeQuery = true)
    void createAdmin();

    @Transactional
    @Modifying
    @Query(value = "insert into users_roles(user_id, roles_id) VALUES " +
            "(SELECT id FROM users WHERE username = 'admin',2);", nativeQuery = true)
    void makeAdminAdmin();

    @Transactional
    @Modifying
    @Query(value = "insert into users(email, password, username, active) values\n" +
            "('user@wp.pl', '{noop}user', 'user', true);", nativeQuery = true)
    void createUser();

    @Transactional
    @Modifying
    @Query(value = "insert into users_roles(user_id, roles_id) VALUES\n" +
            "(SELECT id FROM users WHERE username = 'user',1);", nativeQuery = true)
    void makeUserUser();
}
