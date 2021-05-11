package pl.klobut.books_api.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Table(name = "user_group")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserGroupEntity extends BaseEntityWithId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
