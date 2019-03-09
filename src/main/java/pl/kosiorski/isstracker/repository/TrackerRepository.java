package pl.kosiorski.isstracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kosiorski.isstracker.model.Tracker;

public interface TrackerRepository extends JpaRepository<Tracker, Long> {}
