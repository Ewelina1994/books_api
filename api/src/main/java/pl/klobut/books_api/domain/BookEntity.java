package pl.klobut.books_api.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
@Table(name = "books")
public class BookEntity extends BaseEntityWithId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Please enter title")
    @Size(max = 100, min = 3, message = "{bookEntity.title.invalid}")
    private String title;
    @Column(unique = true)
    private String ISBN;
    @ManyToMany
    @JoinTable(name = "books_authors_relation", joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "author_id", referencedColumnName = "id")})
    @Column(name = "authors")
    private Set<AuthorEntity> authors = new HashSet<>();


}
