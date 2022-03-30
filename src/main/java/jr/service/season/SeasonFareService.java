package jr.service.season;

import jr.domain.expressFare.ExpressFare;
import jr.domain.expressFareDetail.BoardingDate;
import jr.repository.season.SeasonFareRepository;
import jr.repository.season.SeasonFareRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeasonFareService {

    private SeasonFareRepository seasonFareRepository = new SeasonFareRepositoryImpl();

    @Autowired
    private SeasonService seasonService;


    public ExpressFare getSeasonFare(BoardingDate boardingDate){
        return seasonFareRepository.findSeasonFare(seasonService.getSeason(boardingDate));
    }

}
