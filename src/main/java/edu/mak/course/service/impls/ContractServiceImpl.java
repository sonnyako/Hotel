package edu.mak.course.service.impls;

import edu.mak.course.dao.model.Contract;
import edu.mak.course.dao.repository.ContractRepository;
import edu.mak.course.service.ContractService;
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
public class ContractServiceImpl implements ContractService {

    private final ContractRepository repository;

    @Override
    public Contract update(Contract contract) {
        Optional<Contract> result = Optional.ofNullable(contract)
            .map(Contract::getId)
            .flatMap(this::getById);

        if (result.isPresent()) {
            repository.save(contract);
        }

        return null;
    }

    @Override
    public Contract create(Contract contract) {
        return repository.save(contract);
    }

    @Override
    public Contract delete(String id) {
        Optional<Contract> result = getById(id);
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
    public Optional<Contract> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Contract> getAll() {
        return repository.findAll();
    }
}
