package edu.mak.course.service;

import edu.mak.course.dao.model.Room;

import java.util.List;
import java.util.Optional;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface RoomService {
    Optional<Room> getById(String id);

    Room create(Room room);

    Room update(Room room);

    Room delete(String id);

    List<Room> getAll();
}
