package pl.klobut.books_api.repository;

import org.springframework.stereotype.Repository;
import pl.klobut.books_api.domain.HireEntity;
import pl.klobut.books_api.repository.base.RepositoryWithLongId;

@Repository
public interface HireRepository extends RepositoryWithLongId<HireEntity> {
//    List<HireEntity> findByByUser_IdAndBook_Id(long id_user, long id_book);
}
