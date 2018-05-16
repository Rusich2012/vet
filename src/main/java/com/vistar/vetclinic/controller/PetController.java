package com.vistar.vetclinic.controller;

import com.vistar.vetclinic.model.Pet;
import com.vistar.vetclinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetController {

    @Autowired
    PetService petService;

    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    public ModelAndView pets() {
        ModelAndView model = new ModelAndView("pets");
        model.addObject("listPet", petService.listPet());
        return model;
    }

    @RequestMapping(value = "/addpet", method = RequestMethod.GET)
    public ModelAndView addpet() {
        ModelAndView model = new ModelAndView("petform");
        model.addObject("petForm", new Pet());
        return model;
    }

    @RequestMapping(value = "/updatepet/{id}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") String id) {
        ModelAndView model = new ModelAndView("petform");
        model.addObject("petForm", petService.findePetById(id));
        return model;
    }

    @RequestMapping(value = "/savepet", method = RequestMethod.POST)
    public String save(@ModelAttribute("petForm") Pet pet) {
        if (pet.getId() != null && !pet.getId().trim().equals("")) {
            petService.update(pet);
        } else {
            petService.add(pet);
        }
        return "redirect:/pets";
    }

    @RequestMapping(value = "/deletepet/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") String id) {
        Pet pet = petService.findePetById(id);
        petService.delete(pet);
        return "redirect:/pets";
    }
}
