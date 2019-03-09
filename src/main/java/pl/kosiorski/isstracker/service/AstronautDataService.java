package pl.kosiorski.isstracker.service;

import pl.kosiorski.isstracker.model.Astronaut;
import pl.kosiorski.isstracker.model.AstronautData;

import java.util.List;

public interface AstronautDataService {

  void save(AstronautData astronautData);
  List<Astronaut> findAllAstronauts(Long astronautDataId);
}
