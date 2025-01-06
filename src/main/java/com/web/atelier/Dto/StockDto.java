package com.web.atelier.Dto;

import java.math.BigDecimal;

import lombok.Data;

@Data

public class StockDto {
    private Integer composantId;
    private String composantName;
    private Integer typeComposantId;
    private String typeComposantName;
    private BigDecimal recette;

    public StockDto(){
        
    }

    public StockDto(Integer composantId, String composantName, Integer typeComposantId, String typeComposantName,BigDecimal recette) {
        setComposantId(composantId);
        setComposantName(composantName);
        setTypeComposantId(typeComposantId);
        setTypeComposantName(typeComposantName);
        setRecette(recette);
    }

}
