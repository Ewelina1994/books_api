package pl.klobut.books_api.models;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;
    @NotNull
    @NotBlank
    private String title;
    @Column(unique = true)
    private String isbn;


}
