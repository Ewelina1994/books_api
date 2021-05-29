package pl.klobut.books_api;


import org.modelmapper.ModelMapper;
import pl.klobut.books_api.domain.UserEntity;
import pl.klobut.books_api.models.UserDTO;

public class MapperUser {
    private ModelMapper modelMapper;

    public MapperUser(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public UserDTO convertToDTO(UserEntity userEntity){
        UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
        return userDTO;
    }
    public UserEntity convertToEntity(UserDTO userDTO){
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        return userEntity;
    }
}
