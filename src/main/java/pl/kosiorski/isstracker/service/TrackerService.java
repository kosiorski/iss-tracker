package pl.kosiorski.isstracker.service;

import pl.kosiorski.isstracker.model.Position;
import pl.kosiorski.isstracker.model.Tracker;

public interface TrackerService {

  public void save(Tracker tracker);

  public double countDistance(Position startPosition, Position endPosition);
}
