package edu.mak.course.controller.rest;

import edu.mak.course.dao.model.Feedback;
import edu.mak.course.service.FeedbackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Tag(name = "Feedback ", description = "Feedback REST API")
@RestController
@RequestMapping("api/feedback")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FeedbackController {

    private final FeedbackService service;

    @Operation(summary = "Add a new feedback", description = "Create feedback object")
    @PostMapping("/create")
    public Feedback create(@RequestBody Feedback feedback) {
        return service.create(feedback);
    }

    @Operation(summary = "Get information about all feedback items")
    @RequestMapping("/get/all")
    public List<Feedback> getFeedback() {
        return service.getAll();
    }

    @Operation(summary = "Get feedback by ID", description = "Return a single feedback")
    @GetMapping("get/{id}")
    public Optional<Feedback> getById(@Parameter(name = "id", description = "ID of feedback to get", required = true)
                                      @PathVariable("id") String id) {
        return service.getById(id);
    }

    @Operation(summary = "Delete feedback by ID", description = "Delete a single feedback")
    @DeleteMapping("delete/{id}")
    public Feedback deleteById(@Parameter(name = "id", description = "ID of feedback to delete", required = true)
                               @PathVariable("id") String id) {
        return service.delete(id);
    }

    @Operation(summary = "Update feedback information", description = "Update feedback object")
    @PutMapping("/update")
    public Feedback update(@RequestBody Feedback feedback) {
        return service.update(feedback);
    }
}
