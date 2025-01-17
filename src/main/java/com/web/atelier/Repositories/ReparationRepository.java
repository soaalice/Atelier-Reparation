package com.web.atelier.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.atelier.Models.MvtStock;
import com.web.atelier.Models.Reparation;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReparationRepository extends JpaRepository<Reparation, Integer> {
        @Query("SELECT r FROM Reparation r WHERE r.id NOT IN (SELECT re.reparation.id FROM Retour re)")
        List<Reparation> findReturnableReparations();


        @Query("SELECT r FROM Reparation r WHERE r.dateReparation >= :minDate AND " +
            "(:modele IS NULL OR LOWER(r.ordinateur.modele.name) LIKE CONCAT('%', LOWER(:modele), '%'))")
        List<Reparation> findByMinDate(@Param("minDate") LocalDate minDate,@Param("modele") String modele);

        @Query("SELECT r FROM Reparation r WHERE r.dateReparation <= :maxDate AND " +
                "(:modele IS NULL OR LOWER(r.ordinateur.modele.name) LIKE CONCAT('%', LOWER(:modele), '%'))")
        List<Reparation> findByMaxDate(@Param("maxDate") LocalDate maxDate, @Param("modele") String modele);

        @Query("SELECT r FROM Reparation r WHERE " +
                "(:minDate IS NULL OR r.dateReparation >= :minDate )  AND " +
                "(:maxDate IS NULL OR r.dateReparation <= :maxDate )  AND " +
                "(:modele IS NULL OR LOWER(r.ordinateur.modele.name) LIKE CONCAT('%', LOWER(:modele), '%'))")
        List<Reparation> findByCriteria(
                @Param("minDate") LocalDate minDate,
                @Param("maxDate") LocalDate maxDate,
                @Param("modele") String modele);

        @Query("SELECT r FROM Reparation r JOIN ReparationDetails rd ON r.id=rd.reparation.id JOIN Tarif t ON t.id=rd.tarif.id JOIN Composant c ON c.id=t.composant.id JOIN TypeComposant tc ON tc.id=c.typeComposant.id WHERE tc.id=:typeComposantId")
        List<Reparation> findByTypeComposant(@Param("typeComposantId") Integer typeComposantId);

        @Query("SELECT r FROM Reparation r  WHERE r.id not IN (SELECT rt.reparation.id FROM Retour rt)")
        List<Reparation> findNotReturned();
}
