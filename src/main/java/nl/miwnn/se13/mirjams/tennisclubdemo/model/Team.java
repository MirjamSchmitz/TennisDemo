package nl.miwnn.se13.mirjams.tennisclubdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author Mirjam Schmitz
 *
 * Teams contain more than one member. Members can join more teams
 **/
@Entity
public class Team {

    @Id @GeneratedValue
    private Long teamId;

    private String teamName;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return teamName;
    }
}
