package jr.repository.distanceRepository;

import jr.domain.distance.Distance;
import jr.domain.route.Route;
import org.springframework.stereotype.Repository;

@Repository
public class DistanceRepositoryImpl implements DistanceRepository {

    @Override
    public Distance findDistance(Route route) {
        if (route.getDeparture().getStation().getStationName().getName().equals("東京")) {
            switch (route.getDestination().getStation().getStationName().getName()) {
                case "姫路":
                    return new Distance(644);

                case "新大阪":
                    return new Distance(553);
            }
        }
        throw new RuntimeException("東京-姫路,東京-新大阪区間しか対応していません。");

    }
}
