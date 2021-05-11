package pl.klobut.books_api.services.impl.book;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.klobut.books_api.domain.BookEntity;
import pl.klobut.books_api.models.BookSearchQueryDTO;
import pl.klobut.books_api.repository.BookRepository;
import pl.klobut.books_api.services.book.BookService;

import java.util.List;
import java.util.Optional;

@Service
public
class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookEntity addBook(BookEntity book) {
        return bookRepository.save(book);
    }

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAllByOrderByTitleAsc();
    }

    @Transactional(readOnly=true)
    public List<BookEntity> findHospitalBySearchQuery(BookSearchQueryDTO bookSearchQueryDTO) {
        List<BookEntity> bookEntitiesBySearch;
        if ((!bookSearchQueryDTO.getTitle().isEmpty() && bookSearchQueryDTO.getTitle() != null) && (bookSearchQueryDTO.getIsbn() == null || bookSearchQueryDTO.getIsbn().isEmpty())) {
            bookEntitiesBySearch = bookRepository.findBookEntitiesBySearchString(bookSearchQueryDTO.getTitle());
        } else if ((!bookSearchQueryDTO.getIsbn().isEmpty() && bookSearchQueryDTO.getIsbn() != null) && (bookSearchQueryDTO.getTitle() == null || bookSearchQueryDTO.getTitle().isEmpty())) {
            bookEntitiesBySearch = bookRepository.findBookEntitiesBySearchString(bookSearchQueryDTO.getIsbn());
        } else {
            String searchString = bookSearchQueryDTO.getTitle() + bookSearchQueryDTO.getIsbn();
            bookEntitiesBySearch = bookRepository.findBookEntitiesBySearchString(searchString);
        }
        return bookEntitiesBySearch;
    }

    public Optional<BookEntity> findById(long id) {
        return bookRepository.findById(id);
    }

}
