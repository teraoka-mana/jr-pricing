package jr.domain.onePersonFare;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
public class TotalFare {
    @Getter
    private final int value;
}
