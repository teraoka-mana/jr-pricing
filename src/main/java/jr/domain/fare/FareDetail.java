package jr.domain.fare;

import jr.domain.onePersonFare.OneAdultPersonFare;
import jr.domain.onePersonFare.OneChildPersonFare;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
public class FareDetail {

    @Getter
    private NumberOFAdult numberOFAdult;

    @Getter
    private NumberOfChild numberOfChild;

    @Getter
    private OneAdultPersonFare adultFare;

    @Getter
    private OneChildPersonFare childFare;

    public NumberOfPeople getNumberOfPeople(){
        return new NumberOfPeople(this.numberOFAdult.getValue()+this.numberOfChild.getValue());
    }

}
