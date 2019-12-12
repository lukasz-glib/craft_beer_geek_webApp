package lg.craftbeergeek.spring.craftbeergeek.controllers;

import lg.craftbeergeek.spring.craftbeergeek.domain.entities.User;
import lg.craftbeergeek.spring.craftbeergeek.domain.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminAccountController {

    private final UserRepository userRepository;

    public AdminAccountController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String prepareAccountPage(Principal principal, Model model) {
        String adminname = principal.getName();
        User loggedAdmin = userRepository.findByUsername(adminname);
        model.addAttribute("adminAccount", loggedAdmin);
        return "admin/account-admin";
    }



}
