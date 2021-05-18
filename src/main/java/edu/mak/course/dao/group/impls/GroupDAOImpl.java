package edu.mak.course.dao.group.impls;

import edu.mak.course.dao.group.interfaces.IGroupDAO;
import edu.mak.course.dao.model.TravellerGroup;
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
    public TravellerGroup getById(String id) {
        return getAll().stream()
            .filter(group -> group.getId().equals(id))
            .findFirst().orElse(null);
    }

    @Override
    public TravellerGroup create(TravellerGroup travellerGroup) {
        String id = String.valueOf(getAll().stream().mapToInt(value -> Integer.valueOf(value.getId())).max().orElse(0) + 1);
        travellerGroup.setId(id);
        getAll().add(travellerGroup);
        return travellerGroup;
    }

    @Override
    public TravellerGroup update(TravellerGroup travellerGroup) {
        delete(travellerGroup.getId());
        getAll().add(travellerGroup);
        return travellerGroup;
    }

    @Override
    public TravellerGroup delete(String id) {
        TravellerGroup travellerGroup = getById(id);
        getAll().remove(travellerGroup);
        return travellerGroup;
    }

    @Override
    public List<TravellerGroup> getAll() {
        return fakeData.getTravellerGroups();
    }

}
