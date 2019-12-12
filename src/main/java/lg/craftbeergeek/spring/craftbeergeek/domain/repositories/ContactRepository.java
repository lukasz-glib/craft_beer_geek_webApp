package lg.craftbeergeek.spring.craftbeergeek.domain.repositories;

import lg.craftbeergeek.spring.craftbeergeek.domain.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
