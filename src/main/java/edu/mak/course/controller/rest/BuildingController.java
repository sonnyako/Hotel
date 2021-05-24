package edu.mak.course.controller.rest;

import edu.mak.course.dao.model.Building;
import edu.mak.course.service.BuildingService;
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
@Tag(name = "Building ", description = "Building REST API")
@RestController
@RequestMapping("api/building")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BuildingController {

    private final BuildingService service;

    @Operation(summary = "Add a new building", description = "Create building object")
    @PostMapping("/create")
    public Building create(@RequestBody Building building) {
        return service.create(building);
    }

    @Operation(summary = "Get information about all buildings")
    @RequestMapping("/get/all")
    public List<Building> getBuilding() {
        return service.getAll();
    }

    @Operation(summary = "Get building by ID", description = "Return a single building")
    @GetMapping("get/{id}")
    public Optional<Building> getById(@Parameter(name = "id", description = "ID of building to get", required = true)
                                      @PathVariable("id") String id) {
        return service.getById(id);
    }

    @Operation(summary = "Delete building by ID", description = "Delete a single building")
    @DeleteMapping("delete/{id}")
    public Building deleteById(@Parameter(name = "id", description = "ID of building to delete", required = true)
                               @PathVariable("id") String id) {
        return service.delete(id);
    }

    @Operation(summary = "Update building information", description = "Update building object")
    @PutMapping("/update")
    public Building update(@RequestBody Building building) {
        return service.update(building);
    }
}
