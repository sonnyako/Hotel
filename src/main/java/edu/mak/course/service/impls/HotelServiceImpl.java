package edu.mak.course.service.impls;

import edu.mak.course.dao.model.Hotel;
import edu.mak.course.dao.repository.HotelRepository;
import edu.mak.course.service.HotelService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HotelServiceImpl implements HotelService {

    private final HotelRepository repository;

    @Override
    public Hotel create(Hotel hotel) {
        return repository.save(hotel);
    }

    @Override
    public Hotel update(Hotel hotel) {
        Optional<Hotel> result = Optional.ofNullable(hotel)
            .map(Hotel::getId)
            .flatMap(this::getById);

        if (result.isPresent()) {
            repository.save(hotel);
        }

        return null;
    }

    @Override
    public Optional<Hotel> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public Hotel delete(String id) {
        Optional<Hotel> result = getById(id);
        if (result.isPresent()) {
            repository.deleteById(id);

            return result.get()
                .toBuilder()
                .id(null)
                .build();
        }
        return null;
    }
}
