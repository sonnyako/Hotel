package edu.mak.course.controller.rest;

import edu.mak.course.dao.model.Floor;
import edu.mak.course.service.FloorService;
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
@Tag(name = "Floor ", description = "Floor REST API")
@RestController
@RequestMapping("api/floor")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FloorController {

    private final FloorService service;

    @Operation(summary = "Add a new floor", description = "Create floor object")
    @PostMapping("/create")
    public Floor create(@RequestBody Floor floor) {
        return service.create(floor);
    }

    @Operation(summary = "Get information about all floors")
    @RequestMapping("/get/all")
    public List<Floor> getFloor() {
        return service.getAll();
    }

    @Operation(summary = "Get floor by ID", description = "Return a single floor")
    @GetMapping("get/{id}")
    public Optional<Floor> getById(@Parameter(name = "id", description = "ID of floor to get", required = true)
                                   @PathVariable("id") String id) {
        return service.getById(id);
    }

    @Operation(summary = "Delete floor by ID", description = "Delete a single floor")
    @DeleteMapping("delete/{id}")
    public Floor deleteById(@Parameter(name = "id", description = "ID of floor to delete", required = true)
                            @PathVariable("id") String id) {
        return service.delete(id);
    }

    @Operation(summary = "Update floor information", description = "Update floor object")
    @PutMapping("/update")
    public Floor update(@RequestBody Floor floor) {
        return service.update(floor);
    }
}
