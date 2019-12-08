package lg.craftbeergeek.spring.craftbeergeek.domain.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Size(max = 60)
    private String nameBeer;
    @Column(nullable = false)
    private String malt;
    @Column(nullable = false)
    private String hop;
    @Column(nullable = false)
    private String mashing;
    @Column(nullable = false)
    private String boiling;
    @Column(nullable = false)
    private String fermentation;
    private String bottling;

}
