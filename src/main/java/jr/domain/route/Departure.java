package jr.domain.route;

import jr.domain.station.Station;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 出発地
 */

@AllArgsConstructor
@EqualsAndHashCode
public class Departure {
    @Getter
    private final Station station;
}
