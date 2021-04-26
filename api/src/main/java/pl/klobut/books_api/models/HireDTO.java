package pl.klobut.books_api.models;

import lombok.Data;

@Data
public class HireDTO {
    private long id;
    private BookDTO bookDTO;
    private UserDTO userDTO;
}
