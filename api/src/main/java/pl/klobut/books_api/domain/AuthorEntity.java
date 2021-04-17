package pl.klobut.books_api.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "authors")
@RequiredArgsConstructor
@Getter
@Setter
public class AuthorEntity extends BaseEntityWithId{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(max = 50)
    private String firstName;
    @NotNull
    @Size(max = 50)
    private String lastName;
    //    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
//            mappedBy = "authors")
//    @JoinTable(name = "book_author",
//            joinColumns = { @JoinColumn(name = "author_id") },
//            inverseJoinColumns = { @JoinColumn(name = "book_id") })
//    @JoinTable(name = "book_author_relation", joinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")}, inverseJoinColumns = {
//            @JoinColumn(name = "book_id", referencedColumnName = "id")})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "book_id")
    private BookEntity books;

}
