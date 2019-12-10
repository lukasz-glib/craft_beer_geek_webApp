package lg.craftbeergeek.spring.craftbeergeek.domain.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = "password")
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private Boolean active = Boolean.FALSE;
    @Column(nullable = false)
    private String password;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

    @OneToMany
    private List<Recipe> recipes = new ArrayList<>();



}
