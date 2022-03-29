package jr.domain.season;

import jr.domain.ticketDetail.BoardingDate;
import lombok.Getter;

@Getter
public enum Season {
    peakSeason,
    offSeason,
    regularSeason;

    public static boolean peakSeason(BoardingDate boardingDate)
    {
        if (boardingDate.getDate().getMonth() == 12 && boardingDate.getDate().getDay() >= 25) { return true; }
        return boardingDate.getDate().getMonth() == 1 && boardingDate.getDate().getDay() <= 10;
    }

    public static boolean offSeason(BoardingDate boardingDate)
    {
        if (boardingDate.getDate().getMonth() == 1 && boardingDate.getDate().getDay() >= 16) { return true; }
        return boardingDate.getDate().getMonth() == 1 && boardingDate.getDate().getDay() <= 30;
    }
}
