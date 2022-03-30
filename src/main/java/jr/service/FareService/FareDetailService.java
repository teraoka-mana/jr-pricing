package jr.service.FareService;

import jr.domain.expressFareDetail.ExpressDetail;
import jr.domain.fare.FareDetail;
import jr.domain.fare.NumberOfPeople;
import jr.domain.onePersonFare.OneAdultFare;
import jr.domain.onePersonFare.OneChildFare;
import jr.service.onePersonFareService.OneAdultFareService;
import jr.service.onePersonFareService.OneChildFareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FareDetailService {
    @Autowired
    private OneAdultFareService oneAdultFareService;

    @Autowired
    private OneChildFareService oneChildFareService;


    public FareDetail createFareDetail(NumberOfPeople numberOfPeople, ExpressDetail expressDetail){
        OneAdultFare oneAdultFare = oneAdultFareService.calculateOneAdultFare(expressDetail);
        OneChildFare oneChildFare = oneChildFareService.calculateOneChildFare(expressDetail);
        return new FareDetail(numberOfPeople,oneAdultFare,oneChildFare,expressDetail.getRoundTrip());
    }

}
