package jr.api;


import jr.domain.roundTrip.RoundTrip;
import jr.domain.route.Departure;
import jr.domain.route.Destination;
import jr.domain.route.Route;
import jr.domain.station.Station;
import jr.domain.station.StationId;
import jr.domain.station.StationName;
import jr.domain.expressFareDetail.BoardingDate;
import jr.domain.expressFareDetail.ExpressDetail;
import jr.domain.expressFareDetail.Seat;
import jr.domain.expressFareDetail.TrainType;
import jr.service.onePersonFareService.OneAdultFareService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@Component
public class API {
    @Autowired
    OneAdultFareService oneAdultFareService;

    @RequestMapping()
    public Map calculateFare() {

        Map<String, Object> res = new HashMap<>();

        res.put("値段:",
                oneAdultFareService.calculateOneAdultFare(
                new ExpressDetail(
                        new Route(new Departure(new Station(new StationId(1L), new StationName("東京"))),
                                new Destination(new Station(new StationId(2L), new StationName("新大阪")))
                        ),
                        TrainType.ひかり,
                        Seat.指定席,
                        new BoardingDate(new Date()),
                        RoundTrip.No)).getTotalFare());

        return res;
    }
}