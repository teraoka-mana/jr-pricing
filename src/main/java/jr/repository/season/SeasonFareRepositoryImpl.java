package jr.repository.season;

import jr.domain.expressFare.ExpressFare;
import jr.domain.season.Season;
import org.springframework.stereotype.Repository;

@Repository
public class SeasonFareRepositoryImpl implements SeasonFareRepository {

    @Override
    public ExpressFare findSeasonFare(Season season) {
        switch (season) {
            case peakSeason:
                return new ExpressFare(200);
            case offSeason:
                return new ExpressFare(-200);
            default:
                return new ExpressFare(0);
        }


    }
}
