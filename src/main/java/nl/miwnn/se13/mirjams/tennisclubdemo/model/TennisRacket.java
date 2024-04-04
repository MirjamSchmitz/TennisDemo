package nl.miwnn.se13.mirjams.tennisclubdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.lang.annotation.Inherited;

/**
 * @author Mirjam Schmitz
 * <p>
 * A tennisracket to play tennis with
 **/
@Entity
public class TennisRacket {
    @Id
    @GeneratedValue
    private Long racketId;

    @ManyToOne //more tennisrackets can belong to a member
    private Member member;

    public Long getRacketId() {
        return racketId;
    }

    public void setRacketId(Long racketId) {
        this.racketId = racketId;
    }


    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
