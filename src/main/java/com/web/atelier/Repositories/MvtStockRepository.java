package com.web.atelier.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.atelier.Dto.StockDto;
import com.web.atelier.Models.MvtStock;

@Repository
public interface MvtStockRepository extends JpaRepository<MvtStock, Integer> {
    @Query("SELECT m FROM MvtStock m WHERE m.dateMvt >= :minDate")
    List<MvtStock> findByMinDate(@Param("minDate") LocalDate minDate);

    @Query("SELECT m FROM MvtStock m WHERE m.dateMvt <= :maxDate")
    List<MvtStock> findByMaxDate(@Param("maxDate") LocalDate maxDate);

    @Query("SELECT m FROM MvtStock m " +
            "WHERE (:minDate IS NULL OR m.dateMvt >= :minDate) " +
            "AND (:maxDate IS NULL OR m.dateMvt <= :maxDate)")
    List<MvtStock> findByDateRange(@Param("minDate") LocalDate minDate, @Param("maxDate") LocalDate maxDate);

    
    // @Query("SELECT new com.web.atelier.Dto.StockDto(c.id, c.name, tc.id, tc.name, " +
    //        "COALESCE(SUM(ms.entree - ms.sortie),0)) " +
    //        "FROM MvtStock ms " +
    //        "JOIN ms.composant c " +
    //        "LEFT JOIN c.typeComposant tc  " +
    //        "WHERE (:typeComposantId IS NULL OR tc.id = :typeComposantId) " +
    //        "AND (:startDate IS NULL OR :endDate IS NULL OR ms.dateMvt BETWEEN :startDate AND :endDate) " +
    //        "GROUP BY c.id, tc.id")
    // List<StockDto> findStock(@Param("typeComposantId") Integer typeComposantId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
