package edu.mak.course.service.impls;

import edu.mak.course.dao.model.BookingClient;
import edu.mak.course.dao.repository.BookingClientRepository;
import edu.mak.course.service.BookingClientService;
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
public class BookingClientServiceImpl implements BookingClientService {

    private final BookingClientRepository repository;

    @Override
    public BookingClient update(BookingClient bookingClient) {
        Optional<BookingClient> result = Optional.ofNullable(bookingClient)
            .map(BookingClient::getId)
            .flatMap(this::getById);

        if (result.isPresent()) {
            repository.save(bookingClient);
        }

        return null;
    }

    @Override
    public BookingClient create(BookingClient bookingClient) {
        return repository.save(bookingClient);
    }

    @Override
    public BookingClient delete(String id) {
        Optional<BookingClient> result = getById(id);
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
    public Optional<BookingClient> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<BookingClient> getAll() {
        return repository.findAll();
    }
}
