package pl.kosiorski.isstracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kosiorski.isstracker.model.IssData;

@Repository
public interface IssDataRepository extends JpaRepository<IssData, Long> {}
