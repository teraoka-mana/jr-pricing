package jr.repository.seatRepository;

import jr.domain.expressFare.ExpressFare;
import jr.domain.expressFareDetail.Seat;
import org.springframework.stereotype.Repository;

@Repository
public class SeatRepositoryImpl implements SeatRepository {
    @Override
    public ExpressFare findSeatReduction(Seat seat) {
        switch (seat){
            case 指定席:
                return new ExpressFare(0);
            case 自由席:
                return new ExpressFare(-530);
            default:
                throw new RuntimeException("指定席、自由席しか取り扱っていません。");
        }
    }
}
