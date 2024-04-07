package nl.miwnn.se13.mirjams.tennisclubdemo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

/**
 * @author Mirjam Schmitz
 * <p>
 * Shows information about members of a tennisclub.
 **/

@Entity
public class Member {
    @Id @GeneratedValue
    private Long memberId;
    private String nameMember;
//    private LocalDate dayOfBirth;
    private int ranking;

    @ManyToMany
    private Set<Team> teams;

    @OneToMany (mappedBy = "member")
    private List<TennisRacket> tennisrackets;

    public int getTotalNumberOfTennisRackets(){
        return tennisrackets.size();
    }

    public Member(String nameMember, int ranking) {
        this.nameMember = nameMember;
        this.ranking = ranking;
    }

    public Member() {
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getNameMember() {
        return nameMember;
    }

    public void setNameMember(String nameMember) {
        this.nameMember = nameMember;
    }


    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
