package jr.repository.tariffRepository;

import jr.domain.route.Route;
import jr.domain.station.Station;
import jr.domain.station.StationId;
import jr.domain.station.StationName;
import jr.domain.tariff.Tariff;
import jr.domain.tariff.TariffId;
import org.springframework.stereotype.Repository;

@Repository
public class TariffRepositoryImpl implements TariffRepository {

    @Override
    public Tariff findTariff(Route route) {
        if (route.getDeparture().getStation().equalStation(new Station(new StationId(1L), new StationName("東京")))) {
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
