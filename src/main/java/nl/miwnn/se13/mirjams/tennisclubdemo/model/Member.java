package nl.miwnn.se13.mirjams.tennisclubdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.Period;

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
    private LocalDate dayOfBirth;
    private int ranking;

    public Member(String nameMember, LocalDate dayOfBirth, int ranking) {
        this.nameMember = nameMember;
        this.dayOfBirth = dayOfBirth;
        this.ranking = ranking;
    }

    public Member(String nameMember, int ranking) {
        this.nameMember = nameMember;
        this.ranking = ranking;
    }

    public Member() {

    }

//    public int getAge() {
//        return Period.between(dayOfBirth, LocalDate.now()).getYears();
//    }


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

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
