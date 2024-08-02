package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.rack.control.RackService;
import com.ctw.workstation.rack.entity.Rack;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/racks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RackResource {

    @Inject
    RackService rackService;

    @POST
    @Transactional
    public Response create(Rack rack) {
        rackService.addRack(rack);
        return Response.status(Response.Status.CREATED).entity(rack).build();
    }

    @GET
    public Response get() {
        List<Rack> racks = rackService.getRacks();
        return Response.status(Response.Status.OK).entity(racks).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") long id) {
        Rack rack = rackService.getRackById(id);
        if (rack == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.status(Response.Status.OK).entity(rack).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response updateById(@PathParam("id") long id, Rack updatedRack) {
        Rack rack = rackService.updateRack(id, updatedRack);
        if (rack == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.status(Response.Status.OK).entity(rack).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteById(@PathParam("id") long id) {
        boolean deleted = rackService.deleteRack(id);
        if (deleted) return Response.status(Response.Status.OK).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
