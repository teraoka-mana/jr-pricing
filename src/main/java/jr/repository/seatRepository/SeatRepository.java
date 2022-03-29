package jr.repository.seatRepository;

import jr.domain.expressFare.ExpressFare;
import jr.domain.ticketDetail.Seat;
import org.springframework.stereotype.Repository;


public interface SeatRepository {
    ExpressFare findSeatReduction(Seat seat);
}
