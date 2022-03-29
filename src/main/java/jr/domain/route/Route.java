package jr.domain.route;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * ルート
 */

@AllArgsConstructor
@EqualsAndHashCode
public class Route {
    @Getter
    private final Departure departure;
    @Getter
    private final Destination destination
            ;


}
