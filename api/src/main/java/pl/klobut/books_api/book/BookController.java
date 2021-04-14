package pl.klobut.books_api.book;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.klobut.books_api.Mapper;
import pl.klobut.books_api.models.BookDTO;
import pl.klobut.books_api.models.BookSearchQueryDTO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
class BookController {
    private BookService bookService;
    private Mapper mapper;

    @PostMapping()
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<BookDTO> addNewBook(@RequestBody @Valid BookDTO bookDTO) {
        BookEntity bookEntity = mapper.convertToEntity(bookDTO);

        try {
            return new ResponseEntity<>(mapper.convertToDTO(bookService.addBook(bookEntity)), HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            System.out.println(e);
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
            System.out.println(e);
        }
        return null;
    }
}
