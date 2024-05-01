package nl.miwnn.se13.mirjams.tennisclubdemo.controller;

import nl.miwnn.se13.mirjams.tennisclubdemo.model.Member;
import nl.miwnn.se13.mirjams.tennisclubdemo.model.TennisRacket;
import nl.miwnn.se13.mirjams.tennisclubdemo.repositories.MemberRepository;
import nl.miwnn.se13.mirjams.tennisclubdemo.repositories.TennisRacketRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author Mirjam Schmitz
 *
 * Handle all requests regarding tennisrackets
 **/

@Controller
public class TennisRacketController {
    private final MemberRepository memberRepository;
    private final TennisRacketRepository tennisRacketRepository;

    public TennisRacketController(MemberRepository memberRepository, TennisRacketRepository tennisRacketRepository) {
        this.memberRepository = memberRepository;
        this.tennisRacketRepository = tennisRacketRepository;
    }

    @GetMapping("/tennisracket/new/{nameMember}")
    private String createNewTennisRacket(@PathVariable("nameMember") String nameMember){
        Optional<Member> optionalMember = memberRepository.findByNameMember(nameMember);

        if(optionalMember.isPresent()){
            TennisRacket tennisRacket = new TennisRacket();
            tennisRacket.setMember(optionalMember.get());
            tennisRacketRepository.save(tennisRacket);
        }

        return "redirect:/";
    }

}
