package pl.klobut.books_api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.klobut.books_api.domain.BookEntity;
import pl.klobut.books_api.models.BookDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {
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

    public List<BookDTO> convertToDTOList(List<BookEntity> bookEntityList){
        List<BookDTO> bookDTOList= new ArrayList<>();
        for(BookEntity b: bookEntityList){
            bookDTOList.add(convertToDTO(b));
        }
        return bookDTOList;
    }

    public List<BookEntity> convertToEntityList(List<BookDTO> bookDTO){
        List<BookEntity> bookEntityList= new ArrayList<>();
        for(BookDTO b: bookDTO){
            bookEntityList.add(convertToEntity(b));
        }
        return bookEntityList;
    }
}
