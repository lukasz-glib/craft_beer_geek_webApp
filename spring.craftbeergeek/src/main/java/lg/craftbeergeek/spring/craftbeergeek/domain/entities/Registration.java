package lg.craftbeergeek.spring.craftbeergeek.domain.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Uzupełnij imię")
    private String firstName;
    @NotBlank(message = "Uzupełnij nazwisko")
    private String lastName;
    @Email(message = "Uzupełnij email")
    private String email;
    @NotBlank(message = "Podaj hasło")
    private String password;

}
