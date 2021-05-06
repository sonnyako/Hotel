package edu.mak.course.service.group.impls;

import edu.mak.course.dao.group.impls.GroupDAOImpl;
import edu.mak.course.dao.model.Group;
import edu.mak.course.service.group.interfaces.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class GroupServiceImpl implements IGroupService {
    @Autowired
    GroupDAOImpl groupDAO;

    @Override
    public Group getById(String id) {
        return groupDAO.getById(id);
    }

    @Override
    public Group create(Group group) {
        return groupDAO.create(group);
    }

    @Override
    public Group update(Group group) {
        return groupDAO.update(group);
    }

    @Override
    public Group delete(String id) {
        return groupDAO.delete(id);
    }

    @Override
    public List<Group> getAll() {
        return groupDAO.getAll();
    }
}
