package com.web.atelier.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.atelier.Models.MvtStock;
import com.web.atelier.Models.Composant;
import com.web.atelier.Services.MvtStockService;
import com.web.atelier.Services.ComposantService;

@Controller
public class MvtStockController {

    @Autowired
    private MvtStockService mvtStockService;

    @Autowired
    private ComposantService composantService;

    @GetMapping("/mvt-stocks")
    public String showAllMvtStocks(Model model) {
        List<MvtStock> listMvtStocks = mvtStockService.getAllMvtStocks();
        model.addAttribute("listMvtStock", listMvtStocks);
        return "ListMvtStock";
    }

    @PostMapping("/mvt-stocks")
    public String addMvtStock(MvtStock mvtStock, @RequestParam("composantId") Integer composantId) {
        Composant composant = composantService.getComposantById(composantId);
        mvtStock.setComposant(composant);
        mvtStockService.addMvtStock(mvtStock);
        return "redirect:/mvt-stocks/form";
    }

    @GetMapping("/mvt-stocks/form")
    public String showFormMvtStock(Model model) {
        List<Composant> listComposants = composantService.getAllComposants();
        model.addAttribute("listComposant", listComposants);
        return "FormMvtStock";
    }
}
