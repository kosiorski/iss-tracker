package pl.kosiorski.isstracker.service;

import pl.kosiorski.isstracker.model.Path;

public interface PathService {

  void save(Path path);

  double countDistance(Path path);

  double countAverageSpeed(Path path);
}
