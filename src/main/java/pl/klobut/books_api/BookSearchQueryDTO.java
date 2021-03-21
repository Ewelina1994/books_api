package pl.klobut.books_api;

public class BookSearchQueryDTO {
    //  private PaginationQueryDTO paginationData;
    private String title;
    private String isbn;

    public BookSearchQueryDTO(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public BookSearchQueryDTO() {
    }

    public String getWhereClause() {
        String result = "" +
                "1=1";
        if (this.title != null && !this.title.isEmpty()) {
//            result += " AND ((LOWER(book_entity.title) LIKE CONCAT('%', LOWER(:title), '%')))";
           // result += " AND ((LOWER(book_entity.title) LIKE CONCAT('%', LOWER("+this.title+"), '%')))";
            result+=" AND WHERE title LIKE '%"+this.title+"%'";

        }
        if (this.isbn != null && !this.isbn.isEmpty()) {
           // result += " AND ((LOWER(CONCAT(book_entity.ISBN)) LIKE CONCAT('%', LOWER("+this.isbn+"), '%')))";
            result+=" AND WHERE isbn LIKE '%"+this.isbn+"%'";
        }
        return result;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
