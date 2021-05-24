package edu.mak.course.service;

import edu.mak.course.dao.model.Contract;

import java.util.List;
import java.util.Optional;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ContractService {

    Contract update(Contract contract);

    Contract create(Contract contract);

    Contract delete(String id);

    Optional<Contract> getById(String id);

    List<Contract> getAll();
}
