package com.web.atelier.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.atelier.Models.MvtStock;

@Repository
public interface MvtStockRepository extends JpaRepository<MvtStock, Integer> {

}
