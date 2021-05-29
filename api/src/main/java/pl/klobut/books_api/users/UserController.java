package pl.klobut.books_api.users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.klobut.books_api.MapperUser;
import pl.klobut.books_api.exceptions.WebAuthApiException;
import pl.klobut.books_api.models.UserDTO;
import pl.klobut.books_api.services.impl.users.UsersServiceImpl;
import pl.klobut.books_api.services.users.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private MapperUser mapperUser;

    public UserController(UsersServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers(){
       return userService.getUserList().stream().map(m->mapperUser.convertToDTO(m)).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<UserDTO> addNewUser(@RequestBody UserDTO userDTO ) throws WebAuthApiException {
        return mapperUser.convertToDTO(userService.createUser(userDTO, null));
    }
}
