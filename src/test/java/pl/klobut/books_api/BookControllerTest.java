package pl.klobut.books_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    BookService bookService;

    @Test
    public void shouldReturnAllBooksSortedDecs() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/books"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
        BookDTO[] bookDTOS = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BookDTO[].class);

        Assertions.assertEquals("355 dni", bookDTOS[0].getTitle());
        Assertions.assertEquals(6, bookDTOS.length);
    }

    @Test
    public void testUpdateBook() throws Exception {
        BookEntity updateBook = new BookEntity();
        updateBook.setTitle("change");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/books/1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(updateBook))
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();

        BookDTO bookDTO = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BookDTO.class);
        Long idBook = (Long) bookDTO.getId();

        Optional<BookEntity> findMessage = bookService.findById(idBook);

        assertThat(findMessage.get().getTitle()).isEqualTo(updateBook.getTitle());
    }

    @Test
    public void shouldThrowExceptionWhenISBNisNotUnique() {

    }
}
