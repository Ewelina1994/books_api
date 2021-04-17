package pl.klobut.books_api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.klobut.books_api.domain.BookEntity;
import pl.klobut.books_api.repository.base.RepositoryWithLongId;

import java.util.List;

@Repository
public interface BookRepository extends RepositoryWithLongId<BookEntity> {
//    @Query(value = "SELECT * FROM BOOK_ENTITY WHERE title LIKE %:title%", nativeQuery = true)
//    List<BookEntity> findBookEntitiesBySearchTitle(@Param("title") String title);

    List<BookEntity> findAllByOrderByTitleAsc();

    @Query(value = "FROM books WHERE CONCAT(trim(title), trim(isbn)) LIKE %:searchString%", nativeQuery = true)
    List<BookEntity> findBookEntitiesBySearchString(@Param("searchString") String searchString);

//    @Query(value = "SELECT * FROM BOOK_ENTITY WHERE isbn LIKE %:isbn%", nativeQuery = true)
//    List<BookEntity> findBookEntitiesBySearchIsbn(@Param("isbn") String isbn);
//
//    @Query(value = "SELECT * FROM book_entity WHERE title LIKE %:title% AND isbn LIKE %:isbn%", nativeQuery = true)
//    List<BookEntity> findBookEntitiesBySearchTitleAndIsbn(@Param("title") String title, @Param("isbn") String isbn);

}
