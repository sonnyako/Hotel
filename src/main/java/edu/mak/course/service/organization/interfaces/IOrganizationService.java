package edu.mak.course.service.organization.interfaces;

import edu.mak.course.dao.model.Organization;

import java.util.List;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IOrganizationService {
    Organization getById(String id);

    Organization create(Organization organization);

    Organization update(Organization organization);

    Organization delete(String id);

    List<Organization> getAll();

    Organization getByName(String name);
}
