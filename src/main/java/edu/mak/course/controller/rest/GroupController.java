package edu.mak.course.controller.rest;

import edu.mak.course.dao.model.Group;
import edu.mak.course.service.group.impls.GroupServiceImpl;
import edu.mak.course.service.organization.impls.OrganizationServiceImpl;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("api/groups")
public class GroupController {
    @Autowired
    GroupServiceImpl groupService;
    @Autowired
    OrganizationServiceImpl organizationService;

    @RequestMapping("/get/all")
    public List<Group> getGroups() {
        return groupService.getAll();
    }

    @GetMapping("get/{id}")
    public Group getById(@Parameter(name = "id", description = "ID of traveller to get", required = true, example = "1")
                         @PathVariable("id") String id) {
        return groupService.getById(id);
    }
}
