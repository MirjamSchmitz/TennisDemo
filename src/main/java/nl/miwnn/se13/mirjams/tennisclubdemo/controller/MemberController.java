package nl.miwnn.se13.mirjams.tennisclubdemo.controller;

import nl.miwnn.se13.mirjams.tennisclubdemo.model.Member;
import nl.miwnn.se13.mirjams.tennisclubdemo.repositories.MemberRepository;
import nl.miwnn.se13.mirjams.tennisclubdemo.repositories.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private String showMemberOverview(Model model) {
        model.addAttribute("allMembers", memberRepository.findAll());

        return "memberOverview";  // methode geeft de naam van de memberOverview (template) terug
    }

    @GetMapping("/member/new")
    private String showMemberForm(Model model) {
        model.addAttribute("member", new Member());
        model.addAttribute("allTeams", teamRepository.findAll());

        return "memberForm";
    }

    @PostMapping("/member/new")
    private String saveMember(@ModelAttribute("member") Member memberToBeSaved, BindingResult result) {
        if (memberToBeSaved.getMemberId() == null
                && memberRepository.findByNameMember(memberToBeSaved.getNameMember()).isPresent()) {
            return "redirect:/member/new";
        }
        if (!result.hasErrors()) {
            memberRepository.save(memberToBeSaved);
        }
        return "redirect:/";
    }

    @GetMapping("member/edit/{nameMember}")
    private String showEditMemberForm(@PathVariable("nameMember") String nameMember, Model model) {
        Optional<Member> member = memberRepository.findByNameMember(nameMember);

        if (member.isEmpty()) {
            return "redirect:/";
        }
        model.addAttribute("member", member.get());
        model.addAttribute("allTeams", teamRepository.findAll());

        return "memberForm";
    }

    @GetMapping("/member/detail/{nameMember}")
    private String showMemberDetails(@PathVariable("nameMember") String nameMember, Model model) {
        Optional<Member> member = memberRepository.findByNameMember(nameMember);

        if(member.isEmpty()){
            return "redirect:/member";
        }
        model.addAttribute("memberToBeShown", member.get());
        return "memberDetail";
    }
}
