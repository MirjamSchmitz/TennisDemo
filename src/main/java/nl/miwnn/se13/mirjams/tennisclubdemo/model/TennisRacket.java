package nl.miwnn.se13.mirjams.tennisclubdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * @author Mirjam Schmitz
 * <p>
 * A tennisracket to play tennis with
 **/
@Entity
public class TennisRacket {
    @Id @GeneratedValue
    private Long racketId;

    private Boolean extraRacket = true;

    @ManyToOne //more tennisrackets can belong to a member
    private Member member;

    public Long getRacketId() {
        return racketId;
    }

    public void setRacketId(Long racketId) {
        this.racketId = racketId;
    }

    public Boolean getExtraRacket() {
        return extraRacket;
    }

    public void setExtraRacket(Boolean extraRacket) {
        this.extraRacket = extraRacket;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
