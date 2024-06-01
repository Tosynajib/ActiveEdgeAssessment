package com.tosynCode.ActiveEdgeAssessment.execise3.serviceImpl;

import com.tosynCode.ActiveEdgeAssessment.execise3.dto.StockRequestDto;
import com.tosynCode.ActiveEdgeAssessment.execise3.model.Stock;
import com.tosynCode.ActiveEdgeAssessment.execise3.repository.StockRepository;
import com.tosynCode.ActiveEdgeAssessment.execise3.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Slf4j
@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Page<StockRequestDto> getAllStocks(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Stock> stockRepositoryAll = stockRepository.findAll(pageable);
        return stockRepositoryAll.map(this::convertToDto);
    }

    private StockRequestDto convertToDto(Stock stock) {
        StockRequestDto stockRequestDto = new StockRequestDto();
        stockRequestDto.setName(stock.getName());
        stockRequestDto.setCurrentPrice(stock.getCurrentPrice());
        stockRequestDto.setCreateDate(stock.getCreateDate());
        stockRequestDto.setLastUpdate(stock.getLastUpdate());
        return stockRequestDto;
    }

    @Override
    public String createStock(StockRequestDto stockRequestDto) {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        Stock stock = Stock.builder()
                .name(stockRequestDto.getName())
                .currentPrice(stockRequestDto.getCurrentPrice())
                .createDate(currentTimestamp)
                .lastUpdate(currentTimestamp)
                .build();

        Stock savedStock = stockRepository.save(stock);

        log.info("Stock {} is saved", savedStock.getId());

        return "Stock created successfully";
    }

    @Override
    public Stock updateStock(Long id, StockRequestDto stockRequestDto) {
        Optional<Stock> stockOptional = stockRepository.findById(id);
        if (stockOptional.isEmpty()) {
            throw new StockNotFoundException("Stock not found with id: " + id);
        }
        if (stockRequestDto != null) {

            Stock stock = stockOptional.get();
            stock.setName( stockRequestDto.getName() );
            stock.setCurrentPrice( stockRequestDto.getCurrentPrice() );
            stock.setLastUpdate( new Timestamp( System.currentTimeMillis() ) );

            return stockRepository.save( stock );
        }

        return null;
    }

    @Override
    public StockRequestDto findById(Long id) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new StockNotFoundException("Stock not found with id: " + id));

        return convertToDto(stock);
    }


}
