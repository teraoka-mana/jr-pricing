package jr.repository.expressFareRepository;

import jr.domain.expressFare.ExpressFare;
import jr.domain.route.Route;


public interface ExpressFareRepository {
    ExpressFare findExpressReserveFare(Route route);
}
