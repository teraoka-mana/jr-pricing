package jr.service.routeService;

import jr.domain.route.Route;
import jr.domain.station.Station;
import jr.domain.station.StationId;
import jr.domain.station.StationName;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    public void check(Route route) {
        if (!(route.getDeparture().getStation().equalStation(new Station(new StationId(1L), new StationName("東京"))))) {
            throw new RuntimeException("すみません。東京-姫路と東京-新大阪区間しか対応してません。");
        }
        if (!(route.getDestination().getStation().equalStation(new Station(new StationId(2L), new StationName("新大阪"))) ||
                route.getDestination().getStation().equalStation(new Station(new StationId(3L), new StationName("姫路"))))) {
            throw new RuntimeException("すみません。東京-姫路と東京-新大阪区間しか対応してません。");
        }
    }
}
