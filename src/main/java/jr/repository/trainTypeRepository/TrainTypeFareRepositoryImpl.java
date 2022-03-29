package jr.repository.trainTypeRepository;

import jr.domain.expressFare.ExpressFare;
import jr.domain.route.Route;
import org.springframework.stereotype.Repository;

@Repository
public class TrainTypeFareRepositoryImpl implements TrainTypeFareRepository {
    @Override
    public ExpressFare findNozomiFare(Route route) {
        if(route.getDestination().getStation().getStationName().equals("姫路")){
            return new ExpressFare(530);
        }
        if(route.getDestination().getStation().getStationName().equals("新大阪")){
            return new ExpressFare(320);
        }
        throw new RuntimeException("すみません。東京-姫路と東京-新大阪区間しか対応してません。");
    }
}
