package com.web.atelier.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.atelier.Models.Reparation;
import com.web.atelier.Models.ReparationDetails;
import com.web.atelier.Models.Tarif;
import com.web.atelier.Models.Commission;
import com.web.atelier.Models.CommissionDetails;
import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Ordinateur;
import com.web.atelier.Services.ReparationService;
import com.web.atelier.Services.TarifService;
import com.web.atelier.Services.TechnicienService;
import com.web.atelier.Services.TypeComposantService;
import com.web.atelier.Services.TypeReparationService;
import com.web.atelier.Services.ClientService;
import com.web.atelier.Services.CommissionDetailsService;
import com.web.atelier.Services.CommissionService;
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
    private ComposantService composantService;

    @Autowired
    private ClientService clientService;


    @Autowired 
    private TypeReparationService typeReparationService;

    @Autowired
    private TechnicienService technicienService;

    @Autowired
    private CommissionService commissionService;

    @Autowired
    private CommissionDetailsService commissionDetailsService;


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
            @RequestParam("dateReparation") LocalDate dateReparation,
            @RequestParam("clientId") Integer clientId,
                @RequestParam("technicienId") Integer technicienId,
            @RequestParam("composants") List<Integer> composants,
            @RequestParam Map<String, String> typeReparations,
            Model model,
            RedirectAttributes redirectAttributes) {

            try {
                Ordinateur ordinateur = ordinateurService.getOrdinateurById(ordinateurId);
                reparation.setDateReparation(dateReparation);
                reparation.setOrdinateur(ordinateur);
                reparation.setClient(clientService.getClientById(clientId));
                reparation.setTechnicien(technicienService.getTechnicienById(technicienId));
                if(composants.size()==0){
                    throw new Exception("Vous devez selectionne au minimum un composant a reparer.");
                }
                double montantTotal = 0;
                reparation.setMontantTotal(0.0);
                reparation = reparationService.addReparation(reparation);
                for (Integer long1 : composants) {
                    Composant tempComposant = composantService.getComposantById(long1);
                    Composant newComposant = composantService.getSuperiorOrMinorComposant(tempComposant,
                    Integer.parseInt(typeReparations.get("reparation_" + long1)));
                    
                    if (newComposant == null) {
                        throw new Exception("Aucun composant n'est disponible pour ce type de réparation.");
                    }        
                    ReparationDetails temp = new ReparationDetails();
                    Tarif tempTarif = tarifService.getTarifByComposantAndTypeReparation(long1.longValue(),
                    typeReparationService.getTypeReparationById(
                        Integer.parseInt(typeReparations.get("reparation_" + long1))).getId().longValue(),dateReparation);
                        montantTotal+= tempTarif.getPrix();
                        temp.setTarif(tempTarif);
                        temp.setReparation(reparation);
                        temp.setNewComposant(newComposant);
                        
                        reparationDetailsService.addReparationDetails(temp);
                    CommissionDetails commissionDetails = new CommissionDetails();
                    commissionDetails.setMontant(tempTarif.getPrix()*0.05);
                    commissionDetails.setReparationDetails(temp);
                    commissionDetailsService.addCommissionDetails(commissionDetails);
                }
                Commission commission = new Commission();
                commission.setMontantTotal(montantTotal*0.05);
                commission.setReparation(reparation);

                reparation.setCommission(commission);

                commissionService.addCommission(commission);

                reparation.setMontantTotal(montantTotal);
                reparationService.addReparation(reparation);
                redirectAttributes.addFlashAttribute("successMessage", "Réparation ajoutée avec succès !");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", "Erreur: " + e.getMessage());
            }        
        return "redirect:reparations/form";
    }

        @GetMapping("/reparations/form")
        public String showFormReparation(Model model) {
            model.addAttribute("listClients", clientService.getAllClients());
        model.addAttribute("listTechniciens", technicienService
        .getAllTechniciens());
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
