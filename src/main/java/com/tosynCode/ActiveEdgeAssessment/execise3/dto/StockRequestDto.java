package com.tosynCode.ActiveEdgeAssessment.execise3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StockRequestDto {

        private String name;
        private BigDecimal currentPrice;
        private Timestamp createDate;
        private Timestamp lastUpdate;

}
