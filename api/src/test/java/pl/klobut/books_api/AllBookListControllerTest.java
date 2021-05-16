package pl.klobut.books_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.klobut.books_api.domain.BookEntity;
import pl.klobut.books_api.models.BookDTO;
import pl.klobut.books_api.models.BookSearchQueryDTO;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class AllBookListControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    BookServiceImpl bookService;

    @Test
    public void shouldReturnAllBooksSortedDecs() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/books"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
        BookDTO[] bookDTOS = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BookDTO[].class);

        Assertions.assertEquals("355 dni", bookDTOS[0].getTitle());
        Assertions.assertEquals("Harry Potter cz 2", bookDTOS[1].getTitle());
        Assertions.assertEquals(6, bookDTOS.length);
    }

    @Test
    public void testUpdateBook() throws Exception {
        BookEntity updateBook = BookEntity.builder()
                .title("change")
                .ISBN("jis8989").build();

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/books/1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(updateBook))
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();

        BookDTO bookDTO = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BookDTO.class);
        Long idBook = bookDTO.getId();

        Optional<BookEntity> findMessage = bookService.findById(idBook);

        assertThat(findMessage.orElse(null).getTitle()).isEqualTo(updateBook.getTitle());
    }

    @Test
    public void shouldSearchBooksByTitle() throws Exception {
        BookSearchQueryDTO bookSearchQueryDTO = new BookSearchQueryDTO();
        bookSearchQueryDTO.setTitle("Harry");
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.post("/books/search")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(bookSearchQueryDTO))
                ).andExpect(MockMvcResultMatchers.status().isOk())
                        .andDo(MockMvcResultHandlers.print()).andReturn();

        BookDTO[] bookDTOS = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BookDTO[].class);

        Assertions.assertEquals(2, bookDTOS.length);

        Assertions.assertEquals("Harry Potter cz 2", bookDTOS[0].getTitle());
        Assertions.assertEquals("Harry Potter cz 3", bookDTOS[1].getTitle());
    }

    @Test
    public void shouldSearchBooksByTitleAndISBN() throws Exception {
        BookSearchQueryDTO bookSearchQueryDTO = new BookSearchQueryDTO();
        bookSearchQueryDTO.setTitle("Harry");
        bookSearchQueryDTO.setTitle("354");
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.post("/books/search")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(bookSearchQueryDTO))
                ).andExpect(MockMvcResultMatchers.status().isOk())
                        .andDo(MockMvcResultHandlers.print()).andReturn();

        BookDTO[] bookDTOS = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BookDTO[].class);

        Assertions.assertEquals(1, bookDTOS.length);

        Assertions.assertEquals("Harry Potter cz 3", bookDTOS[0].getTitle());
        Assertions.assertEquals("54354try", bookDTOS[0].getIsbn());

    }
}
