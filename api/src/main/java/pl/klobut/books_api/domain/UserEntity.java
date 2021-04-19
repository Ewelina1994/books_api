package pl.klobut.books_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@RequiredArgsConstructor
@Getter
public class UserEntity extends BaseEntityWithId{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private AddressEntity address;
    @ManyToMany
    @JoinTable(name = "users_group_relation", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "user_group_id", referencedColumnName = "id") })
    @Column(name = "user_groups")
    private Set<UserGroupEntity> userGroups;
}
