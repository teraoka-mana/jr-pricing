package jr.domain.fare;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
public class Fare {
    @Getter
    private final int value;

    public Fare add(Fare fare) {
        return new Fare(this.getValue() + fare.getValue());
    }
}
