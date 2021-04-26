package pl.klobut.books_api.services.impl.hire;

import org.joda.time.LocalDateTime;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.klobut.books_api.domain.HireEntity;
import pl.klobut.books_api.models.HireDTO;
import pl.klobut.books_api.models.SearchHireDTO;
import pl.klobut.books_api.repository.HireRepository;
import pl.klobut.books_api.services.hire.HireService;

import java.util.List;
import java.util.Optional;

@Service
public class HireServiceImpl implements HireService {

    private HireRepository hireRepository;
    private ModelMapper modelMapper;

    public HireServiceImpl(ModelMapper modelMapper, HireRepository hireRepository) {
        this.hireRepository = hireRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public HireEntity saveHire(HireDTO hireDto) {
        HireEntity hireEntity = modelMapper.map(hireDto, HireEntity.class);
        setDateHire(hireEntity);

        return hireRepository.save(hireEntity);
    }

    private void setDateHire(HireEntity hireEntity) {
        hireEntity.setDate_hire_start(new LocalDateTime());
        hireEntity.setDate_when_given_back(new LocalDateTime().plusMonths(2));
        hireEntity.setDate_deadline_to_return(new LocalDateTime().plusMonths(10));
        hireEntity.setHow_many_extended_the_deadline(0);
    }

    @Override
    public boolean giveBackBock(HireDTO hireDto) throws Exception {
        Optional<HireEntity> byId = Optional.ofNullable(hireRepository.findById(hireDto.getId()).orElseThrow(() -> new Exception("jhj")));
        if(byId==null){
            return false;
        }
        HireEntity hireEntity = byId.get();
        hireEntity.setDate_when_given_back(new LocalDateTime());
        hireEntity.setReturn(true);
        return true;
    }

    @Override
    public List<HireEntity> searchBooksByFilter(SearchHireDTO searchHireDTO) {
        return null;
    }

}
