package com.web.atelier.Controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.atelier.Models.Client;
import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Technicien;
import com.web.atelier.Models.TypeComposant;
import com.web.atelier.Services.ClientService;
import com.web.atelier.Services.ComposantService;
import com.web.atelier.Services.ReparationService;
import com.web.atelier.Services.TechnicienService;
import com.web.atelier.Services.TypeComposantService;

import lombok.val;

@Controller
public class TechnicienController {
    @Autowired
    private TechnicienService technicienService;

    @Autowired
    private ReparationService reparationService;

    @GetMapping("/commissions")
    public String showAllComposants(@RequestParam(value="dateMin",required = false)String dateMin,@RequestParam(value = "dateMax",required = false) String dateMax ,Model model) {
        List<Technicien> allTechniciens = technicienService.getAllTechniciens();
        if(dateMax != null || dateMin!=null){
            allTechniciens = technicienService.getAllTechniciensByDate(dateMin, dateMax);
            for (Technicien technicien : allTechniciens) {
                technicien.setAllReparations(reparationService.getReparationsTechnicien(dateMin, dateMax,technicien.getId()));
            }
        }
        model.addAttribute("listTechniciens", allTechniciens);
        return "ListCommission";
    }

}
