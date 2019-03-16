package pl.kosiorski.isstracker.service.impl;

import org.springframework.stereotype.Service;
import pl.kosiorski.isstracker.model.IssData;
import pl.kosiorski.isstracker.model.Path;
import pl.kosiorski.isstracker.repository.PathRepository;
import pl.kosiorski.isstracker.service.PathService;

import java.util.List;

@Service
public class PathServiceImpl implements PathService {

  private final PathRepository pathRepository;

  public PathServiceImpl(PathRepository pathRepository) {
    this.pathRepository = pathRepository;
  }

  @Override
  public void save(Path path) {
    pathRepository.save(path);
  }

  @Override
  public double countDistance(Path path) {
    List<IssData> issDataList = path.getIssDataList();
    return issDataList.stream().mapToDouble(IssData::getDistance).sum();
  }

  @Override
  public double countAverageSpeed(Path path) {

    List<IssData> issDataList = path.getIssDataList();
    return issDataList.stream()
        .filter(issData -> issData.getSpeed() != 0)
        .mapToDouble(IssData::getSpeed)
        .average()
        .orElse(Double.NaN);
  }
}
