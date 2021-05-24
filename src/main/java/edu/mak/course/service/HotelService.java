package edu.mak.course.service;

import edu.mak.course.dao.model.Hotel;

import java.util.Optional;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface HotelService {
    Hotel update(Hotel hotel);

    Hotel create(Hotel hotel);

    Hotel delete(String id);

    Optional<Hotel> getById(String id);
}
