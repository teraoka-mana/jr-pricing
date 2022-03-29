package jr.domain.onePersonFare;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@AllArgsConstructor
@EqualsAndHashCode
public class OneChildPersonFare {
    @Getter
    private final int value;

    public OneChildPersonFare roundDown(OneChildPersonFare oneChildPersonFare) {
        return new OneChildPersonFare(
                (int) Math.floor(oneChildPersonFare.getValue() * 0.1) * 10
        );
    }
}
