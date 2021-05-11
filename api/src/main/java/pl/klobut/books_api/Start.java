package pl.klobut.books_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.klobut.books_api.domain.*;
import pl.klobut.books_api.repository.*;

import java.util.Arrays;
import java.util.Collections;

@Component
public class Start implements ApplicationRunner {
    private UserRepository userRepository;
    private UserGroupRepository userGroupRepository;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private AddressRepository addressRepository;

    @Autowired
    public Start(UserRepository userRepository, UserGroupRepository userGroupRepository, AuthorRepository authorRepository, BookRepository bookRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.userGroupRepository = userGroupRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.addressRepository = addressRepository;
    }

    public void run(ApplicationArguments args) {
        addRoles();
        addUsers();
        addBooksAndAuthor();
    }

    private void addBooksAndAuthor() {
        AuthorEntity authorRowling = AuthorEntity.builder()
                .firstName("Joanne")
                .lastName("Rowling")
                .build();
        AuthorEntity authorMeyer
                = AuthorEntity.builder()
                .firstName("Stephenie")
                .lastName("Meyer")
                .build();
        AuthorEntity authorBrontë
                = AuthorEntity.builder()
                .firstName("Emily")
                .lastName("Brontë")
                .build();
        AuthorEntity authorSienkiewicz
                = AuthorEntity.builder()
                .firstName("Henryk")
                .lastName("Sienkiewicz")
                .build();

        authorRepository.saveAll(Arrays.asList(authorRowling, authorMeyer, authorBrontë, authorSienkiewicz));

        BookEntity harryPotterCz2Book = BookEntity.builder()
                .title("Harry Potter cz 2")
                .ISBN("456fds5")
                .authors(Collections.singleton(authorRowling))
                .build();
        BookEntity harryPotterCz3Book = BookEntity.builder()
                .title("Harry Potter cz 3")
                .ISBN("5656sdads")
                .authors(Collections.singleton(authorRowling))
                .build();
        BookEntity zmierzchBook = BookEntity.builder()
                .title("Zmierzch")
                .ISBN("348239405656")
                .authors(Collections.singleton(authorMeyer))
                .build();
        BookEntity wichrowehBook = BookEntity.builder()
                .title("Wichrowe wzgórza")
                .ISBN("fj834278g")
                .authors(Collections.singleton(authorBrontë))
                .build();
        BookEntity wPustyniIWPuszczyBook = BookEntity.builder()
                .title("W pustyni i w puszczy")
                .ISBN("656ebr8")
                .authors(Collections.singleton(authorSienkiewicz))
                .build();

        bookRepository.saveAll(Arrays.asList(harryPotterCz2Book, harryPotterCz3Book, zmierzchBook, wichrowehBook, wPustyniIWPuszczyBook));
    }

    private void addUsers() {
        UserGroupEntity adminGroup = userGroupRepository.findById(1L).orElse(null);
        UserGroupEntity userRegGroup = userGroupRepository.findById(2L).orElse(null);
        UserGroupEntity userVisitGroup = userGroupRepository.findById(3L).orElse(null);

        //adress
        AddressEntity adressUser1 = AddressEntity.builder().place("Kalisz").street("Poznańska").numberHome("56").numberFlat("2g").postalCode("52-500").build();
        AddressEntity adressUser2 = AddressEntity.builder().place("Wrocław").street("Strzegomska").numberHome("12").numberFlat("22").postalCode("66-500").build();
        AddressEntity adresssUser3 = AddressEntity.builder().place("Jarocin").street("Kwiatowa").numberHome("22").numberFlat("5f").postalCode("52-300").build();

        addressRepository.saveAll(Arrays.asList(adressUser1, adressUser2, adresssUser3));
        UserEntity userAdm = UserEntity.builder()
                .firstName("Jan")
                .lastName("Admin")
                .email("janAdmin@wp.pl")
                .login("admin")
                .password("admin")
                .phone("456123456")
                .address(adressUser1)
                .userGroups(Collections.singleton(adminGroup))
                .build();

        UserEntity userRegistered = UserEntity.builder()
                .firstName("Iza")
                .lastName("Las")
                .email("izaLas@wp.pl")
                .login("izaLas")
                .password("iza123")
                .phone("456123456")
                .address(adressUser2)
                .userGroups(Collections.singleton(userRegGroup))
                .build();

        UserEntity userVisit = UserEntity.builder()
                .firstName("Michał")
                .lastName("Kos")
                .email("michalKos@wp.pl")
                .login("michalKos")
                .password("michal123")
                .phone("456123456")
                .address(adresssUser3)
                .userGroups(Collections.singleton(userVisitGroup))
                .build();

        userRepository.saveAll(Arrays.asList(userAdm, userRegistered, userVisit));
    }

    public void addRoles() {
        UserGroupEntity admin = UserGroupEntity.builder().name("admin").build();
        userGroupRepository.save(admin);
        UserGroupEntity userRegistered = UserGroupEntity.builder().name("user registered").build();
        userGroupRepository.save(userRegistered);
        UserGroupEntity visitUser = UserGroupEntity.builder().name("user visit").build();
        userGroupRepository.save(visitUser);
    }
}
