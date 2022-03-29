package jr.service.onePersonService;

import jr.domain.onePersonFare.OneChildPersonFare;
import jr.domain.ticketDetail.ExpressDetail;
import jr.service.distanceService.DistanceService;
import jr.service.expressFareService.ExpressFareService;
import jr.service.tariffService.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OneChildPersonService {
    @Autowired
    private TariffService tariffService;
    @Autowired
    private ExpressFareService expressFareService;
    @Autowired
    private DistanceService distanceService;

    public OneChildPersonFare calculateOneChildPersonOneWayFare(ExpressDetail expressDetail) {
        int express = expressFareService.getChildExpressReserveFare(expressDetail).getValue();
        int tariff = tariffService.getChildTariff(expressDetail.getRoute()).getValue();

        return new OneChildPersonFare(tariff + express);
    }

    public OneChildPersonFare calculateChildRoundTripFare(ExpressDetail expressDetail) {
        int roundTripTariff = tariffService.getChildTariff(expressDetail.getRoute()).getValue() * 2;
        int roundTripDiscountTariff = tariffService.RoundDownRoundTrip(tariffService.getChildTariff(expressDetail.getRoute()));
        int roundTripExpress = expressFareService.getChildExpressReserveFare(expressDetail).getValue() * 2;

        if(distanceService.getDistance(expressDetail.getRoute()).getValue() >= 601){
            return new OneChildPersonFare(roundTripDiscountTariff + roundTripExpress);
        }
        return new OneChildPersonFare(roundTripTariff + roundTripExpress);
    }
}
