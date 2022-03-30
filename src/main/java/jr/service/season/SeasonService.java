package jr.service.season;

import jr.domain.expressFareDetail.BoardingDate;
import jr.domain.season.Season;
import jr.repository.season.SeasonRepository;
import jr.repository.season.SeasonRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SeasonService {

    private SeasonRepository seasonRepository = new SeasonRepositoryImpl();


    public Season getSeason(BoardingDate boardingDate) {

        List<Date> peak = seasonRepository.findPeakSeason();
        List<Date> off = seasonRepository.findOffSeason();

        if (boardingDate.getDate().getMonth() == peak.get(0).getMonth() && boardingDate.getDate().getDay() >= peak.get(0).getDay()) {
            return Season.peakSeason;
        }
        if (boardingDate.getDate().getMonth() == peak.get(1).getMonth() && boardingDate.getDate().getDay() <= peak.get(1).getDate()) {
            return Season.peakSeason;
        }

        if (boardingDate.getDate().getMonth() == off.get(0).getMonth() && boardingDate.getDate().getDay() >= off.get(0).getDay()) {
            return Season.offSeason;
        }
        if (boardingDate.getDate().getMonth() == off.get(1).getMonth() && boardingDate.getDate().getDay() <= off.get(1).getDate()) {
            return Season.offSeason;
        }
        return Season.regularSeason;
    }

}
