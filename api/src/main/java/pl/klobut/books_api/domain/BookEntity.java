package pl.klobut.books_api.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Getter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Builder
@Setter
@Table(name = "books")
public class BookEntity extends BaseEntityWithId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Please enter title")
    @NotNull
    @Size(max = 100, min = 3, message = "{bookEntity.title.invalid}")
    private String title;
    @Column(unique = true)
    private String ISBN;
    @ManyToMany
    @JoinTable(name = "books_authors_relation", joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "author_id", referencedColumnName = "id")})
    @Column(name = "authors")
    private Set<AuthorEntity> authors;


}
