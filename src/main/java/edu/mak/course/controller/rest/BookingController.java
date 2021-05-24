package edu.mak.course.controller.rest;

import edu.mak.course.dao.model.Booking;
import edu.mak.course.service.BookingService;
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
@Tag(name = "Booking ", description = "Booking REST API")
@RestController
@RequestMapping("api/booking")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookingController {

    private final BookingService service;

    @Operation(summary = "Add a new booking", description = "Create booking object")
    @PostMapping("/create")
    public Booking create(@RequestBody Booking booking) {
        return service.create(booking);
    }

    @Operation(summary = "Get information about all booking")
    @RequestMapping("/get/all")
    public List<Booking> getBooking() {
        return service.getAll();
    }

    @Operation(summary = "Get booking by ID", description = "Return a single booking")
    @GetMapping("get/{id}")
    public Optional<Booking> getById(@Parameter(name = "id", description = "ID of booking to get", required = true)
                                     @PathVariable("id") String id) {
        return service.getById(id);
    }

    @Operation(summary = "Delete booking by ID", description = "Delete a single booking")
    @DeleteMapping("delete/{id}")
    public Booking deleteById(@Parameter(name = "id", description = "ID of booking to delete", required = true)
                              @PathVariable("id") String id) {
        return service.delete(id);
    }

    @Operation(summary = "Update booking information", description = "Update booking object")
    @PutMapping("/update")
    public Booking update(@RequestBody Booking booking) {
        return service.update(booking);
    }
}
