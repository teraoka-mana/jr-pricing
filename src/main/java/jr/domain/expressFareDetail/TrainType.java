package jr.domain.expressFareDetail;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TrainType {
    ひかり,
    のぞみ;

    public boolean isNozomi() {
        return this.equals(のぞみ);
    }
}
