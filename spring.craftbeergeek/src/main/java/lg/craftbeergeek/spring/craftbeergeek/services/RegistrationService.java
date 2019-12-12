package lg.craftbeergeek.spring.craftbeergeek.services;

import lg.craftbeergeek.spring.craftbeergeek.dtos.RegistrationDataDTO;

public interface RegistrationService {

    void register(RegistrationDataDTO registrationData);

    void deleteUser(RegistrationDataDTO registrationDataDTO, Long id);

}
