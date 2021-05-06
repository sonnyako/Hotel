package edu.mak.course.service.traveller.impls;

import edu.mak.course.dao.model.Traveller;
import edu.mak.course.dao.traveller.impls.TravellerDAOImpl;
import edu.mak.course.service.traveller.iterfaces.ITravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class TravellerServiceImpl implements ITravellerService {

    @Autowired
    TravellerDAOImpl travellerDAO;

    @Override
    public Traveller getById(String id) {
        return travellerDAO.getById(id);
    }

    @Override
    public Traveller create(Traveller traveller) {
        return travellerDAO.create(traveller);
    }

    @Override
    public Traveller update(Traveller traveller) {
        return travellerDAO.update(traveller);
    }

    @Override
    public Traveller delete(String id) {
        return travellerDAO.delete(id);
    }

    @Override
    public List<Traveller> getAll() {
        return travellerDAO.getAll();
    }
}
