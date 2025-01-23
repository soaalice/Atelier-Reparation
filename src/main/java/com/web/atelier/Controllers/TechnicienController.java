package com.web.atelier.Controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.atelier.Models.Client;
import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Technicien;
import com.web.atelier.Services.TechnicienService;


@Controller
public class TechnicienController {
    @Autowired
    private TechnicienService technicienService;

    @GetMapping("/techniciens")
    public String showAllTechniciens(Model model) {
        List<Technicien> allTechniciens = technicienService.getAllTechniciens();
        model.addAttribute("listTechniciens", allTechniciens);
        return "ListTechnicien";
    }

}
