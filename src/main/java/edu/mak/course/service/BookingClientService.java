package edu.mak.course.service;

import edu.mak.course.dao.model.BookingClient;

import java.util.List;
import java.util.Optional;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface BookingClientService {

    BookingClient update(BookingClient bookingClient);

    BookingClient create(BookingClient bookingClient);

    BookingClient delete(String id);

    Optional<BookingClient> getById(String id);

    List<BookingClient> getAll();
}
