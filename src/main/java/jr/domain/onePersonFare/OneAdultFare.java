package jr.domain.onePersonFare;

import jr.domain.expressFare.ExpressFare;
import jr.domain.tariff.Tariff;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
public class OneAdultFare {
    @Getter
    private final Tariff tariff;

    @Getter
    private final ExpressFare expressFare;

    @Getter
    private final TotalFare totalFare;
}
