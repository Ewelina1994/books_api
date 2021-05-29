package pl.klobut.books_api.models;

import lombok.*;
import pl.klobut.books_api.domain.Category;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    private Long id;
    @NotNull
    @NotBlank
    private String title;
    @Column(unique = true)
    private String isbn;
    private List<AuthorDTO> authors;
    @Enumerated(value = EnumType.STRING)
    private Category category;


}
