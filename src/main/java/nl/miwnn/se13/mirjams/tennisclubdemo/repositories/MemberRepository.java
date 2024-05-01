package nl.miwnn.se13.mirjams.tennisclubdemo.repositories;

import nl.miwnn.se13.mirjams.tennisclubdemo.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByNameMember(String name);
}
