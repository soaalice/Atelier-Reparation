package com.web.atelier.Controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.atelier.Models.MvtStock;
import com.web.atelier.Models.TypeComposant;
import com.web.atelier.Dto.StockDto;
import com.web.atelier.Models.Composant;
import com.web.atelier.Services.MvtStockService;
import com.web.atelier.Services.TypeComposantService;
import com.web.atelier.Services.ComposantService;

@Controller
public class MvtStockController {

    @Autowired
    private MvtStockService mvtStockService;

    @Autowired
    private ComposantService composantService;

    @Autowired
    private TypeComposantService typeComposantService;

    @GetMapping("/mvt-stocks")
    public String showAllMvtStocks(Model model) {
        List<TypeComposant> listTypeComposants = typeComposantService.getAllTypeComposants();
        List<MvtStock> listMvtStocks = mvtStockService.getAllMvtStocks();
        model.addAttribute("listTypeComposant", listTypeComposants);
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

    @GetMapping("/mvtStocks/search")
    public String searchMvtStock(@RequestParam("minDate") String minDateStr,
                                  @RequestParam( "maxDate") String maxDateStr,
                                  Model model) {

        List<MvtStock> mvtStocks = mvtStockService.getMvtStockByDateRange(minDateStr, maxDateStr);
        model.addAttribute("listMvtStock", mvtStocks);
        List<TypeComposant> listTypeComposants = typeComposantService.getAllTypeComposants();
        model.addAttribute("listTypeComposant", listTypeComposants);
        return "ListMvtStock"; // Vue pour afficher les résultats
    }

    // @GetMapping("/mvtStocks/etat")
    // public String etatStock(@RequestParam("typeComposantId") Integer typeComposantId,@RequestParam("minDate") String minDate,@RequestParam( "maxDate") String maxDate,Model model){
    //     LocalDate minDateParsed = (minDate != null && !minDate.isEmpty()) ? LocalDate.parse(minDate) : null;
    //     LocalDate maxDateParsed = (maxDate != null && !maxDate.isEmpty()) ? LocalDate.parse(maxDate) : null;

    //     List<StockDto> stocks = mvtStockService.getStockbyDateRange(typeComposantId, minDateParsed, maxDateParsed);
    //     model.addAttribute("stockList", stocks);
    //      return "EtatStock";
    // }
}
