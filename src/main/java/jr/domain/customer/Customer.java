package jr.domain.customer;

import lombok.Getter;

@Getter
public enum Customer {
    大人,
    子供;

    public boolean isAdult() {
        return this.equals(大人);
    }

}
