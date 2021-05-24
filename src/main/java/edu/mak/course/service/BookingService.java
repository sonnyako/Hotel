package edu.mak.course.service;

import edu.mak.course.dao.model.Booking;

import java.util.List;
import java.util.Optional;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface BookingService {

    Booking update(Booking booking);

    Booking create(Booking booking);

    Booking delete(String id);

    Optional<Booking> getById(String id);

    List<Booking> getAll();
}
