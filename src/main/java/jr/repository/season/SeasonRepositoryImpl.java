package jr.repository.season;

import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class SeasonRepositoryImpl implements SeasonRepository {

    @Override
    public List<Date> findPeakSeason() {
        Date startDate = new Date();
        Date endDate = new Date();

        try {
            String startDateStr = "12-25";
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

    @Override
    public List<Date> findOffSeason() {
        Date startDate = new Date();
        Date endDate = new Date();

        try {
            String startDateStr = "2018-1-16";
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            startDate = dateFormat1.parse(startDateStr);


            String endDateStr = "2018-1-30";
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            endDate = dateFormat2.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Date> off = new ArrayList<>();
        off.add(startDate);
        off.add(endDate);

        return off;
    }
}
