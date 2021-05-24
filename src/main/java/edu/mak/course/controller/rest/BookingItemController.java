package edu.mak.course.controller.rest;

import edu.mak.course.dao.model.BookingItem;
import edu.mak.course.service.BookingItemService;
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
@Tag(name = "BookingItem ", description = "BookingItem REST API")
@RestController
@RequestMapping("api/bookingItem")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookingItemController {

    private final BookingItemService service;

    @Operation(summary = "Add a new booking item", description = "Create booking item object")
    @PostMapping("/create")
    public BookingItem create(@RequestBody BookingItem bookingItem) {
        return service.create(bookingItem);
    }

    @Operation(summary = "Get information about all booking items")
    @RequestMapping("/get/all")
    public List<BookingItem> getBookingItems() {
        return service.getAll();
    }

    @Operation(summary = "Get booking item by ID", description = "Return a single booking item")
    @GetMapping("get/{id}")
    public Optional<BookingItem> getById(@Parameter(name = "id", description = "ID of booking item to get", required = true)
                                         @PathVariable("id") String id) {
        return service.getById(id);
    }

    @Operation(summary = "Delete booking item by ID", description = "Delete a single booking item")
    @DeleteMapping("delete/{id}")
    public BookingItem deleteById(@Parameter(name = "id", description = "ID of booking item to delete", required = true)
                                  @PathVariable("id") String id) {
        return service.delete(id);
    }

    @Operation(summary = "Update booking item information", description = "Update booking item object")
    @PutMapping("/update")
    public BookingItem update(@RequestBody BookingItem bookingItem) {
        return service.update(bookingItem);
    }
}
