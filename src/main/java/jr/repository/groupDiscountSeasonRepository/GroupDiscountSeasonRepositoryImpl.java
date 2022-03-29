package jr.repository.groupDiscountSeasonRepository;

import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class GroupDiscountSeasonRepositoryImpl implements GroupDiscountSeasonRepository{
    @Override
    public List<Date> findPeakSeason() {
        Date startDate = new Date();
        Date endDate = new Date();

        try {
            String startDateStr = "12-21";
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM-dd");
            startDate = dateFormat1.parse(startDateStr);


            String endDateStr = "1-10";
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM-dd");
            endDate = dateFormat2.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Date> peak = new ArrayList<>();
        peak.add(startDate);
        peak.add(endDate);

        return peak;
    }
}
