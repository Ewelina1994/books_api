package pl.klobut.books_api.users;

import lombok.RequiredArgsConstructor;
import pl.klobut.books_api.author.AuthorEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_group")
@RequiredArgsConstructor
public class UserGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "user_groups")
    private Set<AuthorEntity> users= new HashSet<>();
}
