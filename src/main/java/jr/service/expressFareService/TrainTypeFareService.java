package jr.service.expressFareService;

import jr.domain.expressFareDetail.TrainType;
import jr.domain.expressFare.ExpressFare;
import jr.domain.route.Route;
import jr.repository.trainTypeRepository.TrainTypeFareRepository;
import jr.repository.trainTypeRepository.TrainTypeFareRepositoryImpl;
import jr.service.routeService.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainTypeFareService {
    @Autowired
    private RouteService routeService;

    private TrainTypeFareRepository trainTypeFareRepository = new TrainTypeFareRepositoryImpl();



    public ExpressFare getTrainTypeFare(TrainType trainType, Route route) {
        routeService.check(route);
        if(trainType.isNozomi()) {
            return trainTypeFareRepository.findNozomiFare(route);

        }
        return new ExpressFare(0);
    }
}
