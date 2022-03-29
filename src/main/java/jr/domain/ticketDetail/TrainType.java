package jr.domain.ticketDetail;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TrainType {
    ひかり,
    のぞみ;

    public boolean isNozomi() {
        return this.equals(のぞみ);
    }
}
