package com.tosynCode.ActiveEdgeAssessment.execise3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal currentPrice;
    private Timestamp createDate;
    private Timestamp lastUpdate;

    public Stock(String name, BigDecimal currentPrice, Timestamp createDate, Timestamp lastUpdate) {
        this.name = name;
        this.currentPrice = currentPrice;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
    }


}
