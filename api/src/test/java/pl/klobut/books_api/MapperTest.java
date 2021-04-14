package pl.klobut.books_api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.klobut.books_api.book.BookEntity;
import pl.klobut.books_api.models.BookDTO;

import static org.junit.jupiter.api.Assertions.*;

class MapperTest {
    Mapper mapper;

    @BeforeEach
    public void before() {
        mapper = new Mapper();
    }

    @Test
    public void whenConvertBookEntityToBookDTO_thenCorrect() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle("Harry Potter");

        BookDTO bookDTO = mapper.convertToDTO(bookEntity);
        assertEquals(bookDTO.getTitle(), bookEntity.getTitle());
    }

    @Test
    public void whenConvertBookDTOToBookEntity_thenCorrect() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Wife's king");

        BookEntity bookEntity = mapper.convertToEntity(bookDTO);
        assertEquals(bookDTO.getTitle(), bookEntity.getTitle());
    }

}
