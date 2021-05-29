package pl.klobut.books_api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.klobut.books_api.domain.BookEntity;
import pl.klobut.books_api.models.BookDTO;

@Component
public class MapperBook {
    @Autowired
    private ModelMapper modelMapper;

    public BookDTO convertToDTO(BookEntity bookEntity){
        BookDTO bookDTO = modelMapper.map(bookEntity, BookDTO.class);
        return bookDTO;
    }

    public BookEntity convertToEntity(BookDTO bookDTOk){
        BookEntity bookEntity = modelMapper.map(bookDTOk, BookEntity.class);
        return bookEntity;
    }
}
