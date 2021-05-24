package edu.mak.course.service;

import edu.mak.course.dao.model.TravellerGroup;

import java.util.List;
import java.util.Optional;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface TravellerGroupService {

    TravellerGroup update(TravellerGroup travellerGroup);

    TravellerGroup create(TravellerGroup travellerGroup);

    TravellerGroup delete(String id);

    Optional<TravellerGroup> getById(String id);

    List<TravellerGroup> getAll();
}
