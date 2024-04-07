package nl.miwnn.se13.mirjams.tennisclubdemo.controller;

import nl.miwnn.se13.mirjams.tennisclubdemo.model.Member;
import nl.miwnn.se13.mirjams.tennisclubdemo.repositories.MemberRepository;
import nl.miwnn.se13.mirjams.tennisclubdemo.repositories.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mirjam Schmitz
 * <p>
 * Handle all requests regarding members
 **/

@Controller
public class MemberController {
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public MemberController(MemberRepository memberRepository, TeamRepository teamRepository) {
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
    }

    @GetMapping("/")
    private String showMemberOverview(Model model){
        model.addAttribute("allMembers", memberRepository.findAll());

        return "memberOverview";  // methode geeft de naam van de memberOverview in de template terug
    }

    @GetMapping("/member/new")
    private String showMemberForm(Model model) {
        model.addAttribute("member", new Member());
        model.addAttribute("allTeams", teamRepository.findAll());

        return "memberForm";
    }

    @PostMapping("/member/new")
    private String saveMember(@ModelAttribute("member") Member memberToBeSaved, BindingResult result) {
        if (!result.hasErrors()) {
            memberRepository.save(memberToBeSaved);
        }

        return "redirect:/";
    }
}
