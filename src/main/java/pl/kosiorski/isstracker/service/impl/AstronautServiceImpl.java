package pl.kosiorski.isstracker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kosiorski.isstracker.model.Astronaut;
import pl.kosiorski.isstracker.repository.AstronautRepository;
import pl.kosiorski.isstracker.service.AstronautService;

import java.util.List;

@Service
public class AstronautServiceImpl implements AstronautService {

  private final AstronautRepository astronautRepository;

  @Autowired
  public AstronautServiceImpl(AstronautRepository astronautRepository) {
    this.astronautRepository = astronautRepository;
  }

  @Override
  public void save(Astronaut astronaut) {
    astronautRepository.save(astronaut);
  }

  @Override
  public List<Astronaut> findAll() {
    return astronautRepository.findAll();
  }
}
