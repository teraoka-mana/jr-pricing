package jr.service.onePersonFareService;

import jr.domain.expressFare.ExpressFare;
import jr.domain.onePersonFare.OneChildFare;
import jr.domain.onePersonFare.TotalFare;
import jr.domain.tariff.Tariff;
import jr.domain.tariff.TariffId;
import jr.domain.expressFareDetail.ExpressDetail;
import jr.service.distanceService.DistanceService;
import jr.service.expressFareService.ExpressFareService;
import jr.service.tariffService.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OneChildFareService {
    @Autowired
    private TariffService tariffService;
    @Autowired
    private ExpressFareService expressFareService;
    @Autowired
    private DistanceService distanceService;

    public OneChildFare calculateOneChildFare(ExpressDetail expressDetail) {
        switch (expressDetail.getRoundTrip()) {
            case No:
                Tariff tariff = new Tariff(new TariffId(), tariffService.getChildTariff(expressDetail.getRoute()).getValue());
                ExpressFare expressFare = new ExpressFare(expressFareService.getChildExpressReserveFare(expressDetail).getValue());
                TotalFare oneChildFare = new TotalFare(tariff.getValue() + expressFare.getValue());

                return new OneChildFare(tariff, expressFare, oneChildFare);

            case Yes:
                Tariff oneWayTariff = new Tariff(new TariffId(), tariffService.getChildTariff(expressDetail.getRoute()).getValue());
                Tariff oneWayDiscountTariff = new Tariff(new TariffId(), tariffService.RoundDownRoundTrip(tariffService.getChildTariff(expressDetail.getRoute())));

                ExpressFare oneWayExpressFare = new ExpressFare(expressFareService.getChildExpressReserveFare(expressDetail).getValue());

                TotalFare roundTripChildFare = new TotalFare(oneWayTariff.getValue() * 2 + oneWayExpressFare.getValue() * 2);
                TotalFare roundTripDiscountChildFare = new TotalFare(oneWayDiscountTariff.getValue() * 2 + oneWayExpressFare.getValue() * 2);


                if (distanceService.getDistance(expressDetail.getRoute()).getValue() >= 601) {
                    return new OneChildFare(oneWayDiscountTariff,oneWayExpressFare,roundTripDiscountChildFare);
                }
                return new OneChildFare(oneWayTariff,oneWayExpressFare,roundTripChildFare);
        }
        throw new RuntimeException("往復はYesまたはNoで定義されています。");
    }
}
