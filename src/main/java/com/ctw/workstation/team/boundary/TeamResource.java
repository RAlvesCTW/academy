package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.control.TeamService;
import com.ctw.workstation.team.entity.Team;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/teams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamResource {

    @Inject
    TeamService teamService;

    @POST
    @Transactional
    public Response create(Team team) {
        teamService.addTeam(team);
        return Response.status(Response.Status.CREATED).entity(team).build();
    }

    @GET
    public Response get() {
        List<Team> teams = teamService.getTeams();
        return Response.status(Response.Status.OK).entity(teams).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") long id) {
        Team team = teamService.getTeamById(id);
        if (team == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.status(Response.Status.OK).entity(team).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response updateById(@PathParam("id") long id, Team updatedTeam) {
        Team team = teamService.updateTeam(id, updatedTeam);
        if (team == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.status(Response.Status.OK).entity(team).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteById(@PathParam("id") long id) {
        boolean deleted = teamService.deleteTeam(id);
        if (deleted) return Response.status(Response.Status.OK).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
