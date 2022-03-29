//package jr.service.FareService;
//
//import jr.domain.fare.Fare;
//import jr.domain.fare.FareDetail;
//import jr.domain.ticketDetail.BoardingDate;
//import jr.service.groupDiscountSeasonService.GroupDiscountSeasonService;
//
//public class FareService {
//    private GroupDiscountSeasonService groupDiscountSeasonService;
//
//    public FareService(GroupDiscountSeasonService groupDiscountSeasonService){
//        this.groupDiscountSeasonService = groupDiscountSeasonService;
//    }
//
//
//    public Fare calculation(FareDetail fareDetail, BoardingDate boardingDate){
//        switch (groupDiscountSeasonService.getSeason(boardingDate)) {
//            case peakSeason:
//            if (8 <= fareDetail.getNumberOfPeople().getValue() && fareDetail.getNumberOfPeople().getValue() < 31) {
//                int AdultFares = fareDetail.getAdultFare().
//            }
//        }
//
//    }
//
//}
