package pl.kosiorski.isstracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kosiorski.isstracker.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {}
