package jr.service.onePersonService;

import jr.domain.onePersonFare.OneAdultPersonFare;
import jr.domain.ticketDetail.ExpressDetail;
import jr.service.distanceService.DistanceService;
import jr.service.expressFareService.ExpressFareService;
import jr.service.tariffService.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OneAdultPersonService {

    @Autowired
    private TariffService tariffService;

    @Autowired
    private ExpressFareService expressFareService;

    @Autowired
    private DistanceService distanceService;


    public OneAdultPersonFare calculateOneAdultOneWayFare(ExpressDetail expressDetail) {
        return new OneAdultPersonFare(tariffService.getTariff(expressDetail.getRoute()).getValue() + expressFareService.calculation(expressDetail).getValue());

    }

    public OneAdultPersonFare calculateAdultRoundTripFare(ExpressDetail expressDetail) {
        int roundTripTariff = tariffService.getTariff(expressDetail.getRoute()).getValue() * 2;
        int roundTripDiscountTariff = tariffService.RoundDownRoundTrip(tariffService.getTariff(expressDetail.getRoute()));
        int roundTripExpressFare = expressFareService.calculation(expressDetail).getValue() * 2;

        if(distanceService.getDistance(expressDetail.getRoute()).getValue() >= 601){
            return new OneAdultPersonFare(roundTripExpressFare + roundTripDiscountTariff);
        }

        return new OneAdultPersonFare(roundTripExpressFare + roundTripTariff);
    }
}
