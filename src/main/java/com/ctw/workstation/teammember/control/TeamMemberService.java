package com.ctw.workstation.teammember.control;

import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class TeamMemberService {

    @Inject
    TeamMemberRepository teamMemberRepository;

    public void addTeamMember(TeamMember teamMember) {
        teamMember.setCreatedAt(LocalDateTime.now());
        teamMember.setModifiedAt(LocalDateTime.now());
        teamMemberRepository.persist(teamMember);
    }

    public List<TeamMember> getTeamMembers() {
        return teamMemberRepository.listAll();
    }

    public TeamMember getTeamMemberById(long id) {
        return teamMemberRepository.findById(id);
    }

    public TeamMember updateTeamMember(long id, TeamMember updatedTeamMember) {
        TeamMember teamMember = teamMemberRepository.findById(id);
        if (teamMember == null) return null;
        teamMember.setTeamId(updatedTeamMember.getTeamId());
        teamMember.setCtwId(updatedTeamMember.getCtwId());
        teamMember.setName(updatedTeamMember.getName());
        teamMember.setModifiedAt(LocalDateTime.now());
        teamMemberRepository.persist(teamMember);
        return teamMember;
    }

    public boolean deleteTeamMember(long id) {
        return teamMemberRepository.deleteById(id);
    }
}
