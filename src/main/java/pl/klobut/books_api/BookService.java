package pl.klobut.books_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public BookEntity addBook(BookEntity book) {
        return bookRepository.save(book);
    }

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAllByOrderByTitleAsc();
    }

    public List<BookEntity> findHospitalBySearchQuery(BookSearchQueryDTO bookSearchQueryDTO) {
        List<BookEntity> bookEntitiesBySearch = null;
        if ((!bookSearchQueryDTO.getTitle().isEmpty() && bookSearchQueryDTO.getTitle() != null) && (bookSearchQueryDTO.getIsbn() == null || bookSearchQueryDTO.getIsbn().isEmpty())) {
            bookEntitiesBySearch = bookRepository.findBookEntitiesBySearchTitle(bookSearchQueryDTO.getTitle());
        } else if ((!bookSearchQueryDTO.getIsbn().isEmpty() && bookSearchQueryDTO.getIsbn() != null) && (bookSearchQueryDTO.getTitle() == null || bookSearchQueryDTO.getTitle().isEmpty())) {
            bookEntitiesBySearch = bookRepository.findBookEntitiesBySearchIsbn(bookSearchQueryDTO.getIsbn());
        } else {
            bookEntitiesBySearch = bookRepository.findBookEntitiesBySearchTitleAndIsbn(bookSearchQueryDTO.getTitle(), bookSearchQueryDTO.getIsbn());
        }
        return bookEntitiesBySearch;
    }

    public Optional<BookEntity> findById(long id) {
        return bookRepository.findById(id);
    }
}
