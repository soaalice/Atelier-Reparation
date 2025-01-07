package com.web.atelier.Services;

import java.time.LocalDate;
import java.sql.Date;
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
    public List<MvtStock> getMvtStockByDateRange(String minDateStr, String maxDateStr) {
        LocalDate minDate = (minDateStr != null && !minDateStr.isEmpty()) ? LocalDate.parse(minDateStr) : null;
        LocalDate maxDate = (maxDateStr != null && !maxDateStr.isEmpty()) ? LocalDate.parse(maxDateStr) : null;

        if (minDate == null && maxDate == null) {
            return mvtStockRepository.findAll(); // Retourner tous les mouvements si aucune date n'est fournie
        } else if (minDate != null && maxDate == null) {
            return mvtStockRepository.findByMinDate(minDate); // Requête avec minDate uniquement
        } else if (minDate == null && maxDate != null) {
            return mvtStockRepository.findByMaxDate(maxDate); // Requête avec maxDate uniquement
        } else {
            return mvtStockRepository.findByDateRange(minDate, maxDate); // Requête avec les deux paramètres
        }
    }

    public List<StockDto> getStockDtos() {
        return mvtStockRepository.findStockData();
    }

    public List<StockDto> getStockDtos(Date startDate, Date endDate, Integer typeComposantId) {
        return mvtStockRepository.findStockData(startDate.toString(), endDate.toString(), typeComposantId);
    }

}
