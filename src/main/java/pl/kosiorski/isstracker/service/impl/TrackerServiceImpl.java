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

    return 0;
  }
}
