package lg.craftbeergeek.spring.craftbeergeek.services.impl;


import lg.craftbeergeek.spring.craftbeergeek.domain.entities.Role;
import lg.craftbeergeek.spring.craftbeergeek.domain.entities.User;
import lg.craftbeergeek.spring.craftbeergeek.domain.repositories.RoleRepository;
import lg.craftbeergeek.spring.craftbeergeek.domain.repositories.UserRepository;
import lg.craftbeergeek.spring.craftbeergeek.dtos.RegistrationDataDTO;
import lg.craftbeergeek.spring.craftbeergeek.services.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class DefaultRegistrationService implements RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DefaultRegistrationService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void register(RegistrationDataDTO registrationData) {
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(registrationData, User.class); //przypisujemy wartości
        user.setActive(Boolean.TRUE);
        String encodedPassword = passwordEncoder.encode(registrationData.getPassword()); //szyfrowanie hasła
        user.setPassword(encodedPassword);
        Role roleUser = roleRepository.getByName("ROLE_USER");
        user.getRoles().add(roleUser);
        userRepository.save(user);


    }

    @Override
    public void deleteUser(RegistrationDataDTO registrationDataDTO, Long id) {
        User user = userRepository.findById(id).get();
        log.debug("Usunięcie użytkownika: {}", user);
        if (user != null) {
            userRepository.delete(user);
        }
        log.debug("Usunięto użytkownika: {}", user);
    }



}
