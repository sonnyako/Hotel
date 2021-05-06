package edu.mak.course.service.group.interfaces;

import edu.mak.course.dao.model.Group;

import java.util.List;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IGroupService {
    Group getById(String id);

    Group create(Group group);

    Group update(Group group);

    Group delete(String id);

    List<Group> getAll();
}
