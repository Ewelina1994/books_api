package pl.klobut.books_api.models;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class BookDTO {
    private Long id;
    @NotNull
    @NotBlank
    private String title;
    @Column(unique = true)
    private String isbn;

    public BookDTO(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public BookDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String ISBN) {
        this.isbn = ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDTO bookDTO = (BookDTO) o;
        return Objects.equals(id, bookDTO.id) &&
                Objects.equals(title, bookDTO.title) &&
                Objects.equals(isbn, bookDTO.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isbn);
    }
}
