package pl.kosiorski.isstracker.service;

import pl.kosiorski.isstracker.model.Astronaut;

import java.util.List;

public interface AstronautService {

  void save(Astronaut astronaut);

  List<Astronaut> findAll();
}
