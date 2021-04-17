package pl.klobut.books_api.models;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import pl.klobut.books_api.domain.AddressEntity;
import pl.klobut.books_api.domain.UserGroupEntity;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private AddressDTO address;
    private List<UsersGroupDTO> userGroups = Lists.newArrayList();
}
