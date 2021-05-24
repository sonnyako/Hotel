package edu.mak.course.service.impls;

import edu.mak.course.dao.model.BookingItem;
import edu.mak.course.dao.repository.BookingItemRepository;
import edu.mak.course.service.BookingItemService;
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
public class BookingItemServiceImpl implements BookingItemService {

    private final BookingItemRepository repository;

    @Override
    public BookingItem update(BookingItem bookingItem) {
        Optional<BookingItem> result = Optional.ofNullable(bookingItem)
            .map(BookingItem::getId)
            .flatMap(this::getById);

        if (result.isPresent()) {
            repository.save(bookingItem);
        }

        return null;
    }

    @Override
    public BookingItem create(BookingItem bookingItem) {
        return repository.save(bookingItem);
    }

    @Override
    public BookingItem delete(String id) {
        Optional<BookingItem> result = getById(id);
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
    public Optional<BookingItem> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<BookingItem> getAll() {
        return repository.findAll();
    }
}
