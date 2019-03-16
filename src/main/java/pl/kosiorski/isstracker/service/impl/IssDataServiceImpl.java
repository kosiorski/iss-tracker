package pl.kosiorski.isstracker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kosiorski.isstracker.model.IssData;
import pl.kosiorski.isstracker.model.Position;
import pl.kosiorski.isstracker.repository.IssDataRepository;
import pl.kosiorski.isstracker.service.IssDataService;

import java.util.Optional;

@Service
public class IssDataServiceImpl implements IssDataService {

  private final IssDataRepository issDataRepository;

  @Autowired
  public IssDataServiceImpl(IssDataRepository issDataRepository) {
    this.issDataRepository = issDataRepository;
  }

  @Override
  public void save(IssData issData) {
    issDataRepository.save(issData);
  }

  @Override
  public double countDistance(IssData actual) {

    double countedDistance = 0.0;
    // JS interval in seconds;
    int intervalValue = 1;

    Optional<IssData> previous = issDataRepository.findById(actual.getId() - 1);

    if (issDataRepository.findById(actual.getId() - 1).isPresent()) {

      Position startPosition = previous.get().getIss_position();
      Position endPosition = actual.getIss_position();

      if (Integer.valueOf(actual.getTimestamp()) - Integer.valueOf(previous.get().getTimestamp())
          > intervalValue + 1) {
        return countedDistance;
      } else if (Integer.valueOf(actual.getTimestamp())
              - Integer.valueOf(previous.get().getTimestamp())
          <= 0) {
        return countedDistance;

      } else {

        final int R = 6371; // Earth radius kilometers

        double latitudeDistance =
            Math.toRadians(endPosition.getLatitude() - startPosition.getLatitude());
        double longitudeDistance =
            Math.toRadians(endPosition.getLongitude() - startPosition.getLongitude());

        double a =
            Math.sin(latitudeDistance / 2) * Math.sin(latitudeDistance / 2)
                + Math.cos(Math.toRadians(startPosition.getLatitude()))
                    * Math.cos(Math.toRadians(endPosition.getLatitude()))
                    * Math.sin(longitudeDistance / 2)
                    * Math.sin(longitudeDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c; // * 1000; // convert to meters

        double height = 0.0; // height difference

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        countedDistance = Math.sqrt(distance);
      }
    }
    return countedDistance;
  }

  @Override
  public double countSpeed(IssData actual) {

    double countedSpeed = 0.0;
    // JS interval in seconds;
    int intervalValue = 1;

    Optional<IssData> previous = issDataRepository.findById(actual.getId() - 1);
    if (previous.isPresent()) {

      String startTime = previous.get().getTimestamp();
      String endTime = actual.getTimestamp();

      double distance = countDistance(actual);

      if (Integer.valueOf(actual.getTimestamp()) - Integer.valueOf(previous.get().getTimestamp())
          > intervalValue + 1) {
        return countedSpeed;
      } else if (Integer.valueOf(actual.getTimestamp())
              - Integer.valueOf(previous.get().getTimestamp())
          <= 0) {
        return countedSpeed;

      } else {

        return distance / (Integer.valueOf(endTime) - Integer.valueOf(startTime));
      }
    }

    return countedSpeed;
  }
}
