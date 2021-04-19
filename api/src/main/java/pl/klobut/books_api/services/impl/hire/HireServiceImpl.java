package pl.klobut.books_api.services.impl.hire;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.klobut.books_api.domain.HireEntity;
import pl.klobut.books_api.models.HireDTO;
import pl.klobut.books_api.models.SearchHireDTO;
import pl.klobut.books_api.repository.HireRepository;
import pl.klobut.books_api.services.hire.HireService;

import java.util.List;

@Service
public class HireServiceImpl implements HireService {

    private HireRepository hireRepository;
    private ModelMapper modelMapper;

    public HireServiceImpl(HireRepository hireRepository) {
        this.hireRepository = hireRepository;
    }

    @Override
    public HireRepository saveHire(HireDTO hireDto) {
        HireEntity hireEntity = modelMapper.map(hireDto, HireEntity.class);
        return hireRepository.save();
    }

    @Override
    public HireRepository giveBackBock(HireDTO hireDto) {
        return null;
    }

    @Override
    public List<HireRepository> searchBooksByFilter(SearchHireDTO searchHireDTO) {
        return null;
    }
}
