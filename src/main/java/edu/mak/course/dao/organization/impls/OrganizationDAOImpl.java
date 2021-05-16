package edu.mak.course.dao.organization.impls;

import edu.mak.course.dao.model.Organization;
import edu.mak.course.dao.organization.interfaces.IOrganizationDAO;
import edu.mak.course.data.FakeData;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrganizationDAOImpl implements IOrganizationDAO {

    FakeData fakeData;

    @Override
    public Organization getById(String id) {
        return getAll().stream()
            .filter(organization -> organization.getId().equals(id))
            .findFirst().orElse(null);
    }

    @Override
    public Organization getByName(String name) {
        return getAll().stream()
            .filter(organization -> organization.getId().equals(name))
            .findFirst().orElse(null);
    }

    @Override
    public Organization create(Organization organization) {
        String id = String.valueOf(getAll().stream().mapToInt(value -> Integer.valueOf(value.getId())).max().orElse(0) + 1);
        organization.setId(id);
        getAll().add(organization);
        return organization;
    }

    @Override
    public Organization update(Organization organization) {
        delete(organization.getId());
        getAll().add(organization);
        return organization;
    }

    @Override
    public Organization delete(String id) {
        Organization organization = getById(id);
        getAll().remove(organization);
        return organization;
    }

    @Override
    public List<Organization> getAll() {
        return fakeData.getOrganizations();
    }
}
