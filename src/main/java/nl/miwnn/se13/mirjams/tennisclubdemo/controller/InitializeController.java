package nl.miwnn.se13.mirjams.tennisclubdemo.controller;

import nl.miwnn.se13.mirjams.tennisclubdemo.model.Member;
import nl.miwnn.se13.mirjams.tennisclubdemo.model.Team;
import nl.miwnn.se13.mirjams.tennisclubdemo.model.TennisRacket;
import nl.miwnn.se13.mirjams.tennisclubdemo.repositories.MemberRepository;
import nl.miwnn.se13.mirjams.tennisclubdemo.repositories.TeamRepository;
import nl.miwnn.se13.mirjams.tennisclubdemo.repositories.TennisRacketRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mirjam Schmitz
 *
 * Set some initial data in the database for testing purposes
 **/
@Controller
public class InitializeController {
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;
    private final TennisRacketRepository tennisRacketRepository;

    public InitializeController(MemberRepository memberRepository,
                                TeamRepository teamRepository,
                                TennisRacketRepository tennisRacketRepository) {
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
        this.tennisRacketRepository = tennisRacketRepository;
    }

    @GetMapping("/initialize")
    private String initializeDB(){
        Team gemengdDubbel_1 = makeTeam("GD1");
        Team gemengdDubbel_2 = makeTeam("GD2");
        Team herenDubbel_1 = makeTeam("HD1");
        Team herenDubbel_2 = makeTeam("HD2");
        Team damesDubbel_1 = makeTeam("DD1");
        Team damesEnkel_Dubbel_1 = makeTeam("DED1");

        Member joost = makeMember("Joost Slotemaker", herenDubbel_1);
        Member vera = makeMember("Vera Linn", damesEnkel_Dubbel_1);
        Member tamara = makeMember("Tamara Drul", damesDubbel_1);
        Member koos = makeMember("Koos Boot", gemengdDubbel_2);

        makeTennisRacket(joost);
        makeTennisRacket(joost).setAvailable(false);
        makeTennisRacket(vera);
        makeTennisRacket(koos);
        makeTennisRacket(koos);

        return "redirect:/";
    }

    private Team makeTeam(String name){
        Team team = new Team();
        team.setTeamName(name);
        teamRepository.save(team);
        return team;
    }

    private Member makeMember(String nameMember, Team team){
        Member member = new Member();
        member.setNameMember(nameMember);

        Set<Team> teamSet = new HashSet<>();
        teamSet.add(team);
        member.setTeams(teamSet);

        memberRepository.save(member);
        return member;
    }

    private TennisRacket makeTennisRacket(Member member){
        TennisRacket tennisRacket = new TennisRacket();
        tennisRacket.setMember(member);
        tennisRacketRepository.save(tennisRacket);
        return tennisRacket;
    }
}
