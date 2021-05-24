package edu.mak.course.service;

import edu.mak.course.dao.model.Feedback;

import java.util.List;
import java.util.Optional;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface FeedbackService {

    Feedback update(Feedback feedback);

    Feedback create(Feedback feedback);

    Feedback delete(String id);

    Optional<Feedback> getById(String id);

    List<Feedback> getAll();
}
