package pl.klobut.books_api.mappers;

import pl.klobut.books_api.domain.UserEntity;
import pl.klobut.books_api.models.UserDTO;

import java.util.List;

public class UserMapper implements EntityMapper<UserDTO, UserEntity> {
    @Override
    public UserEntity toEntity(UserDTO userDTO) {
        UserEntity.builder().login(userDTO.getLogin())
                            .password(userDTO.getPassword())
                            .firstName(userDTO.getFirstName())
                            .lastName(userDTO.getLastName())
                            .phone(userDTO.getPhone())
                            .email(userDTO.getEmail())
                            .address(userDTO.getAddress())
                            .userGroups(userDTO.getUserGroups())
                .build();
        return null;
    }

    @Override
    public UserDTO toDto(UserEntity userEntity) {
        return null;
    }

    @Override
    public List<UserEntity> toEntityList(List<UserDTO> userDTOS) {
        return null;
    }

    @Override
    public List<UserDTO> toDtoList(List<UserEntity> userEntities) {
        return null;
    }
}
