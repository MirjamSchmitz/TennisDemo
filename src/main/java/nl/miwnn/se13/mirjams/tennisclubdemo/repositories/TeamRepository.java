package nl.miwnn.se13.mirjams.tennisclubdemo.repositories;

import nl.miwnn.se13.mirjams.tennisclubdemo.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository <Team, Long> {
}
