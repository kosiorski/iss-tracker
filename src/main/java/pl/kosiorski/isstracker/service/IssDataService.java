package pl.kosiorski.isstracker.service;

import pl.kosiorski.isstracker.model.IssData;

public interface IssDataService {

  void save(IssData issData);

  double countDistance(IssData actual);

  double countSpeed(IssData actual);


}
