package com.web.atelier.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.atelier.Models.MvtStock;

@Repository
public interface MvtStockRepository extends JpaRepository<MvtStock, Integer> {
    @Query("SELECT m FROM MvtStock m " +
            "WHERE (:minDate IS NULL OR m.dateMvt >= CAST(:minDate AS date)) " +
            "AND (:maxDate IS NULL OR m.dateMvt <= CAST(:maxDate AS date))")
    List<MvtStock> findByDateRange(@Param("minDate") String minDate, @Param("maxDate") String maxDate);

}
