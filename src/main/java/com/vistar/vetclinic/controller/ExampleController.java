package com.vistar.vetclinic.controller;

import com.vistar.vetclinic.model.Example;
import com.vistar.vetclinic.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ExampleController {

    @Autowired
    ExampleService exampleService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("example");
        model.addObject("listExample", exampleService.listExample());
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        ModelAndView model = new ModelAndView("form");
        model.addObject("exampleForm", new Example());
        return model;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") String id) {
        ModelAndView model = new ModelAndView("form");
        model.addObject("exampleForm", exampleService.findeExampleById(id));
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("exampleForm") Example example) {
        if (example.getId() != null && !example.getId().trim().equals("")) {
            exampleService.update(example);
        } else {
            exampleService.add(example);
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") String id) {
        Example example = exampleService.findeExampleById(id);
        exampleService.delete(example);
        return "redirect:/list";
    }
}
