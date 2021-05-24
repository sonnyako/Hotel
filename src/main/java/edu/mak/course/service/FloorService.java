package edu.mak.course.service;

import edu.mak.course.dao.model.Floor;

import java.util.List;
import java.util.Optional;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface FloorService {
    Floor update(Floor floor);

    Floor create(Floor floor);

    Floor delete(String id);

    Optional<Floor> getById(String id);

    List<Floor> getAll();
}
