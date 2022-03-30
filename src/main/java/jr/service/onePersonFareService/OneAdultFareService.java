package jr.service.onePersonFareService;

import jr.domain.expressFare.ExpressFare;
import jr.domain.expressFareDetail.ExpressDetail;
import jr.domain.onePersonFare.TotalFare;
import jr.domain.onePersonFare.OneAdultFare;
import jr.domain.tariff.Tariff;
import jr.domain.tariff.TariffId;
import jr.service.distanceService.DistanceService;
import jr.service.expressFareService.ExpressFareService;
import jr.service.tariffService.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OneAdultFareService {

    @Autowired
    private TariffService tariffService;

    @Autowired
    private ExpressFareService expressFareService;

    @Autowired
    private DistanceService distanceService;


    public OneAdultFare calculateOneAdultFare(ExpressDetail expressDetail) {
        switch (expressDetail.getRoundTrip()) {
            case No:
                Tariff tariff = tariffService.getTariff(expressDetail.getRoute());
                ExpressFare expressFare = expressFareService.calculation(expressDetail);
                TotalFare totalFare = new TotalFare(tariff.getValue() + expressFare.getValue());

                return new OneAdultFare(tariff, expressFare, totalFare);

            case Yes:
                Tariff oneWayTariff = new Tariff(new TariffId(), tariffService.getTariff(expressDetail.getRoute()).getValue());
                Tariff oneWayDiscountTariff = new Tariff(new TariffId(), tariffService.RoundDownRoundTrip(tariffService.getTariff(expressDetail.getRoute())));

                ExpressFare oneWayExpressFare = new ExpressFare(expressFareService.calculation(expressDetail).getValue());

                TotalFare roundTripAdultFare = new TotalFare(oneWayTariff.getValue() * 2 + oneWayExpressFare.getValue() * 2);
                TotalFare roundTripDiscountAdultFare = new TotalFare(oneWayDiscountTariff.getValue() * 2 + oneWayExpressFare.getValue() * 2);

                if (distanceService.getDistance(expressDetail.getRoute()).getValue() >= 601) {
                    return new OneAdultFare(oneWayDiscountTariff,oneWayExpressFare,roundTripDiscountAdultFare);
                }

                return new OneAdultFare(oneWayTariff,oneWayExpressFare,roundTripAdultFare);
        }

        throw new RuntimeException("往復はYesまたはNoで定義されています。");
    }
}
