package edu.mak.course.service.impls;

import edu.mak.course.dao.model.Hotel;
import edu.mak.course.dao.model.Room;
import edu.mak.course.dao.repository.HotelRepository;
import edu.mak.course.service.HotelService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HotelServiceImpl implements HotelService {

    private final MongoTemplate mongoTemplate;

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

    @Override
    public List<Room> getActiveRooms() {
        LookupOperation lookupOperation = LookupOperation.newLookup()
            .from("bookingClient")
            .localField("room")
            .foreignField("id").as("ordered room");
        AggregationResults<Room> result = mongoTemplate.aggregate(
            Aggregation.newAggregation
                (lookupOperation, Aggregation.match
                    (Criteria.where("bookingClient.checkOut").lt(Date.from(Instant.now())))),
            "rooms",
            Room.class);
        return result.getMappedResults();
    }
}
