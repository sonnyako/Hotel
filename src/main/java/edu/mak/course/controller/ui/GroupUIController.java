package edu.mak.course.controller.ui;

import edu.mak.course.dao.model.Group;
import edu.mak.course.dao.model.Organization;
import edu.mak.course.dao.organization.impls.OrganizationDAOImpl;
import edu.mak.course.form.GroupForm;
import edu.mak.course.service.group.impls.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@RequestMapping("/ui/groups")
@Controller
public class GroupUIController {
    @Autowired
    GroupServiceImpl service;

    @Autowired
    OrganizationDAOImpl organizationDAO;

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        List<Group> groups = service.getAll();
        model.addAttribute("groups", groups);
        return "groups-page";
    }

    @GetMapping("/create")
    public String create(Model model) {
        GroupForm groupForm = new GroupForm();
        groupForm.setName(" ");
        model.addAttribute("form", groupForm);
        List<String> organizations = organizationDAO.getAll().stream().map(Organization::getName).collect(Collectors.toList());
        model.addAttribute("organizations", organizations);
        return "group-create";
    }

    @PostMapping("/create")
    public String create(Model model, @ModelAttribute("form") GroupForm groupForm) {
        Group group = new Group();
        group.setName(groupForm.getName());
        Organization organization = organizationDAO.getByName(groupForm.getOrganization());
        group.setOrganization(organization);
        service.create(group);
        System.out.println(group);
        return "redirect:/ui/groups/get/all/";
    }

}
