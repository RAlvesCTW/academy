package com.ctw.workstation.booking.control;

import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.rack.control.RackRepository;
import com.ctw.workstation.rack.entity.Rack;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class BookingService {

    @Inject
    BookingRepository bookingRepository;

    public void addBooking(Booking booking) {
        booking.setCreatedAt(LocalDateTime.now());
        booking.setModifiedAt(LocalDateTime.now());
        bookingRepository.persist(booking);
    }

    public List<Booking> getBookings() {
        return bookingRepository.listAll();
    }

    public Booking getBookingById(long id) {
        return bookingRepository.findById(id);
    }

    public Booking updateBooking(long id, Booking updatedBooking) {
        Booking booking = bookingRepository.findById(id);
        if (booking == null) return null;
        booking.setRackId(updatedBooking.getRackId());
        booking.setRequesterId(updatedBooking.getRequesterId());
        booking.setBookFrom(updatedBooking.getBookFrom());
        booking.setBookTo(updatedBooking.getBookTo());
        booking.setModifiedAt(LocalDateTime.now());
        bookingRepository.persist(booking);
        return booking;
    }

    public boolean deleteBooking(long id) {
        return bookingRepository.deleteById(id);
    }
}
