package edu.mak.course.service.impls;

import edu.mak.course.dao.model.Organization;
import edu.mak.course.dao.repository.OrganizationRepository;
import edu.mak.course.service.OrganizationService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository repository;

    @Override
    public Optional<Organization> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public Organization create(Organization organization) {
        return repository.save(organization);
    }

    @Override
    public Organization update(Organization organization) {
        Optional<Organization> result = Optional.ofNullable(organization)
            .map(Organization::getId)
            .flatMap(this::getById);

        if (result.isPresent()) {
            repository.save(organization);
        }

        return null;
    }

    @Override
    public Organization delete(String id) {
        Optional<Organization> result = getById(id);
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
    public List<Organization> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Organization> getByName(String name) {
        return repository.findOne(Example.of(Organization.builder()
            .name(name)
            .build())
        );
    }
}
