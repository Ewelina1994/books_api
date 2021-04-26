package pl.klobut.books_api.services.hire;

import pl.klobut.books_api.domain.HireEntity;
import pl.klobut.books_api.models.HireDTO;
import pl.klobut.books_api.models.SearchHireDTO;

import java.util.List;

public interface HireService {
    public HireEntity saveHire(HireDTO hireDto);

    public boolean giveBackBock(HireDTO hireDto) throws Exception;

    public List<HireEntity> searchBooksByFilter(SearchHireDTO searchHireDTO);

}
