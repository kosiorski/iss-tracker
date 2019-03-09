package pl.kosiorski.isstracker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kosiorski.isstracker.model.Position;
import pl.kosiorski.isstracker.model.Tracker;
import pl.kosiorski.isstracker.repository.TrackerRepository;
import pl.kosiorski.isstracker.service.TrackerService;

@Service
public class TrackerServiceImpl implements TrackerService {
  private final TrackerRepository trackerRepository;

  @Autowired
  public TrackerServiceImpl(TrackerRepository trackerRepository) {
    this.trackerRepository = trackerRepository;
  }

  @Override
  public void save(Tracker tracker) {
    trackerRepository.save(tracker);
  }

  @Override
  public double countDistance(Position startPosition, Position endPosition) {

    final int R = 6371 + 408; // Earth radius + ISS orbit height in kilometres;

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
    double distance = R * c * 1000; // convert to meters

    double height = 0.0; // height difference

    distance = Math.pow(distance, 2) + Math.pow(height, 2);

    return Math.sqrt(distance);
  }
}
