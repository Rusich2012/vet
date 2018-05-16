package com.vistar.vetclinic.controller;

import com.vistar.vetclinic.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("user");
        List<User> userList = loadUsers();
        model.addObject("usersList", userList);
        return model;
    }

    private List<User> loadUsers() {
        List<User> list = new ArrayList<User>();
        User user = null;

        for (int i=1; i<5; i++) {
            user = new User();
            user.setId(i);
            user.setName(String.format("name %d", i));
            list.add(user);
        }
        return list;
    }
}
