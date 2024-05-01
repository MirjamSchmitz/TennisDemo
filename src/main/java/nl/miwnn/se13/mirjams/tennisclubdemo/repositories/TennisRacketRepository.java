package nl.miwnn.se13.mirjams.tennisclubdemo.repositories;

import nl.miwnn.se13.mirjams.tennisclubdemo.model.TennisRacket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TennisRacketRepository extends JpaRepository<TennisRacket, Long> {
}
