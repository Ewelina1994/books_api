package pl.klobut.books_api.services.book;

import pl.klobut.books_api.domain.BookEntity;
import pl.klobut.books_api.models.BookDTO;
import pl.klobut.books_api.models.BookSearchQueryDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    BookEntity addBook(BookEntity book);

    List<BookDTO> getAllBooks();

    List<BookDTO> findBookBySearch(BookSearchQueryDTO bookSearchQueryDTO);

    Optional<BookEntity> findById(long id);
}
