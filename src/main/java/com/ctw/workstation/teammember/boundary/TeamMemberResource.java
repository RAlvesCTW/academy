package com.ctw.workstation.teammember.boundary;

import com.ctw.workstation.teammember.control.TeamMemberService;
import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/team-members")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamMemberResource {

    @Inject
    TeamMemberService teamMemberService;

    @POST
    @Transactional
    public Response create(TeamMember teamMember) {
        teamMemberService.addTeamMember(teamMember);
        return Response.status(Response.Status.CREATED).entity(teamMember).build();
    }

    @GET
    public Response get() {
        List<TeamMember> teamMembers = teamMemberService.getTeamMembers();
        return Response.status(Response.Status.OK).entity(teamMembers).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") long id) {
        TeamMember teamMember = teamMemberService.getTeamMemberById(id);
        if (teamMember == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.status(Response.Status.OK).entity(teamMember).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response updateById(@PathParam("id") long id, TeamMember updatedTeamMember) {
        TeamMember teamMember = teamMemberService.updateTeamMember(id, updatedTeamMember);
        if (teamMember == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.status(Response.Status.OK).entity(teamMember).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteById(@PathParam("id") long id) {
        boolean deleted = teamMemberService.deleteTeamMember(id);
        if (deleted) return Response.status(Response.Status.OK).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}