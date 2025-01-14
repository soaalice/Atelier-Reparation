package com.web.atelier.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.atelier.Models.Reparation;
import com.web.atelier.Models.ReparationDetails;
import com.web.atelier.Models.Ordinateur;
import com.web.atelier.Services.ReparationService;
import com.web.atelier.Services.TarifService;
import com.web.atelier.Services.TypeComposantService;
import com.web.atelier.Services.TypeReparationService;
import com.web.atelier.Services.ComposantService;
import com.web.atelier.Services.OrdinateurService;
import com.web.atelier.Services.ReparationDetailsService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Controller
public class ReparationController {

    @Autowired
    private ReparationService reparationService;

    @Autowired
    private OrdinateurService ordinateurService;

    @Autowired
    private ReparationDetailsService reparationDetailsService;

    @Autowired
    private TarifService tarifService;

    @Autowired
    private TypeComposantService typeComposantService;

    @Autowired
    private TypeReparationService typeReparationService;

    @Autowired
    private ComposantService composantService;

    @GetMapping("/reparations")
    public String showAllReparations(@RequestParam(value="typeComposantId",required = false)Integer typeComposantId,Model model) {
        List<Reparation> list;
        if(typeComposantId!=null){
            list = reparationService.getReparationsByTypeComposant(typeComposantId);
        }
        else{
            list = reparationService.getAllReparations();
        }
        model.addAttribute("listTypeComposants",typeComposantService.getAllTypeComposants() );
        model.addAttribute("listReparations", list);
        return "ListReparation";
    }

    @PostMapping("/reparations")
    public String addReparation(Reparation reparation,
            @RequestParam("ordinateurId") Integer ordinateurId,
            @RequestParam("dateReparation") LocalDate dateReparation,@RequestParam("composants")List<Integer>composants,
            @RequestParam Map<String,String> typeReparations,
            Model model) {

        Ordinateur ordinateur = ordinateurService.getOrdinateurById(ordinateurId);
        reparation.setDateReparation(dateReparation);
        reparation.setOrdinateur(ordinateur);
        // reparation.setMontantTotal(montantTotal);
        // reparation.setDureeTotale(dureeTotale);


        reparationService.addReparation(reparation);
        for (Integer long1 : composants) {
            ReparationDetails temp = new ReparationDetails();
            temp.setTarif(tarifService.getTarifByComposantAndTypeReparation(composantService.getComposantById(long1),typeReparationService.getTypeReparationById(
            Integer.parseInt(typeReparations.get("reparation_" + long1)))));
            temp.setReparation(reparation);
            
            reparationDetailsService.addReparationDetails(temp);
        }
        
        
        return "redirect:reparations/form";
    }

    @GetMapping("/reparations/form")
    public String showFormReparation(Model model) {
        // model.addAttribute("listOrdinateurs", ordinateurService.getAllOrdinateurs());
        model.addAttribute("listOrdinateurs", ordinateurService.getAllRepairableOrdinateurs());
        return "FormReparation";
    }
    
    @GetMapping("/reparations/search")
    public String searchReparations(
            @RequestParam(value = "minDate", required = false) String minDateStr,
            @RequestParam(value = "maxDate", required = false) String maxDateStr,
            @RequestParam(value = "modele", required = false) String modele,
            Model model) {
        List<Reparation> reparations = reparationService.searchReparations(minDateStr, maxDateStr, modele);
        model.addAttribute("listReparations", reparations);

        return "ListReparation";
    }
}
