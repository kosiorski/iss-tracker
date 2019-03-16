package pl.kosiorski.isstracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kosiorski.isstracker.model.Path;

@Repository
public interface PathRepository extends JpaRepository<Path, Long> {}
