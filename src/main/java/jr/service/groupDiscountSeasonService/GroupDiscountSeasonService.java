package jr.service.groupDiscountSeasonService;

import jr.domain.season.GroupDiscountSeason;
import jr.domain.expressFareDetail.BoardingDate;
import jr.repository.groupDiscountSeasonRepository.GroupDiscountSeasonRepository;
import jr.repository.groupDiscountSeasonRepository.GroupDiscountSeasonRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GroupDiscountSeasonService {
    private GroupDiscountSeasonRepository groupDiscountSeasonRepository = new GroupDiscountSeasonRepositoryImpl();

    public GroupDiscountSeason getSeason(BoardingDate boardingDate) {

        List<Date> peak = groupDiscountSeasonRepository.findPeakSeason();

        if (boardingDate.getDate().getMonth() == peak.get(0).getMonth() && boardingDate.getDate().getDay() >= peak.get(0).getDay()) {
            return GroupDiscountSeason.peakSeason;
        }
        if (boardingDate.getDate().getMonth() == peak.get(1).getMonth() && boardingDate.getDate().getDay() <= peak.get(1).getDate()) {
            return GroupDiscountSeason.peakSeason;
        }
        return GroupDiscountSeason.regularSeason;
    }
}
