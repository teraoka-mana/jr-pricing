package jr.service.FareService;

import jr.domain.expressFare.ExpressFare;
import jr.domain.expressFareDetail.BoardingDate;
import jr.domain.fare.Fare;
import jr.domain.fare.FareDetail;
import jr.domain.fare.NumberOFAdult;
import jr.domain.onePersonFare.TotalFare;
import jr.domain.tariff.Tariff;
import jr.service.groupDiscountSeasonService.GroupDiscountSeasonService;
import jr.service.tariffService.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FareService {
    @Autowired
    private GroupDiscountSeasonService groupDiscountSeasonService;
    @Autowired
    private FareDetailService fareDetailService;
    @Autowired
    private TariffService tariffService;


    public FareService(GroupDiscountSeasonService groupDiscountSeasonService, FareDetailService fareDetailService, TariffService tariffService) {
        this.groupDiscountSeasonService = groupDiscountSeasonService;
        this.fareDetailService = fareDetailService;
        this.tariffService = tariffService;
    }


    public Fare calculation(FareDetail fareDetail, BoardingDate boardingDate) {
        switch (fareDetail.getRoundTrip()) {
            case No:
                if (8 <= fareDetail.getNumberOfPeople().getNumberOfPeople() && fareDetail.getNumberOfPeople().getNumberOfPeople() <= 30) {
                    return groupDiscountOneWay8_30(fareDetail, boardingDate);
                }
                if (31 <= fareDetail.getNumberOfPeople().getNumberOfPeople() && fareDetail.getNumberOfPeople().getNumberOfPeople() <= 50) {
                    return groupDiscount31_50(fareDetail, boardingDate);
                }
                if (51 <= fareDetail.getNumberOfPeople().getNumberOfPeople()) {
                    return groupDiscount51(fareDetail, boardingDate);
                }

                return new Fare(fareDetail.getAdultFare().getTotalFare().getValue()* fareDetail.getNumberOfPeople().getNumberOFAdult().getValue() + fareDetail.getChildFare().getTotalFare().getValue()* fareDetail.getNumberOfPeople().getNumberOfChild().getValue());


            case Yes:
                if (8 <= fareDetail.getNumberOfPeople().getNumberOfPeople() && fareDetail.getNumberOfPeople().getNumberOfPeople() <= 30) {
                   return groupDiscountRoundTrip8_30(fareDetail, boardingDate);
                }
                if (31 <= fareDetail.getNumberOfPeople().getNumberOfPeople() && fareDetail.getNumberOfPeople().getNumberOfPeople() <= 50) {
                    return groupDiscount31_50(fareDetail, boardingDate);
                }
                if (51 <= fareDetail.getNumberOfPeople().getNumberOfPeople()) {
                    return groupDiscount51(fareDetail, boardingDate);
                }

                return new Fare(fareDetail.getAdultFare().getTotalFare().getValue()* fareDetail.getNumberOfPeople().getNumberOFAdult().getValue() + fareDetail.getChildFare().getTotalFare().getValue()* fareDetail.getNumberOfPeople().getNumberOfChild().getValue());
        }
        throw new RuntimeException("往復か片道どちらかを選択してください。");
    }

    public Fare groupDiscountOneWay8_30(FareDetail fareDetail, BoardingDate boardingDate) {

        switch (groupDiscountSeasonService.getSeason(boardingDate)) {
            case peakSeason:
                Tariff peakAdultTariff = tariffService.peakSeasonGroupDiscount(fareDetail.getAdultFare().getTariff());
                ExpressFare peakAdultExpressFare = fareDetail.getAdultFare().getExpressFare();
                TotalFare peakAdultFare = new TotalFare(peakAdultTariff.getValue() + peakAdultExpressFare.getValue());

                Fare totalPeakAdultFare = new Fare(peakAdultFare.getValue() * fareDetail.getNumberOfPeople().getNumberOFAdult().getValue());

                Tariff peakChildTariff = tariffService.peakSeasonGroupDiscount(fareDetail.getChildFare().getTariff());
                ExpressFare peakChildExpressFare = fareDetail.getChildFare().getExpressFare();
                TotalFare peakChildFare = new TotalFare(peakChildTariff.getValue() + peakChildExpressFare.getValue());

                Fare totalPeakChildFare = new Fare(peakChildFare.getValue() * fareDetail.getNumberOfPeople().getNumberOfChild().getValue());

                return totalPeakAdultFare.add(totalPeakChildFare);

            case regularSeason:
                Tariff regularAdultTariff = tariffService.regularSeasonGroupDiscount(fareDetail.getAdultFare().getTariff());
                ExpressFare regularAdultExpressFare = fareDetail.getAdultFare().getExpressFare();
                TotalFare regularAdultFare = new TotalFare(regularAdultTariff.getValue() + regularAdultExpressFare.getValue());

                Fare totalRegularAdultFare = new Fare(regularAdultFare.getValue() * fareDetail.getNumberOfPeople().getNumberOFAdult().getValue());

                Tariff regularChildTariff = tariffService.regularSeasonGroupDiscount(fareDetail.getChildFare().getTariff());
                ExpressFare regularChildExpressFare = fareDetail.getChildFare().getExpressFare();
                TotalFare regularChildFare = new TotalFare(regularChildTariff.getValue() + regularChildExpressFare.getValue());

                Fare totalRegularChildFare = new Fare(regularChildFare.getValue() * fareDetail.getNumberOfPeople().getNumberOfChild().getValue());

                return totalRegularAdultFare.add(totalRegularChildFare);

            default:
                throw new RuntimeException("団体割引の適用期間が間違っています。");

        }
    }

    public Fare groupDiscountRoundTrip8_30(FareDetail fareDetail, BoardingDate boardingDate) {
        switch (groupDiscountSeasonService.getSeason(boardingDate)) {
            case peakSeason:
                Tariff peakAdultTariff = tariffService.peakSeasonGroupDiscount(fareDetail.getAdultFare().getTariff());
                ExpressFare peakAdultExpressFare = fareDetail.getAdultFare().getExpressFare();
                TotalFare peakAdultFare = new TotalFare(peakAdultTariff.getValue() * 2 + peakAdultExpressFare.getValue() * 2);

                Fare totalPeakAdultFare = new Fare(peakAdultFare.getValue() * fareDetail.getNumberOfPeople().getNumberOFAdult().getValue());

                Tariff peakChildTariff = tariffService.peakSeasonGroupDiscount(fareDetail.getChildFare().getTariff());
                ExpressFare peakChildExpressFare = fareDetail.getChildFare().getExpressFare();
                TotalFare peakChildFare = new TotalFare(peakChildTariff.getValue() * 2 + peakChildExpressFare.getValue() * 2);

                Fare totalPeakChildFare = new Fare(peakChildFare.getValue() * fareDetail.getNumberOfPeople().getNumberOfChild().getValue());

                return totalPeakAdultFare.add(totalPeakChildFare);

            case regularSeason:
                Tariff regularAdultTariff = tariffService.regularSeasonGroupDiscount(fareDetail.getAdultFare().getTariff());
                ExpressFare regularAdultExpressFare = fareDetail.getAdultFare().getExpressFare();
                TotalFare regularAdultFare = new TotalFare(regularAdultTariff.getValue() * 2 + regularAdultExpressFare.getValue() * 2);

                Fare totalRegularAdultFare = new Fare(regularAdultFare.getValue() * fareDetail.getNumberOfPeople().getNumberOFAdult().getValue());

                Tariff regularChildTariff = tariffService.regularSeasonGroupDiscount(fareDetail.getChildFare().getTariff());
                ExpressFare regularChildExpressFare = fareDetail.getChildFare().getExpressFare();
                TotalFare regularChildFare = new TotalFare(regularChildTariff.getValue() * 2 + regularChildExpressFare.getValue() * 2);

                Fare totalRegularChildFare = new Fare(regularChildFare.getValue() * fareDetail.getNumberOfPeople().getNumberOfChild().getValue());

                return totalRegularAdultFare.add(totalRegularChildFare);

            default:
                throw new RuntimeException("団体割引の適用期間が間違っています。");

        }

    }

    public Fare groupDiscount31_50(FareDetail fareDetail, BoardingDate boardingDate) {
        NumberOFAdult discountNumberOfPeople = new NumberOFAdult(fareDetail.getNumberOfPeople().getNumberOFAdult().getValue() - 1);

        Fare totalAdultFare = new Fare(fareDetail.getAdultFare().getTotalFare().getValue() * discountNumberOfPeople.getValue());
        Fare totalChildFare = new Fare(fareDetail.getChildFare().getTotalFare().getValue() * fareDetail.getNumberOfPeople().getNumberOfChild().getValue());

        return totalAdultFare.add(totalChildFare);
    }

    public Fare groupDiscount51(FareDetail fareDetail, BoardingDate boardingDate) {
        int discountNumber = (int) Math.ceil(fareDetail.getNumberOfPeople().getNumberOfPeople() / 5);
        NumberOFAdult discountNumberOfPeople = new NumberOFAdult(fareDetail.getNumberOfPeople().getNumberOFAdult().getValue() - discountNumber);

        Fare totalAdultFare = new Fare(fareDetail.getAdultFare().getTotalFare().getValue() * discountNumberOfPeople.getValue());
        Fare totalChildFare = new Fare(fareDetail.getChildFare().getTotalFare().getValue() * fareDetail.getNumberOfPeople().getNumberOfChild().getValue());

        return totalAdultFare.add(totalChildFare);
    }
}
