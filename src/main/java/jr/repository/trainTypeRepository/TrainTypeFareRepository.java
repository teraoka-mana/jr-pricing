package jr.repository.trainTypeRepository;

import jr.domain.expressFare.ExpressFare;
import jr.domain.route.Route;

public interface TrainTypeFareRepository {
    ExpressFare findNozomiFare(Route route);
}
