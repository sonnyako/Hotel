package edu.mak.course.dao.repository;

import edu.mak.course.dao.model.Contract;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ContractRepository extends MongoRepository<Contract, String>, QuerydslPredicateExecutor<Contract> {
}
