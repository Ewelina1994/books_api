package pl.klobut.books_api.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.klobut.books_api.domain.BaseEntityWithId;

public interface RepositoryWithLongId<TEntity extends BaseEntityWithId> extends JpaRepository<TEntity, Long> {
}
