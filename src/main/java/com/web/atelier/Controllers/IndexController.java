package com.web.atelier.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.atelier.Models.Modele;

@Controller
public class IndexController {
    @GetMapping("/")
    public String showAllModeles() {
        return "index";
    }
}
