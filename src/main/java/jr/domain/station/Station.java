package jr.domain.station;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public class Station {
    @Getter
    private StationId id;
    @Getter
    private StationName stationName;

    public boolean equalStation(Station station){
        return this.id.getId().equals(station.getId().getId()) && this.stationName.getName().equals(station.getStationName().getName());
    }

}
