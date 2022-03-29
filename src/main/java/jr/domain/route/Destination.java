package jr.domain.route;

import jr.domain.station.Station;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 目的地
 */

@AllArgsConstructor
@EqualsAndHashCode
public class Destination {
    @Getter
    private final Station station;
}
