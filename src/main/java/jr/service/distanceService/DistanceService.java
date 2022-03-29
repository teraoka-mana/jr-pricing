package jr.service.distanceService;

import jr.domain.distance.Distance;
import jr.domain.route.Route;
import jr.repository.distanceRepository.DistanceRepository;
import jr.repository.distanceRepository.DistanceRepositoryImpl;
import jr.service.routeService.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    private DistanceRepository distanceRepository = new DistanceRepositoryImpl();

    @Autowired
    private RouteService routeService;

    public Distance getDistance(Route route) {
        routeService.check(route);
        return distanceRepository.findDistance(route);
    }



}
