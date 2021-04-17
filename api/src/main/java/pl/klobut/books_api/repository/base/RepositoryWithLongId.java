package pl.klobut.books_api.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pl.klobut.books_api.domain.BaseEntityWithId;

@NoRepositoryBean
public interface RepositoryWithLongId<TEntity extends BaseEntityWithId> extends JpaRepository<TEntity, Long> {
}
