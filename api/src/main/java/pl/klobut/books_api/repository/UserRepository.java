package pl.klobut.books_api.repository;

import pl.klobut.books_api.domain.UserEntity;
import pl.klobut.books_api.repository.base.RepositoryWithLongId;

public interface UserRepository extends RepositoryWithLongId<UserEntity> {
    UserEntity findByLogin(String login);

    UserEntity findByEmail(String email);
}
