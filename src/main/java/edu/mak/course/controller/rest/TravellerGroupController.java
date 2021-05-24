package edu.mak.course.controller.rest;

import edu.mak.course.dao.model.TravellerGroup;
import edu.mak.course.service.TravellerGroupService;
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
@Tag(name = "TravellerGroup ", description = "TravellerGroup REST API")
@RestController
@RequestMapping("api/travellerGroup")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TravellerGroupController {

    private final TravellerGroupService service;

    @Operation(summary = "Update traveller group information", description = "Update traveller group object")
    @PutMapping("/update")
    public TravellerGroup update(@RequestBody TravellerGroup travellerGroup) {
        return service.update(travellerGroup);
    }

    @Operation(summary = "Get traveller group", description = "Return a single traveller group")
    @GetMapping("get/{id}")
    public Optional<TravellerGroup> getById(@Parameter(name = "id", description = "ID of traveller group to get", required = true)
                                            @PathVariable("id") String id) {
        return service.getById(id);
    }

    @Operation(summary = "Delete traveller group by ID", description = "Delete a single traveller group")
    @DeleteMapping("delete/{id}")
    public TravellerGroup deleteById(@Parameter(name = "id", description = "ID of traveller group to delete", required = true)
                                     @PathVariable("id") String id) {
        return service.delete(id);
    }

    @Operation(summary = "Add a traveller group", description = "Create traveller group object")
    @PostMapping("/create")
    public TravellerGroup create(@RequestBody TravellerGroup travellerGroup) {
        return service.create(travellerGroup);
    }

    @Operation(summary = "Get information about all traveller groups")
    @RequestMapping("/get/all")
    public List<TravellerGroup> getTravellerGroups() {
        return service.getAll();
    }

}
