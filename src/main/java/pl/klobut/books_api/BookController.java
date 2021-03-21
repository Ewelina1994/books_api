package pl.klobut.books_api;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private Mapper mapper;

    @PostMapping()
    public BookDTO addNewBook(@RequestBody @Valid BookDTO bookDTO) {
        BookEntity bookEntity = mapper.convertToEntity(bookDTO);

        try{
            return mapper.convertToDTO(bookService.addBook(bookEntity));
        }catch (DataIntegrityViolationException e){
            System.out.println(e);
        }
        return null;
    }

    @GetMapping()
    public List<BookDTO> getAllBooks() {
        return mapper.convertToDTOList(bookService.getAllBooks());
    }

    @PostMapping("/search")
    @ResponseBody
    public List<BookDTO> findBooks(@RequestBody BookSearchQueryDTO bookSearchQueryDTO) {
        List<BookDTO> bookSearch = mapper.convertToDTOList(bookService.findHospitalBySearchQuery(bookSearchQueryDTO));

        return bookSearch;
    }

    @PutMapping("/{id}")
    public BookDTO updateBook(@Valid @RequestBody BookDTO bookDTO, @PathVariable long id) throws NotFoundException {

        BookEntity bookEntity = bookService.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found for this id :: " + id));

        bookEntity.setTitle(bookDTO.getTitle());
        bookEntity.setISBN(bookDTO.getISBN());
        try{
            return mapper.convertToDTO(bookService.addBook(bookEntity));
        }catch (DataIntegrityViolationException e){
            System.out.println(e);
        }
        return null;
    }
}
