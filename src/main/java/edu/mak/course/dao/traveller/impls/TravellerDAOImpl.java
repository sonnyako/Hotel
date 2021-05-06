package edu.mak.course.dao.traveller.impls;

import edu.mak.course.dao.model.Traveller;
import edu.mak.course.dao.traveller.interfaces.ITravellerDAO;
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
public class TravellerDAOImpl implements ITravellerDAO {
    @Autowired
    FakeData fakeData;

    @Override
    public Traveller getById(String id) {
        return getAll().stream()
            .filter(traveller -> traveller.getId().equals(id))
            .findFirst().orElse(null);
    }

    @Override
    public Traveller create(Traveller traveller) {
        String id = String.valueOf(getAll().stream().mapToInt(value -> Integer.valueOf(value.getId())).max().orElse(0) + 1);
        traveller.setId(id);
        getAll().add(traveller);
        return traveller;
    }

    @Override
    public Traveller update(Traveller traveller) {
        delete(traveller.getId());
        getAll().add(traveller);
        return traveller;
    }

    @Override
    public Traveller delete(String id) {
        Traveller traveller = getById(id);
        getAll().remove(traveller);
        return traveller;
    }

    @Override
    public List<Traveller> getAll() {
        return fakeData.getTravellers();
    }

}
