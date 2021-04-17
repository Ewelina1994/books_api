package pl.klobut.books_api.services.impl.users;

import org.springframework.stereotype.Service;
import pl.klobut.books_api.domain.UserEntity;
import pl.klobut.books_api.exceptions.WebApiExceptionType;
import pl.klobut.books_api.exceptions.WebAuthApiException;
import pl.klobut.books_api.mappers.UserMapper;
import pl.klobut.books_api.models.UserDTO;
import pl.klobut.books_api.repository.UserRepository;
import pl.klobut.books_api.services.users.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserEntity getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity createUser(UserDTO userDTO, UserEntity loggedUser) throws WebAuthApiException {
        if(getUserByEmail(userDTO.getEmail())!=null){
            throw new WebAuthApiException(WebApiExceptionType.EMAIL_ALREADY_TAKEN);
        }else{
           // userRepository.save()
        }
        return null;
    }
}
