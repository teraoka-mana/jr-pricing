package jr.service.expressFareService;

import jr.domain.expressFare.ExpressFare;
import jr.domain.ticketDetail.Seat;
import jr.repository.seatRepository.SeatRepository;
import jr.repository.seatRepository.SeatRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class SeatService {

    private SeatRepository seatRepository = new SeatRepositoryImpl();

    public ExpressFare getSeatReduction(Seat seat){
        return seatRepository.findSeatReduction(seat);
    }
}
