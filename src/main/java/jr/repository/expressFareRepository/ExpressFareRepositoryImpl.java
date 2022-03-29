package jr.repository.expressFareRepository;

import jr.domain.expressFare.ExpressFare;
import jr.domain.route.Route;
import org.springframework.stereotype.Repository;

@Repository
public class ExpressFareRepositoryImpl implements ExpressFareRepository {
    @Override
    public ExpressFare findExpressReserveFare(Route route) {
        if(route.getDestination().getStation().getStationName().getName().equals("姫路")){
            return new ExpressFare(5920);
        }
        if(route.getDestination().getStation().getStationName().getName().equals("新大阪")){
            return new ExpressFare(5490);
        }
        throw new RuntimeException("すみません。東京-姫路と東京-新大阪区間しか対応してません。");
    }
}
