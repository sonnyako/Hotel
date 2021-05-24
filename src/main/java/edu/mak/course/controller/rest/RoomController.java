package edu.mak.course.controller.rest;

import edu.mak.course.dao.model.Room;
import edu.mak.course.service.RoomService;
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
@Tag(name = "Room", description = "Room REST API")
@RestController
@RequestMapping("api/room")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoomController {

    private final RoomService service;

    @Operation(summary = "Get information about all rooms")
    @RequestMapping("/get/all")
    public List<Room> getRooms() {
        return service.getAll();
    }

    @Operation(summary = "Get room by ID", description = "Return a single room")
    @GetMapping("get/{id}")
    public Optional<Room> getById(@Parameter(name = "id", description = "ID of room to get", required = true)
                                  @PathVariable("id") String id) {
        return service.getById(id);
    }

    @Operation(summary = "Delete room by ID", description = "Delete a single room")
    @DeleteMapping("delete/{id}")
    public Room deleteById(@Parameter(name = "id", description = "ID of room to delete", required = true)
                           @PathVariable("id") String id) {
        return service.delete(id);
    }

    @Operation(summary = "Add a new room", description = "Create room object")
    @PostMapping("/create")
    public Room create(@RequestBody Room room) {
        return service.create(room);
    }

    @Operation(summary = "Update room information", description = "Update room object")
    @PutMapping("/update")
    public Room update(@RequestBody Room room) {
        return service.update(room);
    }
}
