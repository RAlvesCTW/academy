package com.ctw.workstation.teammember.control;

import com.ctw.workstation.teammember.entity.TeamMember;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TeamMemberRepository implements PanacheRepository<TeamMember> {

}
