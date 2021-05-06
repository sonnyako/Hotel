package edu.mak.course.dao.group.impls;

import edu.mak.course.dao.group.interfaces.IGroupDAO;
import edu.mak.course.dao.model.Group;
import edu.mak.course.data.FakeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class GroupDAOImpl implements IGroupDAO {
    @Autowired
    FakeData fakeData;

    @Override
    public Group getById(String id) {
        return getAll().stream()
            .filter(group -> group.getId().equals(id))
            .findFirst().orElse(null);
    }

    @Override
    public Group create(Group group) {
        String id = String.valueOf(getAll().stream().mapToInt(value -> Integer.valueOf(value.getId())).max().orElse(0) + 1);
        group.setId(id);
        getAll().add(group);
        return group;
    }

    @Override
    public Group update(Group group) {
        delete(group.getId());
        getAll().add(group);
        return group;
    }

    @Override
    public Group delete(String id) {
        Group group = getById(id);
        getAll().remove(group);
        return group;
    }

    @Override
    public List<Group> getAll() {
        return fakeData.getGroups();
    }

}
