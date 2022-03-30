package jr.domain.fare;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
public class NumberOfPeople {
    @Getter
    private NumberOFAdult numberOFAdult;

    @Getter
    private NumberOfChild numberOfChild;

    public int getNumberOfPeople() {
        return this.numberOFAdult.getValue() + this.numberOfChild.getValue();
    }
}
