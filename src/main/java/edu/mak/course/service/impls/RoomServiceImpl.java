package edu.mak.course.service.impls;

import edu.mak.course.dao.model.Room;
import edu.mak.course.dao.repository.RoomRepository;
import edu.mak.course.service.RoomService;
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
public class RoomServiceImpl implements RoomService {

    private final RoomRepository repository;

    @Override
    public Optional<Room> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public Room create(Room room) {
        return repository.save(room);
    }

    @Override
    public Room update(Room room) {
        Optional<Room> result = Optional.ofNullable(room)
            .map(Room::getId)
            .flatMap(this::getById);

        if (result.isPresent()) {
            repository.save(room);
        }

        return null;
    }

    @Override
    public Room delete(String id) {
        Optional<Room> result = getById(id);
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
    public List<Room> getAll() {
        return repository.findAll();
    }
}
