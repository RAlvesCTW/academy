package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.control.BookingService;
import com.ctw.workstation.booking.entity.Booking;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/bookings")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookingResource {

    @Inject
    BookingService bookingService;

    @POST
    @Transactional
    public Response create(Booking booking) {
        bookingService.addBooking(booking);
        return Response.status(Response.Status.CREATED).entity(booking).build();
    }

    @GET
    public Response get() {
        List<Booking> bookings = bookingService.getBookings();
        return Response.status(Response.Status.OK).entity(bookings).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") long id) {
        Booking booking = bookingService.getBookingById(id);
        if (booking == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.status(Response.Status.OK).entity(booking).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response updateById(@PathParam("id") long id, Booking updatedBooking) {
        Booking booking = bookingService.updateBooking(id, updatedBooking);
        if (booking == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.status(Response.Status.OK).entity(booking).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteById(@PathParam("id") long id) {
        boolean deleted = bookingService.deleteBooking(id);
        if (deleted) return Response.status(Response.Status.OK).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
