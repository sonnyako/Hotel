package edu.mak.course.service;

import edu.mak.course.dao.model.Building;

import java.util.List;
import java.util.Optional;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface BuildingService {
    
    Building update(Building building);

    Building create(Building building);

    Building delete(String id);

    Optional<Building> getById(String id);

    List<Building> getAll();
}
