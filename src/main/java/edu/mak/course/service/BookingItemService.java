package edu.mak.course.service;

import edu.mak.course.dao.model.BookingItem;

import java.util.List;
import java.util.Optional;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface BookingItemService {

    BookingItem update(BookingItem bookingItem);

    BookingItem create(BookingItem bookingItem);

    BookingItem delete(String id);

    Optional<BookingItem> getById(String id);

    List<BookingItem> getAll();
}
