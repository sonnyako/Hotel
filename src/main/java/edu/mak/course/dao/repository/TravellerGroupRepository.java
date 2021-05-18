package edu.mak.course.dao.repository;

import edu.mak.course.dao.model.TravellerGroup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface TravellerGroupRepository extends MongoRepository<TravellerGroup, String> {
}
