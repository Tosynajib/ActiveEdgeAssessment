package com.tosynCode.ActiveEdgeAssessment.execise3.controller;

import com.tosynCode.ActiveEdgeAssessment.execise3.dto.StockRequestDto;
import com.tosynCode.ActiveEdgeAssessment.execise3.model.Stock;
import com.tosynCode.ActiveEdgeAssessment.execise3.serviceImpl.StockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stock")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class StockController {
        private StockServiceImpl stockService;

        @Autowired
        public StockController(StockServiceImpl stockService) {
            this.stockService = stockService;
        }

        @GetMapping
        public ResponseEntity<Page<StockRequestDto>> getAllStocks(@RequestParam(defaultValue = "0") int pageNo,
                                                                  @RequestParam(defaultValue = "10") int pageSize) {
            Page<StockRequestDto> stockPage = stockService.getAllStocks(pageNo, pageSize);
            return new ResponseEntity<>(stockPage, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<StockRequestDto> getStockById(@PathVariable Long id) {
            StockRequestDto stockRequestDto = stockService.findById(id);
            return ResponseEntity.ok(stockRequestDto);
        }

        @PostMapping("/create")
        public ResponseEntity<String> createStock(@RequestBody StockRequestDto stockRequestDto) {
            String responseMessage = stockService.createStock(stockRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<Stock> updateStock(@PathVariable Long id,
                                                 @RequestBody StockRequestDto stockRequestDto) {
            Stock updatedStock = stockService.updateStock(id, stockRequestDto);
            return ResponseEntity.ok( updatedStock );
        }




}
