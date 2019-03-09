package pl.kosiorski.isstracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kosiorski.isstracker.model.Astronaut;

@Repository
public interface AstronautRepository extends JpaRepository<Astronaut, Long> {}
