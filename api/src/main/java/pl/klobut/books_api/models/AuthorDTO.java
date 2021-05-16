package pl.klobut.books_api.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AuthorDTO {
    private Long id;
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
}
