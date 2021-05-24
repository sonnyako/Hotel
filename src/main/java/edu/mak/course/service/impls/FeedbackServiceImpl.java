package edu.mak.course.service.impls;

import edu.mak.course.dao.model.Feedback;
import edu.mak.course.dao.repository.FeedbackRepository;
import edu.mak.course.service.FeedbackService;
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
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository repository;

    @Override
    public Feedback update(Feedback feedback) {
        Optional<Feedback> result = Optional.ofNullable(feedback)
            .map(Feedback::getId)
            .flatMap(this::getById);

        if (result.isPresent()) {
            repository.save(feedback);
        }

        return null;
    }

    @Override
    public Feedback create(Feedback feedback) {
        return repository.save(feedback);
    }

    @Override
    public Feedback delete(String id) {
        Optional<Feedback> result = getById(id);
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
    public Optional<Feedback> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Feedback> getAll() {
        return repository.findAll();
    }
}
