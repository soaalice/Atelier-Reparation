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
import com.web.atelier.Models.Reparation;
import com.web.atelier.Models.Technicien;
import com.web.atelier.Models.TypeComposant;
import com.web.atelier.Services.ClientService;
import com.web.atelier.Services.ComposantService;
import com.web.atelier.Services.ReparationService;
import com.web.atelier.Services.TechnicienService;
import com.web.atelier.Services.TypeComposantService;

import lombok.val;

@Controller
public class CommissionController {
    @Autowired
    private TechnicienService technicienService;

    @Autowired
    private ReparationService reparationService;

    @GetMapping("/commissions")
    public String showCommissions(@RequestParam(value = "dateMin", required = false) String dateMin,
            @RequestParam(value = "technicienId", required = false) Integer technicienId,
            @RequestParam(value = "dateMax", required = false) String dateMax, Model model) {
        List<Technicien> allTechniciens = technicienService.getAllTechniciens();
        if (technicienId != null) {
            allTechniciens.removeAll(allTechniciens);
            allTechniciens.add(technicienService.getTechnicienById(technicienId));
        }
        if (dateMax != null || dateMin != null) {
            for (Technicien technicien : allTechniciens) {
                technicien.setAllReparations(
                        reparationService.getReparationsTechnicien(dateMin, dateMax, technicien.getId())
                );
            }
        }
        Double [] sumReparation = new Double[allTechniciens.size()];
        Double [] sumCommission = new Double[allTechniciens.size()];
        for (Technicien technicien : allTechniciens) {
            double tempSumReparation = 0;
            double tempSumCommission = 0;
            for (Reparation reparation : technicien.getAllReparations()) {
                tempSumReparation += reparation.getMontantTotal();
                tempSumCommission += reparation.getCommission().getMontantTotal();
            }
            sumCommission[allTechniciens.indexOf(technicien)] = tempSumCommission;
            sumReparation[allTechniciens.indexOf(technicien)] = tempSumReparation;
        }
        model.addAttribute("sumReparation", sumReparation);
        model.addAttribute("sumCommission", sumCommission);
        model.addAttribute("listTechniciens", allTechniciens);
        model.addAttribute("allTechniciens", technicienService.getAllTechniciens());
        return "ListCommission";
    }

    @GetMapping("/commissions/etat")
    public String showCommissionsPerSexe(@RequestParam(value = "dateMin", required = false) String dateMin, Integer technicienId,
            @RequestParam(value = "dateMax", required = false) String dateMax, Model model) {
        List<Technicien> allTechniciens = technicienService.getAllTechniciens();
        List<Technicien> girlsTechniciens = technicienService.getAllTechniciens();
        girlsTechniciens.removeAll(girlsTechniciens);
        List<Technicien> boysTechniciens = technicienService.getAllTechniciens();
        boysTechniciens.removeAll(boysTechniciens);

        double sumBoys = 0;
        double sumGirls = 0;

        if (dateMax != null || dateMin != null) {
            for (Technicien technicien : allTechniciens) {
                technicien.setAllReparations(
                        reparationService.getReparationsTechnicien(dateMin, dateMax, technicien.getId()));
            }
        }
        for (Technicien technicien : allTechniciens) {
            if (technicien.getSexe().getId() == 1) {
                boysTechniciens.add(technicien);
            } else {
                girlsTechniciens.add(technicien);
            }
        }

        for (Technicien technicien : boysTechniciens) {
            for (Reparation reparation : technicien.getAllReparations()) {
                sumBoys += reparation.getCommission().getMontantTotal();
            }
        }

        for (Technicien technicien : girlsTechniciens) {
            for (Reparation reparation : technicien.getAllReparations()) {
                sumGirls += reparation.getCommission().getMontantTotal();
            }
        }

        Double[] sumReparationGirls = new Double[girlsTechniciens.size()];
        Double[] sumCommissionGirls = new Double[girlsTechniciens.size()];

        Double[] sumReparationBoys = new Double[boysTechniciens.size()];
        Double[] sumCommissionBoys = new Double[boysTechniciens.size()];
        for (Technicien technicien : girlsTechniciens) {
            double tempSumReparation = 0;
            double tempSumCommission = 0;
            for (Reparation reparation : technicien.getAllReparations()) {
                tempSumReparation += reparation.getMontantTotal();
                tempSumCommission += reparation.getCommission().getMontantTotal();
            }
            sumCommissionGirls[girlsTechniciens.indexOf(technicien)] = tempSumCommission;
            sumReparationGirls[girlsTechniciens.indexOf(technicien)] = tempSumReparation;
        }

        for (Technicien technicien : boysTechniciens) {
            double tempSumReparation = 0;
            double tempSumCommission = 0;
            for (Reparation reparation : technicien.getAllReparations()) {
                tempSumReparation += reparation.getMontantTotal();
                tempSumCommission += reparation.getCommission().getMontantTotal();
            }
            sumCommissionBoys[boysTechniciens.indexOf(technicien)] = tempSumCommission;
            sumReparationBoys[boysTechniciens.indexOf(technicien)] = tempSumReparation;
        }
        model.addAttribute("sumReparationGirls", sumReparationGirls);
        model.addAttribute("sumCommissionGirls", sumCommissionGirls);

        model.addAttribute("sumReparationBoys", sumReparationBoys);
        model.addAttribute("sumCommissionBoys", sumCommissionBoys);

        model.addAttribute("sumGirl", sumGirls);
        model.addAttribute("sumBoy", sumBoys);
        model.addAttribute("listBoysTechniciens", boysTechniciens);
        model.addAttribute("listGirlsTechniciens", girlsTechniciens);
        model.addAttribute("allTechniciens", technicienService.getAllTechniciens());
        return "ListCommissionSexe";
    }

}
