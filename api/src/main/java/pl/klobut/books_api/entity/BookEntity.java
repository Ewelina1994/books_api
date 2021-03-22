package pl.klobut.books_api.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@EqualsAndHashCode
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Please enter title")
    @Size(max = 100, min = 3, message = "{bookEntity.title.invalid}")
    private String title;
    @Column(unique = true)
    private String ISBN;

    public BookEntity(@NotBlank(message = "Please enter title") @Size(max = 100, min = 3, message = "{bookEntity.title.invalid}") String title, String ISBN) {
        this.title = title;
        this.ISBN = ISBN;
    }

    public BookEntity() {
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
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
