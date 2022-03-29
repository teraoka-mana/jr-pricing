package jr.repository.season;

import java.util.Date;
import java.util.List;


public interface SeasonRepository {
    List<Date> findPeakSeason();
    List<Date> findOffSeason();
}
