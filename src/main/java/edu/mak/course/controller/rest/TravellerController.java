package edu.mak.course.controller.rest;

import edu.mak.course.dao.model.Traveller;
import edu.mak.course.service.traveller.impls.TravellerServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Tag(name = "Traveller ", description = "Traveller REST controller (CRUD)")
@RestController
@RequestMapping("api/travellers")
public class TravellerController {

    @Autowired
    TravellerServiceImpl service;

    @Operation(summary = "Get information about all travellers")
    @RequestMapping("/get/all")
    public List<Traveller> getTraveller() {
        return service.getAll();
    }

    @Operation(summary = "Get traveller by id", description = "Return a single traveller")
    @GetMapping("get/{id}")
    public Traveller getById(@Parameter(name = "id", description = "ID of traveller to get", required = true, example = "1")
                             @PathVariable("id") String id) {
        return service.getById(id);
    }

    @Operation(summary = "Delete traveller by id", description = "Delete a single traveller")
    @GetMapping("delete/{id}")
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
    @PostMapping("/update")
    public Traveller update(@RequestBody Traveller traveller) {
        return service.update(traveller);
    }

}