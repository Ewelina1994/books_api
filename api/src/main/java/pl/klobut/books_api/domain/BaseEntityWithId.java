package pl.klobut.books_api.domain;

import lombok.Getter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
public abstract class BaseEntityWithId implements EntityWithId {


}
