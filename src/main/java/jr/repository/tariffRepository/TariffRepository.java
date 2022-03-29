package jr.repository.tariffRepository;

import jr.domain.route.Route;
import jr.domain.tariff.Tariff;


public interface TariffRepository {
    Tariff findTariff(Route route);
}
