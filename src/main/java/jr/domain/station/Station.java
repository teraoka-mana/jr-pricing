package jr.domain.station;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public class Station {
    @Getter
    private StationId id;
    @Getter
    private StationName stationName;
}
