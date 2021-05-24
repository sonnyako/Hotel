package edu.mak.course.service.impls;

import edu.mak.course.dao.model.Booking;
import edu.mak.course.dao.repository.BookingRepository;
import edu.mak.course.service.BookingService;
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
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repository;

    @Override
    public Booking update(Booking booking) {
        Optional<Booking> result = Optional.ofNullable(booking)
            .map(Booking::getId)
            .flatMap(this::getById);

        if (result.isPresent()) {
            repository.save(booking);
        }

        return null;
    }

    @Override
    public Booking create(Booking booking) {
        return repository.save(booking);
    }

    @Override
    public Booking delete(String id) {
        Optional<Booking> result = getById(id);
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
    public Optional<Booking> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Booking> getAll() {
        return repository.findAll();
    }
}
