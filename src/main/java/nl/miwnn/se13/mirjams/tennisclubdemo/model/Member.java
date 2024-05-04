package nl.miwnn.se13.mirjams.tennisclubdemo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Mirjam Schmitz
 *
 * Shows information about members of a tennisclub.
 **/

@Entity
public class Member {
    @Id @GeneratedValue
    private Long memberId;

    @Column(unique = true)
    private String nameMember;

    private int ranking;

    @ManyToMany
    private Set<Team> teams;

    @OneToMany (mappedBy = "member")
    private List<TennisRacket> tennisRackets = new ArrayList<>();

    public int getNumberOfAvailableRackets(){
        int count = 0;
        for (TennisRacket tennisRacket : tennisRackets){
            if(tennisRacket.getAvailable()){
                count++;
            }
        }
        return count;
    }

    public int getTotalNumberOfTennisRackets(){
        return tennisRackets.size();
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

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public List<TennisRacket> getTennisRackets() {
        return tennisRackets;
    }

    public void setTennisRackets(List<TennisRacket> tennisRackets) {
        this.tennisRackets = tennisRackets;
    }
}
