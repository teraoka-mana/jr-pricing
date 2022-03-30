package jr.domain.expressFareDetail;

import jr.domain.roundTrip.RoundTrip;
import jr.domain.route.Route;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@AllArgsConstructor
@EqualsAndHashCode
public class ExpressDetail {
    @Getter
    private final Route route;

    @Getter
    private final TrainType trainType;

    @Getter
    private final Seat seat;

    @Getter
    private final BoardingDate boardingDate;

    @Getter
    private final RoundTrip roundTrip;
}
