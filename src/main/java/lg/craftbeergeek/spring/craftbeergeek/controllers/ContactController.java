package lg.craftbeergeek.spring.craftbeergeek.controllers;

import lg.craftbeergeek.spring.craftbeergeek.dtos.ContactDataDTO;
import lg.craftbeergeek.spring.craftbeergeek.services.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public String contactView(Model model){
        model.addAttribute("contact", new ContactDataDTO());
        return "contact/contact";
    }

    @PostMapping
    public String processCreationContactForm(@ModelAttribute("contact")
                                                 @Valid ContactDataDTO contactDataDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "contact/contact";
        }
        contactService.addContactMessage(contactDataDTO);
        return "redirect:/contact";
    }


}
