package edu.mak.course.dao.group.interfaces;

import edu.mak.course.dao.model.TravellerGroup;

import java.util.List;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IGroupDAO {
    TravellerGroup getById(String id);

    TravellerGroup create(TravellerGroup travellerGroup);

    TravellerGroup update(TravellerGroup travellerGroup);

    TravellerGroup delete(String id);

    List<TravellerGroup> getAll();
}
