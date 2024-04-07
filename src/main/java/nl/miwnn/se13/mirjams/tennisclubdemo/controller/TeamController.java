package nl.miwnn.se13.mirjams.tennisclubdemo.controller;

import nl.miwnn.se13.mirjams.tennisclubdemo.model.Team;
import nl.miwnn.se13.mirjams.tennisclubdemo.repositories.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Mirjam Schmitz
 * <p>
 * Describes a team and everything that deals with a team
 **/
@Controller
public class TeamController {
    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/team")
    private String showAllTeams (Model model) {
        model.addAttribute("allTeams", teamRepository.findAll());
        model.addAttribute("newTeam", new Team());

        return "teamOverview";
    }

    @PostMapping("/team/new")
    private String saveOrUpdateTeam(@ModelAttribute("newTeam") Team team, BindingResult result){
        if(!result.hasErrors()){
            teamRepository.save(team);
        }
        return "redirect:/team";
    }
}
