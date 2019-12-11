package lg.craftbeergeek.spring.craftbeergeek.services;

import lg.craftbeergeek.spring.craftbeergeek.dtos.ContactDataDTO;

public interface ContactService {

    void addContactMessage(ContactDataDTO contactDataDTO);

}
