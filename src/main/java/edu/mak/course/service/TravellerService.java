package edu.mak.course.service;

import edu.mak.course.dao.model.Traveller;

import java.util.List;
import java.util.Optional;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface TravellerService {
    Optional<Traveller> getById(String id);

    Traveller create(Traveller traveller);

    Traveller update(Traveller traveller);

    Traveller delete(String id);

    List<Traveller> getAll();
}
