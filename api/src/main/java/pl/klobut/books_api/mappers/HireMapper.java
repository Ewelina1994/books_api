package pl.klobut.books_api.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.klobut.books_api.domain.HireEntity;
import pl.klobut.books_api.models.HireDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class HireMapper implements EntityMapper<HireDTO, HireEntity> {
    private ModelMapper modelMapper;
    @Override
    public HireEntity toEntity(HireDTO hireDTO) {
        HireEntity hireEntity = modelMapper.map(hireDTO, HireEntity.class);
        return hireEntity;
    }

    @Override
    public HireDTO toDto(HireEntity hireEntity) {
        HireDTO hireDTO = modelMapper.map(hireEntity, HireDTO.class);
        return hireDTO;
    }

    @Override
    public List<HireEntity> toEntityList(List<HireDTO> hireDTOS) {
        List<HireEntity> hireEntities= new ArrayList<>();
        return modelMapper.map(hireDTOS, hireEntities.getClass());
    }

    @Override
    public List<HireDTO> toDtoList(List<HireEntity> hireEntities) {
        List<HireDTO> hireDTOS= new ArrayList<>();
        return modelMapper.map(hireEntities, hireDTOS.getClass());
    }
}
