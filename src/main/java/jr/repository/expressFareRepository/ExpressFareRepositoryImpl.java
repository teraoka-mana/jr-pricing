package jr.repository.expressFareRepository;

import jr.domain.expressFare.ExpressFare;
import jr.domain.route.Route;
import jr.domain.station.Station;
import jr.domain.station.StationId;
import jr.domain.station.StationName;
import org.springframework.stereotype.Repository;

@Repository
public class ExpressFareRepositoryImpl implements ExpressFareRepository {
    @Override
    public ExpressFare findExpressReserveFare(Route route) {
        if(route.getDestination().getStation().equalStation(new Station(new StationId(3L), new StationName("姫路")))){
            return new ExpressFare(5920);
        }
        if(route.getDestination().getStation().equalStation(new Station(new StationId(2L), new StationName("新大阪")))){
            return new ExpressFare(5490);
        }
        throw new RuntimeException("すみません。東京-姫路と東京-新大阪区間しか対応してません。");
    }
}
