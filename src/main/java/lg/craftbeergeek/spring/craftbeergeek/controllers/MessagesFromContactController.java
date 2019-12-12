package lg.craftbeergeek.spring.craftbeergeek.controllers;

import lg.craftbeergeek.spring.craftbeergeek.services.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/all-contact")
public class MessagesFromContactController {

    private final ContactService contactService;

    public MessagesFromContactController(ContactService contactService) {
        this.contactService = contactService;
    }


    @GetMapping
    public String getContactMessagesPage(Model model) {
        model.addAttribute("allContactMessages", contactService.findAllContactMessages());
        return "contact/all-contact-messages";
    }
}
