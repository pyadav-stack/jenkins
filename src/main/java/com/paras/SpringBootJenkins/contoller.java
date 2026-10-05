package com.paras.SpringBootJenkins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class contoller {

    private final repo r;

    @Autowired
    contoller(repo r) {
        this.r = r;
    }

    @GetMapping("/")
    public String show(Model model) {

        List<model> users = r.findAll();

        model.addAttribute("users", users);

        return "index";
    }

    @PostMapping("/user")
    public String createuser(model m) {

        r.save(m);

        return "redirect:/";
    }

    @GetMapping("/users")
    @ResponseBody
    public List<model> getusers() {
        return r.findAll();
    }
}