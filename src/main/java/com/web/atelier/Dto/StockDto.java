package com.web.atelier.Dto;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.ColumnResult;
import lombok.Data;

@Data
public class StockDto {
    private Integer composantId;
    private String composantName;
    private Integer typeComposantId;
    private String typeComposantName;
    private Long stock;

    public StockDto(Integer composantId, String composantName, Integer typeComposantId, String typeComposantName,
            Long stock) {
        this.composantId = composantId;
        this.composantName = composantName;
        this.typeComposantId = typeComposantId;
        this.typeComposantName = typeComposantName;
        this.stock = stock;
    }

    public StockDto(){}

}
