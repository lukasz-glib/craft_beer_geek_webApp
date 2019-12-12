package lg.craftbeergeek.spring.craftbeergeek.services;

import lg.craftbeergeek.spring.craftbeergeek.dtos.ContactDataDTO;

import java.util.List;

public interface ContactService {

    void addContactMessage(ContactDataDTO contactDataDTO);

    List<ContactDataDTO> findAllContactMessages();

}
