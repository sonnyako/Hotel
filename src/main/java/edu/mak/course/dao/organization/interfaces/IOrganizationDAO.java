package edu.mak.course.dao.organization.interfaces;

import edu.mak.course.dao.model.Organization;

import java.util.List;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IOrganizationDAO {
    Organization getById(String id);

    Organization create(Organization organization);

    Organization update(Organization organization);

    Organization delete(String id);

    List<Organization> getAll();
}
