package lg.craftbeergeek.spring.craftbeergeek.dtos;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RecipeDataDTO {

    @Size(max = 60)
    private String nameBeer;
    @NotBlank
    private String malt;
    @NotBlank
    private String hop;
    @NotBlank
    private String mashing;
    @NotBlank
    private String boiling;
    @NotBlank
    private String fermentation;
    @NotBlank
    private String bottling;

}
