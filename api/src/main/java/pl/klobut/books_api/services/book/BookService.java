package pl.klobut.books_api.services.book;

import pl.klobut.books_api.domain.BookEntity;
import pl.klobut.books_api.models.BookSearchQueryDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public BookEntity addBook(BookEntity book);

    public List<BookEntity> getAllBooks();

    public List<BookEntity> findHospitalBySearchQuery(BookSearchQueryDTO bookSearchQueryDTO);

    public Optional<BookEntity> findById(long id);
}
