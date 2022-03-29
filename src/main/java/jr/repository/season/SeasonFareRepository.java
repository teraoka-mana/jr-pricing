package jr.repository.season;

import jr.domain.expressFare.ExpressFare;
import jr.domain.season.Season;
import org.springframework.stereotype.Repository;


public interface SeasonFareRepository {
    ExpressFare findSeasonFare(Season season);
}
