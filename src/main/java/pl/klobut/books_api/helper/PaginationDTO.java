package pl.klobut.books_api.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaginationDTO<T> {
    private List<T> content;
    private Long totalElements;

    public PaginationDTO() {
    }

    public PaginationDTO(List<T> content, Long totalElements) {
        this.content = content;
        this.totalElements = totalElements;
    }
}
