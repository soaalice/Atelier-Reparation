package com.web.atelier.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.atelier.Dto.StockDto;
import com.web.atelier.Models.MvtStock;
import com.web.atelier.Repositories.MvtStockRepository;

@Service
public class MvtStockService {

    @Autowired
    private MvtStockRepository mvtStockRepository;

    // Ajouter un mouvement de stock
    public MvtStock addMvtStock(MvtStock mvtStock) {
        return mvtStockRepository.save(mvtStock);
    }

    // Obtenir tous les mouvements de stock
    public List<MvtStock> getAllMvtStocks() {
        return mvtStockRepository.findAll();
    }

    // Obtenir un mouvement de stock par son id
    public MvtStock getMvtStockById(int id) {
        return mvtStockRepository.findById(id).orElse(null);
    }

    // Rechercher les mouvements de stock par plage de dates
    public List<MvtStock> getMvtStockByDateRange(LocalDate minDate, LocalDate maxDate) {
        return mvtStockRepository.findByDateRange(minDate.toString(), maxDate.toString());
    }

//     public List<StockDto> getStockbyDateRange(Integer typeComposantId,LocalDate minDate, LocalDate maxDate) {
//         return mvtStockRepository.findStock(typeComposantId,minDate,maxDate);
//     }
}
