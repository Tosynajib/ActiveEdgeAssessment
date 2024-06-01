package com.tosynCode.ActiveEdgeAssessment.execise3.service;

import com.tosynCode.ActiveEdgeAssessment.execise3.dto.StockRequestDto;
import com.tosynCode.ActiveEdgeAssessment.execise3.model.Stock;
import org.springframework.data.domain.Page;

public interface StockService {

    Page<StockRequestDto> getAllStocks(int pageNo, int pageSize);

    String createStock(StockRequestDto stockRequestDto);

    Stock updateStock(Long id, StockRequestDto stockRequestDto);

    StockRequestDto findById(Long id);
}
