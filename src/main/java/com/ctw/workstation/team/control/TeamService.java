package com.ctw.workstation.team.control;

import com.ctw.workstation.team.entity.Team;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class TeamService {

    @Inject
    TeamRepository teamRepository;

    public void addTeam(Team team) {
        team.setCreatedAt(LocalDateTime.now());
        team.setModifiedAt(LocalDateTime.now());
        teamRepository.persist(team);
    }

    public List<Team> getTeams() {
        return teamRepository.listAll();
    }

    public Team getTeamById(long id) {
        return teamRepository.findById(id);
    }

    public Team updateTeam(long id, Team updatedTeam) {
        Team team = teamRepository.findById(id);
        if (team == null) return null;
        team.setName(updatedTeam.getName());
        team.setProduct(updatedTeam.getProduct());
        team.setDefaultLocation(updatedTeam.getDefaultLocation());
        team.setModifiedAt(LocalDateTime.now());
        teamRepository.persist(team);
        return team;
    }

    public boolean deleteTeam(long id) {
        return teamRepository.deleteById(id);
    }
}
