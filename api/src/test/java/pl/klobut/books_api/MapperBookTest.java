package pl.klobut.books_api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.klobut.books_api.domain.BookEntity;
import pl.klobut.books_api.models.BookDTO;

import static org.junit.jupiter.api.Assertions.*;

class MapperBookTest {
    private MapperBook mapperBook;

    @BeforeEach
    public void before() {
        mapperBook = new MapperBook();
    }

    @Test
    public void whenConvertBookEntityToBookDTO_thenCorrect() {
        BookEntity bookEntity = BookEntity.builder()
                .title("Harry Potter")
                .ISBN("jdk34928").build();

        BookDTO bookDTO = mapperBook.convertToDTO(bookEntity);
        assertEquals(bookDTO.getTitle(), bookEntity.getTitle());
    }

    @Test
    public void whenConvertBookDTOToBookEntity_thenCorrect() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Wife's king");

        BookEntity bookEntity = mapperBook.convertToEntity(bookDTO);
        assertEquals(bookDTO.getTitle(), bookEntity.getTitle());
    }

}
