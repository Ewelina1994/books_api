package pl.klobut.books_api.book;

import javassist.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.klobut.books_api.Mapper;
import pl.klobut.books_api.domain.BookEntity;
import pl.klobut.books_api.models.BookDTO;
import pl.klobut.books_api.models.BookSearchQueryDTO;
import pl.klobut.books_api.services.impl.book.BookServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
class BookController {
    private BookServiceImpl bookService;
    private Mapper mapper;

    public BookController(BookServiceImpl bookService, Mapper mapper) {
        this.bookService = bookService;
        this.mapper = mapper;
    }

    @PostMapping()
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<BookDTO> addNewBook(@RequestBody @Valid BookDTO bookDTO) {
        BookEntity bookEntity = mapper.convertToEntity(bookDTO);

        try {
           return new ResponseEntity<>(mapper.convertToDTO(bookService.addBook(bookEntity)), HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping()
    @CrossOrigin(origins = "http://localhost:4200")
    public List<BookDTO> getAllBooks() {
        return mapper.convertToDTOList(bookService.getAllBooks());
    }

    @PostMapping("/search")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public List<BookDTO> findBooks(@RequestBody BookSearchQueryDTO bookSearchQueryDTO) {
        List<BookDTO> bookSearch = mapper.convertToDTOList(bookService.findHospitalBySearchQuery(bookSearchQueryDTO));

        return bookSearch;
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public BookDTO updateBook(@Valid @RequestBody BookDTO bookDTO, @PathVariable long id) throws NotFoundException {

        BookEntity bookEntity = bookService.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found for this id :: " + id));

        bookEntity.setTitle(bookDTO.getTitle());
        bookEntity.setISBN(bookDTO.getIsbn());
        try {
            return mapper.convertToDTO(bookService.addBook(bookEntity));
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
