package edu.mak.course.service.impls;

import edu.mak.course.dao.model.Traveller;
import edu.mak.course.dao.repository.TravellerRepository;
import edu.mak.course.service.TravellerService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TravellerServiceImpl implements TravellerService {

    private final TravellerRepository repository;

    @Override
    public Optional<Traveller> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public Traveller create(Traveller traveller) {
        return repository.save(traveller);
    }

    @Override
    public Traveller update(Traveller traveller) {
        Optional<Traveller> result = Optional.ofNullable(traveller)
            .map(Traveller::getId)
            .flatMap(this::getById);

        if (result.isPresent()) {
            repository.save(traveller);
        }

        return null;
    }

    @Override
    public Traveller delete(String id) {
        Optional<Traveller> result = getById(id);
        if (result.isPresent()) {
            repository.deleteById(id);

            return result.get()
                .toBuilder()
                .id(null)
                .build();
        }
        return null;
    }

    @Override
    public List<Traveller> getAll() {
        return repository.findAll();
    }
}
