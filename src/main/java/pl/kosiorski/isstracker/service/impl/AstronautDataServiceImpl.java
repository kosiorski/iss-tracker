package pl.kosiorski.isstracker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kosiorski.isstracker.model.Astronaut;
import pl.kosiorski.isstracker.model.AstronautData;
import pl.kosiorski.isstracker.repository.AstronautDataRepository;
import pl.kosiorski.isstracker.service.AstronautDataService;

import java.util.List;
import java.util.Optional;

@Service
public class AstronautDataServiceImpl implements AstronautDataService {
  private final AstronautDataRepository astronautDataRepository;

  @Autowired
  public AstronautDataServiceImpl(AstronautDataRepository astronautDataRepository) {
    this.astronautDataRepository = astronautDataRepository;
  }

  @Override
  public void save(AstronautData astronautData) {
    astronautDataRepository.save(astronautData);
  }

  @Override
  public List<Astronaut> findAllAstronauts(Long astronautDataId) {
    Optional<AstronautData> byId = astronautDataRepository.findById(astronautDataId);
    return byId.map(AstronautData::getPeople).orElse(null);
  }
}
