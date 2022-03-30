package it

import jr.Application
import jr.domain.expressFareDetail.ExpressDetail
import jr.domain.fare.FareDetail
import jr.domain.fare.NumberOFAdult
import jr.domain.fare.NumberOfChild
import jr.domain.fare.NumberOfPeople
import jr.domain.roundTrip.RoundTrip
import jr.domain.route.Departure
import jr.domain.route.Destination
import jr.domain.route.Route
import jr.domain.station.Station
import jr.domain.station.StationId
import jr.domain.station.StationName
import jr.domain.expressFareDetail.BoardingDate
import jr.domain.expressFareDetail.Seat
import jr.domain.expressFareDetail.TrainType
import jr.service.FareService.FareDetailService
import jr.service.FareService.FareService
import jr.service.onePersonFareService.OneAdultFareService
import jr.service.onePersonFareService.OneChildFareService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = Application.class)
class IntegrationTest extends Specification {
    @Autowired
    FareService fareService;
    @Autowired
    FareDetailService fareDetailService

    def "東京 から 新大阪 まで ひかり 指定席 大人片道1枚"() {
        expect://東京から新大阪ひかり指定席大人片道1枚の運賃+特急料金の値段を出力するテスト


        fareService.calculation(
                fareDetailService.createFareDetail(
                        new NumberOfPeople(new NumberOFAdult(1), new NumberOfChild(0)),
                        new ExpressDetail(
                                new Route(new Departure(new Station(new StationId(1L), new StationName("東京"))),
                                        new Destination(new Station(new StationId(2L), new StationName("新大阪")))
                                ),
                                TrainType.ひかり,
                                Seat.指定席,
                                new BoardingDate(new Date()),
                                RoundTrip.No)),
                new BoardingDate(new Date())).getValue() == 14400
    }

    def "東京 から #station まで #train #seat 大人片道1枚"() {
        when:
        def actualFare = getFareExample(station, train, seat)

        then:
        actualFare == expectedFare

        where:
        station | train | seat  || expectedFare
        "新大阪"   | "ひかり" | "指定席" || 14400
        "新大阪"   | "ひかり" | "自由席" || 13870
        "新大阪"   | "のぞみ" | "指定席" || 14720
        "新大阪"   | "のぞみ" | "自由席" || 14190
        "姫路"    | "ひかり" | "指定席" || 15930
        "姫路"    | "ひかり" | "自由席" || 15400
        "姫路"    | "のぞみ" | "指定席" || 16460
        "姫路"    | "のぞみ" | "自由席" || 15930
    }

    //仮テスト実行用
    private static int getFareExample(String station, String train, String seat) {
        int fare = 0
        switch (station) {
            case "新大阪": fare += 8910 + 5490
                if (train == "のぞみ") fare += 320
                break
            case "姫路": fare += 10010 + 5920
                if (train == "のぞみ") fare += 530
                break
        }
        if (seat == "自由席") {
            fare -= 530
        }
        return fare
    }
}
