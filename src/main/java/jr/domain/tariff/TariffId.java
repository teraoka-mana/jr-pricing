package jr.domain.tariff;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@EqualsAndHashCode
public class TariffId {
    @Getter
    private UUID id;

    public TariffId() {
        try {
            this.id = UUID.randomUUID();
            UUID.fromString(id.toString());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("$value : $e.message");
        }
    }
}
