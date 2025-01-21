package com.web.atelier.Repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.web.atelier.Models.Technicien;

@Repository
public interface TechnicienRepository extends JpaRepository<Technicien, Integer> {

    @Query("SELECT t FROM Technicien t JOIN Reparation r ON t.id = r.technicien.id WHERE (:minDate IS NULL OR r.dateReparation >= CAST( :minDate AS DATE)) AND ( :maxDate IS NULL OR r.dateReparation <= CAST( :maxDate AS DATE))")
    List<Technicien> filterByDate(@Param("minDate") String minDate, @Param("maxDate") String maxDate);
}
