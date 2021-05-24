package edu.mak.course.controller.rest;

import edu.mak.course.dao.model.Organization;
import edu.mak.course.service.OrganizationService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Tag(name = "Organization ", description = "Organization REST API")
@RestController
@RequestMapping("api/organizations")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrganizationController {

    private final OrganizationService service;

    @Operation(summary = "Get information about all organizations")
    @RequestMapping("/get/all")
    public List<Organization> getOrganizations() {
        return service.getAll();
    }

    @Operation(summary = "Get organization by ID", description = "Return a single organization")
    @GetMapping("get/{id}")
    public Optional<Organization> getById(@Parameter(name = "id", description = "ID of organization to get", required = true)
                                          @PathVariable("id") String id) {
        return service.getById(id);
    }

    @Operation(summary = "Get organization by name", description = "Return a single organization")
    @GetMapping("get/by/name")
    public Optional<Organization> getByName(@Parameter(name = "name", description = "Name of organization to get", required = true)
                                            @RequestParam("name") String name) {
        return service.getByName(name);
    }

    @Operation(summary = "Delete organization by ID", description = "Delete a single organization")
    @DeleteMapping("delete/{id}")
    public Organization deleteById(@Parameter(name = "id", description = "ID of organization to delete", required = true)
                                   @PathVariable("id") String id) {
        return service.delete(id);
    }

    @Operation(summary = "Add a new organization", description = "Create organization object")
    @PostMapping("/create")
    public Organization create(@RequestBody Organization organization) {
        return service.create(organization);
    }

    @Operation(summary = "Update organization information", description = "Update organization object")
    @PutMapping("/update")
    public Organization update(@RequestBody Organization organization) {
        return service.update(organization);
    }
}
