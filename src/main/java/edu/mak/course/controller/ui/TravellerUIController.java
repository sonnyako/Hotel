package edu.mak.course.controller.ui;

import edu.mak.course.dao.model.Traveller;
import edu.mak.course.form.TravellerForm;
import edu.mak.course.service.impls.TravellerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@RequestMapping("/ui/travellers")
@Controller
public class TravellerUIController {

    @Autowired
    TravellerServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        List<Traveller> travellers = service.getAll();
        model.addAttribute("travellers", travellers);
        return "travellers-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id) {
        service.delete(id);
        return "redirect:/ui/travellers/get/all/";
    }

    @GetMapping("/create")
    public String create(Model model) {
        TravellerForm travellerForm = new TravellerForm();
        model.addAttribute("form", travellerForm);
        return "traveller-create";
    }

    @PostMapping("/create")
    public String create(Model model, @ModelAttribute("travellerForm") TravellerForm travellerForm) {
        Traveller traveller = new Traveller();
        traveller.setName(travellerForm.getName());
        traveller.setBirthday(LocalDate.parse(travellerForm.getBirthday()));
        traveller.setPhoneNumber(travellerForm.getPhoneNumber());
        traveller.setDocumentNumber(travellerForm.getDocumentNumber());
        service.create(traveller);
        System.out.println(traveller);
        return "redirect:/ui/travellers/get/all/";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("travellerForm") TravellerForm travellerForm, @PathVariable("id") String id) {

        Traveller traveller = new Traveller();
        traveller.setId(travellerForm.getId());
        traveller.setName(travellerForm.getName());
        traveller.setBirthday(LocalDate.parse(travellerForm.getBirthday()));
        traveller.setPhoneNumber(travellerForm.getPhoneNumber());
        traveller.setDocumentNumber(travellerForm.getDocumentNumber());
        service.update(traveller);
        return "redirect:/ui/travellers/get/all/";
    }

}

