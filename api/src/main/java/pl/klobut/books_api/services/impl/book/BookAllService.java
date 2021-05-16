package pl.klobut.books_api.services.impl.book;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.klobut.books_api.Mapper;
import pl.klobut.books_api.domain.BookEntity;
import pl.klobut.books_api.models.BookDTO;
import pl.klobut.books_api.models.BookSearchQueryDTO;
import pl.klobut.books_api.repository.BookRepository;
import pl.klobut.books_api.services.book.BookService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookAllService implements BookService {
    private final Mapper mapper;

    private final BookRepository bookRepository;

    public BookAllService(Mapper mapper, BookRepository bookRepository) {
        this.mapper = mapper;
        this.bookRepository = bookRepository;
    }
    @Override
    public BookEntity addBook(BookEntity book) {
        return bookRepository.save(book);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<BookDTO> collect = bookRepository.findAllByOrderByTitleAsc().stream().map(this.mapper::convertToDTO)
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    @Transactional
    public List<BookDTO> findBookBySearch(BookSearchQueryDTO bookSearchQueryDTO) {
        List<BookEntity> bookEntitiesBySearch;
        if ((!bookSearchQueryDTO.getTitle().isEmpty() && bookSearchQueryDTO.getTitle() != null) && (bookSearchQueryDTO.getIsbn() == null || bookSearchQueryDTO.getIsbn().isEmpty())) {
            bookEntitiesBySearch = bookRepository.findBookEntitiesBySearchString(bookSearchQueryDTO.getTitle());
        } else if ((!bookSearchQueryDTO.getIsbn().isEmpty() && bookSearchQueryDTO.getIsbn() != null) && (bookSearchQueryDTO.getTitle() == null || bookSearchQueryDTO.getTitle().isEmpty())) {
            bookEntitiesBySearch = bookRepository.findBookEntitiesBySearchString(bookSearchQueryDTO.getIsbn());
        } else {
            String searchString = bookSearchQueryDTO.getTitle() + bookSearchQueryDTO.getIsbn();
            bookEntitiesBySearch = bookRepository.findBookEntitiesBySearchString(searchString);
        }
        return bookEntitiesBySearch.stream().map(mapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<BookEntity> findById(long id) {
        return bookRepository.findById(id);
    }
}
