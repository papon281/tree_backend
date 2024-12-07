package app.binary.tree.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
public class Numbers {
    @Valid
    @NotEmpty
    private String numbers;
}