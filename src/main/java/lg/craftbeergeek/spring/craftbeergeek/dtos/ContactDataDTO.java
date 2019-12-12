package lg.craftbeergeek.spring.craftbeergeek.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ContactDataDTO {

    private Long id;
    @NotBlank(message = "Podaj imię i nazwisko")
    private String fullName;
    @Email(message = "Uzupełnij email")
    @NotBlank
    private String email;
    @Size(max = 30)
    @NotBlank(message = "Podaj temat wiadomości")
    private String topic;
    @Size(max = 200)
    @NotBlank(message = "Podaj wiadomość")
    private String description;

}
