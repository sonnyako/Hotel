package edu.mak.course.service.organization.impls;

import edu.mak.course.dao.model.Organization;
import edu.mak.course.dao.organization.impls.OrganizationDAOImpl;
import edu.mak.course.service.organization.interfaces.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class OrganizationServiceImpl implements IOrganizationService {

    @Autowired
    OrganizationDAOImpl organizationDAO;

    @Override
    public Organization getById(String id) {
        return organizationDAO.getById(id);
    }

    @Override
    public Organization create(Organization organization) {
        return organizationDAO.create(organization);
    }

    @Override
    public Organization update(Organization organization) {
        return organizationDAO.update(organization);
    }

    @Override
    public Organization delete(String id) {
        return organizationDAO.delete(id);
    }

    @Override
    public List<Organization> getAll() {
        return organizationDAO.getAll();
    }

    @Override
    public Organization getByName(String name) {
        return organizationDAO.getByName(name);
    }
}
