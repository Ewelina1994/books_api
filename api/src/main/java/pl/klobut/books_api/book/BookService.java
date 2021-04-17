package pl.klobut.books_api.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.klobut.books_api.domain.BookEntity;
import pl.klobut.books_api.models.BookSearchQueryDTO;
import pl.klobut.books_api.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public
class BookService {
    private BookRepository bookRepository;

    public BookEntity addBook(BookEntity book) {
        return bookRepository.save(book);
    }

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAllByOrderByTitleAsc();
    }

    @Transactional(readOnly=true)
    public List<BookEntity> findHospitalBySearchQuery(BookSearchQueryDTO bookSearchQueryDTO) {
        List<BookEntity> bookEntitiesBySearch = null;
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
