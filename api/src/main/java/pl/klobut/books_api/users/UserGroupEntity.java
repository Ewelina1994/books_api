package pl.klobut.books_api.users;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_group")
@RequiredArgsConstructor
public class UserGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
