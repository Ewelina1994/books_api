package pl.klobut.books_api.models;

import lombok.Data;

@Data
public class SearchHireDTO {
    private BookDTO bookDTO;
    private UserDTO userDTO;
}
