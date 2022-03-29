package jr.repository.tariffRepository;

import jr.domain.route.Route;
import jr.domain.tariff.Tariff;
import jr.domain.tariff.TariffId;
import org.springframework.stereotype.Repository;

@Repository
public class TariffRepositoryImpl implements TariffRepository {

    @Override
    public Tariff findTariff(Route route) {
        if (route.getDeparture().getStation().getStationName().getName().equals("東京")) {
            switch (route.getDestination().getStation().getStationName().getName()) {
                case "姫路":
                    return new Tariff(new TariffId(),10010);

                case "新大阪":
                    return new Tariff(new TariffId(),8910);
            }
        }
        throw new RuntimeException("すみません。東京-姫路と東京-新大阪区間しか対応してません。");
    }
}
