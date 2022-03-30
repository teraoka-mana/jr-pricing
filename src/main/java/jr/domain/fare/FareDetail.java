package jr.domain.fare;

import jr.domain.onePersonFare.OneAdultFare;
import jr.domain.onePersonFare.OneChildFare;
import jr.domain.roundTrip.RoundTrip;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
public class FareDetail {

    @Getter
    private NumberOfPeople numberOfPeople;

    @Getter
    private OneAdultFare adultFare;

    @Getter
    private OneChildFare childFare;

    @Getter
    private RoundTrip roundTrip;

}
