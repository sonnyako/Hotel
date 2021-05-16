package edu.mak.course.service;

import edu.mak.course.dao.model.Organization;

import java.util.List;
import java.util.Optional;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface OrganizationService {
    Optional<Organization> getById(String id);

    Organization create(Organization organization);

    Organization update(Organization organization);

    Organization delete(String id);

    List<Organization> getAll();

    Optional<Organization> getByName(String name);
}
