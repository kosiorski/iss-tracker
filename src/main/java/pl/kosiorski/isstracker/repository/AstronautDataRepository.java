package pl.kosiorski.isstracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kosiorski.isstracker.model.AstronautData;

@Repository
public interface AstronautDataRepository extends JpaRepository<AstronautData, Long> {}
