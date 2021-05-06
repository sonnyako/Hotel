package edu.mak.course.controller.rest;

import edu.mak.course.dao.model.Organization;
import edu.mak.course.service.organization.impls.OrganizationServiceImpl;
import io.swagger.v3.oas.annotations.Parameter;
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
@RestController
@RequestMapping("api/organizations")
public class OrganizationController {
    @Autowired
    OrganizationServiceImpl service;

    @RequestMapping("/get/all")
    public List<Organization> getOrganizations() {
        return service.getAll();
    }

    @GetMapping("get/{id}")
    public Organization getById(@Parameter(name = "id", description = "ID of traveller to get", required = true, example = "1")
                                @PathVariable("id") String id) {
        return service.getById(id);
    }

    @GetMapping("delete/{id}")
    public Organization deleteById(@Parameter(name = "id", description = "ID of traveller to delete", required = true, example = "1")
                                   @PathVariable("id") String id) {
        return service.delete(id);
    }

    @PostMapping("/create")
    public Organization create(@RequestBody Organization organization) {
        return service.create(organization);
    }

    @PostMapping("/update")
    public Organization update(@RequestBody Organization organization) {
        return service.update(organization);
    }

}
