package jr.domain.tariff;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Tariff {
    @Getter
    private TariffId id;
    @Getter
    private int value;
}
