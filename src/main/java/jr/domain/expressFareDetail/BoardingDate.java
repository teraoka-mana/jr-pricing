package jr.domain.expressFareDetail;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@EqualsAndHashCode
public class BoardingDate {
    @Getter
    private final Date date;
}
