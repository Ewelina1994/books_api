package pl.klobut.books_api.services.users;

import pl.klobut.books_api.domain.UserEntity;
import pl.klobut.books_api.exceptions.WebAuthApiException;
import pl.klobut.books_api.models.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> getUserList();

    Optional<UserEntity> getUserById(Long id);

    UserEntity getUserByLogin(String login);

    UserEntity getUserByEmail(String email);

    UserEntity createUser(UserDTO userDTO, UserEntity loggedUser) throws WebAuthApiException;
}
