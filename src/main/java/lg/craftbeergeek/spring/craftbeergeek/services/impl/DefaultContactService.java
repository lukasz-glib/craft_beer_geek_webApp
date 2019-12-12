package lg.craftbeergeek.spring.craftbeergeek.services.impl;

import lg.craftbeergeek.spring.craftbeergeek.domain.entities.Contact;
import lg.craftbeergeek.spring.craftbeergeek.domain.entities.Recipe;
import lg.craftbeergeek.spring.craftbeergeek.domain.repositories.ContactRepository;
import lg.craftbeergeek.spring.craftbeergeek.dtos.ContactDataDTO;
import lg.craftbeergeek.spring.craftbeergeek.services.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class DefaultContactService implements ContactService {

    private final ContactRepository contactRepository;

    public DefaultContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public void addContactMessage(ContactDataDTO contactData) {
        ModelMapper modelMapper = new ModelMapper();
        Contact contact = modelMapper.map(contactData, Contact.class);
        log.debug("Zapis przepisu: {}", contact);
        contactRepository.save(contact);
        log.debug("Zapisano przepis do bazy: {}", contact);
    }

    @Override
    public List<ContactDataDTO> findAllContactMessages() {
        ModelMapper model = new ModelMapper();
        return contactRepository.findAll().stream()
                .map(m-> model.map(m, ContactDataDTO.class))
                .collect(Collectors.toList());
    }
}
