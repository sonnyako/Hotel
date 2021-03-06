package edu.mak.course.controller.rest;

import edu.mak.course.dao.model.Hotel;
import edu.mak.course.dao.model.Room;
import edu.mak.course.service.HotelService;
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
@Tag(name = "Hotel ", description = "Hotel REST API")
@RestController
@RequestMapping("api/hotel")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HotelController {

    private final HotelService service;

    @Operation(summary = "Update hotel information", description = "Update hotel object")
    @PutMapping("/update")
    public Hotel update(@RequestBody Hotel hotel) {
        return service.update(hotel);
    }

    @Operation(summary = "Get hotel", description = "Return a single hotel")
    @GetMapping("get/{id}")
    public Optional<Hotel> getById(@Parameter(name = "id", description = "ID of hotel to get", required = true)
                                   @PathVariable("id") String id) {
        return service.getById(id);
    }

    @Operation(summary = "Delete hotel by ID", description = "Delete a single hotel")
    @DeleteMapping("delete/{id}")
    public Hotel deleteById(@Parameter(name = "id", description = "ID of hotel to delete", required = true)
                            @PathVariable("id") String id) {
        return service.delete(id);
    }

    @Operation(summary = "Add a hotel", description = "Create hotel object")
    @PostMapping("/create")
    public Hotel create(@RequestBody Hotel hotel) {
        return service.create(hotel);
    }

    @GetMapping("get/active/rooms")
    public List<Room> getActiveRooms() {
        return service.getActiveRooms();
    }

}
