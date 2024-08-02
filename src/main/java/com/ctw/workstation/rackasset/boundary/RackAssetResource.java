package com.ctw.workstation.rackasset.boundary;

import com.ctw.workstation.rackasset.control.RackAssetService;
import com.ctw.workstation.rackasset.entity.RackAsset;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/rack-assets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RackAssetResource {

    @Inject
    RackAssetService rackAssetService;

    @POST
    @Transactional
    public Response create(RackAsset rackAsset) {
        rackAssetService.addRackAsset(rackAsset);
        return Response.status(Response.Status.CREATED).entity(rackAsset).build();
    }

    @GET
    public Response get() {
        List<RackAsset> rackAssets = rackAssetService.getRackAssets();
        return Response.status(Response.Status.OK).entity(rackAssets).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") long id) {
        RackAsset rackAsset = rackAssetService.getRackAssetById(id);
        if (rackAsset == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.status(Response.Status.OK).entity(rackAsset).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response updateById(@PathParam("id") long id, RackAsset updatedRackAsset) {
        RackAsset rackAsset = rackAssetService.updateRackAsset(id, updatedRackAsset);
        if (rackAsset == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.status(Response.Status.OK).entity(rackAsset).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteById(@PathParam("id") long id) {
        boolean deleted = rackAssetService.deleteRack(id);
        if (deleted) return Response.status(Response.Status.OK).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
