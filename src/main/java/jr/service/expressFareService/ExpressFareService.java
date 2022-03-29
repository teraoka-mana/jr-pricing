package jr.service.expressFareService;


import jr.domain.ticketDetail.ExpressDetail;
import jr.domain.expressFare.ExpressFare;
import jr.domain.route.Route;
import jr.repository.expressFareRepository.ExpressFareRepository;
import jr.repository.expressFareRepository.ExpressFareRepositoryImpl;
import jr.service.routeService.RouteService;
import jr.service.season.SeasonFareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpressFareService {
    @Autowired
    private RouteService routeService;

    @Autowired
    private TrainTypeFareService trainTypeFareService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private SeasonFareService seasonFareService;


    private ExpressFareRepository expressFarerepository = new ExpressFareRepositoryImpl();


    public ExpressFare getExpressReserveFare(Route route) {
        routeService.check(route);
        return expressFarerepository.findExpressReserveFare(route);
    }


    public ExpressFare calculation(ExpressDetail expressDetail) {
        return getExpressReserveFare(expressDetail.getRoute()).add(trainTypeFareService.getTrainTypeFare(expressDetail.getTrainType(), expressDetail.getRoute())).add(seasonFareService.getSeasonFare(expressDetail.getBoardingDate())).add(seatService.getSeatReduction(expressDetail.getSeat()));
    }

    public ExpressFare getChildExpressReserveFare(ExpressDetail expressDetail) {
        return new ExpressFare( (int) Math.floor(calculation(expressDetail).getValue() / 2 / 10) * 10);
    }
}
