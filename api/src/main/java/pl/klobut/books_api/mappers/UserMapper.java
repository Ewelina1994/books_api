package pl.klobut.books_api.mappers;

import org.springframework.stereotype.Component;
import pl.klobut.books_api.domain.UserEntity;
import pl.klobut.books_api.models.UserDTO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper implements EntityMapper<UserDTO, UserEntity> {

    private ModelMapper modelMapper;

    @Override
    public UserEntity toEntity(UserDTO userDTO) {
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);

        return userEntity;
    }

    @Override
    public UserDTO toDto(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }

    @Override
    public List<UserEntity> toEntityList(List<UserDTO> userDTOS) {
        List<UserEntity> userEntities= new ArrayList<>();
        return modelMapper.map(userDTOS, userEntities.getClass());
    }

    @Override
    public List<UserDTO> toDtoList(List<UserEntity> userEntities) {
        List<UserDTO> userDTOS= new ArrayList<>();
        return modelMapper.map(userEntities, userDTOS.getClass());
    }
}
