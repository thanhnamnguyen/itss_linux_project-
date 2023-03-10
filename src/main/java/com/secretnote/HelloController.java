package com.secretnote;

import com.secretnote.dao.User;
import com.secretnote.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    @Autowired
    UserRepo userRepo;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String sayHello() {
        return "home";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String readRegis(Model model) {
        User u = new User();
        model.addAttribute("user", u);
        model.addAttribute("dup", false);
        model.addAttribute("success", false);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addRegis(@ModelAttribute("user") User user, Model model) {

        try {

            userRepo.insert(user);
        } catch (DuplicateKeyException e) {

            model.addAttribute("user", user);
            model.addAttribute("dup", true);
            model.addAttribute("success", false);
            return "register";
        }
        model.addAttribute("user", user);
        model.addAttribute("dup", false);
        model.addAttribute("success", true);
        return "register";
    }

}
