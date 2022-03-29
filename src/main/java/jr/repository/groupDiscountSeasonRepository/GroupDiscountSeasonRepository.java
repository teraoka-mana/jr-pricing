package jr.repository.groupDiscountSeasonRepository;

import java.util.Date;
import java.util.List;

public interface GroupDiscountSeasonRepository {
    List<Date> findPeakSeason();
}
