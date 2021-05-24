package edu.mak.course.controller.rest;

import edu.mak.course.dao.model.BookingClient;
import edu.mak.course.service.BookingClientService;
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
@Tag(name = "Booking Client ", description = "Booking Client REST API")
@RestController
@RequestMapping("api/bookingClient")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookingClientController {

    private final BookingClientService service;

    @Operation(summary = "Add a new booking client", description = "Create booking client object")
    @PostMapping("/create")
    public BookingClient create(@RequestBody BookingClient bookingClient) {
        return service.create(bookingClient);
    }

    @Operation(summary = "Get information about all booking clients")
    @RequestMapping("/get/all")
    public List<BookingClient> getBookingClients() {
        return service.getAll();
    }

    @Operation(summary = "Get booking client by ID", description = "Return a single booking client")
    @GetMapping("get/{id}")
    public Optional<BookingClient> getById(@Parameter(name = "id", description = "ID of booking client to get", required = true)
                                           @PathVariable("id") String id) {
        return service.getById(id);
    }

    @Operation(summary = "Delete booking client by ID", description = "Delete a single booking client")
    @DeleteMapping("delete/{id}")
    public BookingClient deleteById(@Parameter(name = "id", description = "ID of booking client to delete", required = true)
                                    @PathVariable("id") String id) {
        return service.delete(id);
    }

    @Operation(summary = "Update booking client information", description = "Update booking client object")
    @PutMapping("/update")
    public BookingClient update(@RequestBody BookingClient bookingClient) {
        return service.update(bookingClient);
    }
}
