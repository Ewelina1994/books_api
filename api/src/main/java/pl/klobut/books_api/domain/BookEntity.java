package pl.klobut.books_api.domain;

import lombok.*;
import pl.klobut.books_api.domain.AuthorEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
@Table(name = "books")
public class BookEntity extends BaseEntityWithId{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Please enter title")
    @Size(max = 100, min = 3, message = "{bookEntity.title.invalid}")
    private String title;
    @Column(unique = true)
    private String ISBN;
//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
//            mappedBy = "books")
//    private Set<AuthorEntity> authors= new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "books")
    private List<AuthorEntity> authors= new ArrayList<>();


}
