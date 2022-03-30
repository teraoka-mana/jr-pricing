package jr.repository.seatRepository;

import jr.domain.expressFare.ExpressFare;
import jr.domain.expressFareDetail.Seat;


public interface SeatRepository {
    ExpressFare findSeatReduction(Seat seat);
}
