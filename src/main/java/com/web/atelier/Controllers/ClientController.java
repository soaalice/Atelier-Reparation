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
import com.web.atelier.Models.TypeComposant;
import com.web.atelier.Services.ClientService;
import com.web.atelier.Services.ComposantService;
import com.web.atelier.Services.TypeComposantService;

import lombok.val;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public String showAllComposants(@RequestParam(value="dateReparation",required=false)String dateReparation,Model model) {
        List<Client> listClients = clientService.getAllClients();
        if(dateReparation!=null && !dateReparation.isEmpty()){
            listClients = clientService.getClientsByDateReparation(dateReparation);
        }
        model.addAttribute("listClients", listClients);
        return "ListClient";
    }

    @PostMapping("/clients")
    public String addModele(Composant composant, @RequestParam("name") String name, @RequestParam("birthDate") String birthDate, @RequestParam("email") String email,
            RedirectAttributes redirectAttributes) {
        try {
            Client client = new Client();
            client.setFullName(name);
            client.setBirthDate(LocalDate.parse(birthDate));
            client.setEmail(email);
            clientService.addClient(client);

            redirectAttributes.addFlashAttribute("successMessage", "Client ajouté avec succès.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "Erreur: " + e.getMessage());
        }
        return "redirect:/clients/form";
    }

    @GetMapping("/clients/form")
    public String showFormComposant() {
        return "FormClient";
    }

    
}
