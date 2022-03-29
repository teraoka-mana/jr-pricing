package jr.repository.distanceRepository;

import jr.domain.distance.Distance;
import jr.domain.route.Route;


public interface DistanceRepository {
    Distance findDistance(Route route);
}
