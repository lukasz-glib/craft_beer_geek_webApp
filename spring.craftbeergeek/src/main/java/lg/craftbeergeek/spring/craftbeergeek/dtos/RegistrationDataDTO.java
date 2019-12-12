package lg.craftbeergeek.spring.craftbeergeek.dtos;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class RegistrationDataDTO {

    @NotBlank @Size(min = 3, max = 12)
    private String username;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(min = 4, max = 12)
    private String password;
    @NotBlank @Size(min = 4, max = 12)
    private String repassword;
    @NotNull @AssertTrue
    private Boolean termsAcceptance;
    private LocalDate addedDateUser = LocalDate.now();


}
