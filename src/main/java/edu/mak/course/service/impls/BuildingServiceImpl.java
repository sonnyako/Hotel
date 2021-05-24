package edu.mak.course.service.impls;

import edu.mak.course.dao.model.Building;
import edu.mak.course.dao.repository.BuildingRepository;
import edu.mak.course.service.BuildingService;
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
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository repository;

    @Override
    public Building update(Building building) {
        Optional<Building> result = Optional.ofNullable(building)
            .map(Building::getId)
            .flatMap(this::getById);

        if (result.isPresent()) {
            repository.save(building);
        }

        return null;
    }

    @Override
    public Building create(Building building) {
        return repository.save(building);
    }

    @Override
    public Building delete(String id) {
        Optional<Building> result = getById(id);
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
    public Optional<Building> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Building> getAll() {
        return repository.findAll();
    }
}
