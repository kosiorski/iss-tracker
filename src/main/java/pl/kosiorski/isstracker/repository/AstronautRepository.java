package pl.kosiorski.isstracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kosiorski.isstracker.model.Astronaut;

public interface AstronautRepository extends JpaRepository<Astronaut, Long> {}
