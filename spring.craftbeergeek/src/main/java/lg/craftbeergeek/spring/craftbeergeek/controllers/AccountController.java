package lg.craftbeergeek.spring.craftbeergeek.controllers;


import lg.craftbeergeek.spring.craftbeergeek.domain.entities.User;
import lg.craftbeergeek.spring.craftbeergeek.domain.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class AccountController {

    private final UserRepository userRepository;

    public AccountController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String prepareAccountPage(Principal principal, Model model) {
        String username = principal.getName();
        User loggedUser = userRepository.findByUsername(username);
        model.addAttribute("userAccount", loggedUser);
        return "user/account";
    }

}
