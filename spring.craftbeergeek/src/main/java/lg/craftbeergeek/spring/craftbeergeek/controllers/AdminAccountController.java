package lg.craftbeergeek.spring.craftbeergeek.controllers;

import lg.craftbeergeek.spring.craftbeergeek.domain.entities.User;
import lg.craftbeergeek.spring.craftbeergeek.domain.repositories.UserRepository;
import lg.craftbeergeek.spring.craftbeergeek.dtos.RegistrationDataDTO;
import lg.craftbeergeek.spring.craftbeergeek.services.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminAccountController {

    private final UserRepository userRepository;
    private final RegistrationService registrationService;

    public AdminAccountController(UserRepository userRepository, RegistrationService registrationService) {
        this.userRepository = userRepository;
        this.registrationService = registrationService;
    }

    @GetMapping
    public String prepareAccountPage(Principal principal, Model model) {
        String adminname = principal.getName();
        User loggedAdmin = userRepository.findByUsername(adminname);
        model.addAttribute("adminAccount", loggedAdmin);
        return "admin/account-admin";
    }

    @GetMapping("/manage-users")
    public String getRecipesPage(Model model) {
        model.addAttribute("allUsers", userRepository.findAll());
        return "admin/users-management";
    }

    @GetMapping("/delete")
    public String processDeleteUser(RegistrationDataDTO registrationDataDTO, Long id) {
        registrationService.deleteUser(registrationDataDTO, id);
        return "redirect:/admin/manage-users";
    }


}
