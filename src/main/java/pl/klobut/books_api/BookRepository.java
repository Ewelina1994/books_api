package pl.klobut.books_api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    @Query(value = "SELECT * FROM book_entity  WHERE title LIKE '%:title%'", nativeQuery = true)
    List<BookEntity> findBookEntitiesBySearchTitle(@Param("title") String title);
//    @Query(value = "SELECT * FROM book_entity  WHERE title LIKE '%?1%'", nativeQuery = true)
    List<BookEntity> findAllByOrderByTitleAsc();

    @Query(value = "SELECT * FROM book_entity  WHERE isbn LIKE '%:isbn%'", nativeQuery = true)
    List<BookEntity> findBookEntitiesBySearchIsbn(@Param("isbn") String isbn);

    @Query(value = "SELECT * FROM book_entity  WHERE title LIKE '%:title%' AND isbn LIKE '%:isbn%'", nativeQuery = true)
    List<BookEntity> findBookEntitiesBySearchTitleAndIsbn(@Param("title") String title, @Param("isbn") String isbn);
}
