package edu.mak.course.service.impls;

import edu.mak.course.dao.model.TravellerGroup;
import edu.mak.course.dao.repository.TravellerGroupRepository;
import edu.mak.course.service.TravellerGroupService;
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
public class TravellerGroupServiceImpl implements TravellerGroupService {

    private final TravellerGroupRepository repository;

    @Override
    public TravellerGroup update(TravellerGroup travellerGroup) {
        Optional<TravellerGroup> result = Optional.ofNullable(travellerGroup)
            .map(TravellerGroup::getId)
            .flatMap(this::getById);

        if (result.isPresent()) {
            repository.save(travellerGroup);
        }

        return null;
    }

    @Override
    public TravellerGroup create(TravellerGroup travellerGroup) {
        return repository.save(travellerGroup);
    }

    @Override
    public TravellerGroup delete(String id) {
        Optional<TravellerGroup> result = getById(id);
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
    public Optional<TravellerGroup> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<TravellerGroup> getAll() {
        return repository.findAll();
    }
}
