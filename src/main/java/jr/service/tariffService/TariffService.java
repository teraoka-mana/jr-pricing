package jr.service.tariffService;

import jr.domain.route.Route;
import jr.domain.tariff.Tariff;
import jr.domain.tariff.TariffId;
import jr.repository.tariffRepository.TariffRepository;
import jr.repository.tariffRepository.TariffRepositoryImpl;
import jr.service.routeService.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TariffService {

    private TariffRepository tariffRepository = new TariffRepositoryImpl();

    @Autowired
    private RouteService routeService;

    public Tariff getTariff(Route route) {
        routeService.check(route);
        return tariffRepository.findTariff(route);
    }

    public int RoundDownRoundTrip(Tariff tariff) {
        return (int) Math.floor(tariff.getValue() * 0.9 / 10) * 10 * 2;
    }

    public Tariff getChildTariff(Route route) {
        return new Tariff(new TariffId(),(int) Math.floor(getTariff(route).getValue() / 2 / 10) * 10);
    }


}
