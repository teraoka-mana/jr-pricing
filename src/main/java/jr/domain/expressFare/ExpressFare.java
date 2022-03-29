package jr.domain.expressFare;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ExpressFare {
    @Getter
    private final int value;

    public ExpressFare add(ExpressFare expressFare) {
        return new ExpressFare(this.getValue() + expressFare.getValue());
    }

    public ExpressFare divide(ExpressFare expressFare) {
        return new ExpressFare(this.getValue() - expressFare.getValue());
    }
}
