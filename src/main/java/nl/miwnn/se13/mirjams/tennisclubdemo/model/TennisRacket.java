package nl.miwnn.se13.mirjams.tennisclubdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * @author Mirjam Schmitz
 *
 * A tennisracket that is used by a member or is an extra racket or is in repair.
 **/
@Entity
public class TennisRacket {
    @Id @GeneratedValue
    private Long racketId;

    private Boolean available = true; //racket can be in repair

    @ManyToOne //more tennisrackets can belong to a member
    private Member member;

    public Long getRacketId() {
        return racketId;
    }

    public void setRacketId(Long racketId) {
        this.racketId = racketId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
