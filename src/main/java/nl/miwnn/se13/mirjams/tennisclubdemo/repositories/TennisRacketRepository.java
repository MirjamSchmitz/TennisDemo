package nl.miwnn.se13.mirjams.tennisclubdemo.repositories;

import nl.miwnn.se13.mirjams.tennisclubdemo.model.Member;
import nl.miwnn.se13.mirjams.tennisclubdemo.model.TennisRacket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mirjam Schmitz
 * <p>
 * Purpose for the class
 **/
public interface TennisRacketRepository extends JpaRepository<TennisRacket, Long> {
}
