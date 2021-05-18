package edu.mak.course.controller.rest;

import edu.mak.course.dao.model.Traveller;
import edu.mak.course.service.TravellerService;
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
@Tag(name = "Traveller ", description = "Traveller REST API")
@RestController
@RequestMapping("api/travellers")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TravellerController {

    private final TravellerService service;

    @Operation(summary = "Get information about all travellers")
    @RequestMapping("/get/all")
    public List<Traveller> getTraveller() {
        return service.getAll();
    }

    @Operation(summary = "Get traveller by id", description = "Return a single traveller")
    @GetMapping("get/{id}")
    public Optional<Traveller> getById(@Parameter(name = "id", description = "ID of traveller to get", required = true, example = "1")
                                       @PathVariable("id") String id) {
        return service.getById(id);
    }

    @Operation(summary = "Delete traveller by ID", description = "Delete a single traveller")
    @DeleteMapping("delete/{id}")
    public Traveller deleteById(@Parameter(name = "id", description = "ID of traveller to delete", required = true, example = "1")
                                @PathVariable("id") String id) {
        return service.delete(id);
    }

    @Operation(summary = "Add a new traveller", description = "Create traveller object")
    @PostMapping("/create")
    public Traveller create(@RequestBody Traveller traveller) {
        return service.create(traveller);
    }

    @Operation(summary = "Update traveller information", description = "Traveller that needs to be updated")
    @PutMapping("/update")
    public Traveller update(@RequestBody Traveller traveller) {
        return service.update(traveller);
    }
}
