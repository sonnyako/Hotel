package edu.mak.course.service.impls;

import edu.mak.course.dao.model.Floor;
import edu.mak.course.dao.repository.FloorRepository;
import edu.mak.course.service.FloorService;
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
public class FloorServiceImpl implements FloorService {

    private final FloorRepository repository;

    @Override
    public Floor update(Floor floor) {
        Optional<Floor> result = Optional.ofNullable(floor)
            .map(Floor::getId)
            .flatMap(this::getById);

        if (result.isPresent()) {
            repository.save(floor);
        }

        return null;
    }

    @Override
    public Floor create(Floor floor) {
        return repository.save(floor);
    }

    @Override
    public Floor delete(String id) {
        Optional<Floor> result = getById(id);
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
    public Optional<Floor> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Floor> getAll() {
        return repository.findAll();
    }
}
