package com.tosynCode.ActiveEdgeAssessment;

import com.tosynCode.ActiveEdgeAssessment.execise3.model.Stock;
import com.tosynCode.ActiveEdgeAssessment.execise3.repository.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;

@SpringBootApplication
public class ActiveEdgeAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActiveEdgeAssessmentApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StockRepository stockRepository) {
		return args -> {
			stockRepository.saveAll( Arrays.asList(
					new Stock("Apple Inc.", new BigDecimal("123.45"), Timestamp.valueOf("2024-05-01 10:00:00"), Timestamp.valueOf("2024-05-01 12:00:00")),
					new Stock("Microsoft Corp.", new BigDecimal("234.56"), Timestamp.valueOf("2024-05-02 11:00:00"), Timestamp.valueOf("2024-05-02 13:00:00")),
					new Stock("Amazon.com Inc.", new BigDecimal("345.67"), Timestamp.valueOf("2024-05-03 12:00:00"), Timestamp.valueOf("2024-05-03 14:00:00")),
					new Stock("Tesla Inc.", new BigDecimal("456.78"), Timestamp.valueOf("2024-05-04 13:00:00"), Timestamp.valueOf("2024-05-04 15:00:00")),
					new Stock("Alphabet Inc.", new BigDecimal("567.89"), Timestamp.valueOf("2024-05-05 14:00:00"), Timestamp.valueOf("2024-05-05 16:00:00")),
					new Stock("Facebook Inc.", new BigDecimal("678.90"), Timestamp.valueOf("2024-05-06 15:00:00"), Timestamp.valueOf("2024-05-06 17:00:00")),
					new Stock("Berkshire Hathaway", new BigDecimal("789.01"), Timestamp.valueOf("2024-05-07 16:00:00"), Timestamp.valueOf("2024-05-07 18:00:00")),
					new Stock("Johnson & Johnson", new BigDecimal("890.12"), Timestamp.valueOf("2024-05-08 17:00:00"), Timestamp.valueOf("2024-05-08 19:00:00")),
					new Stock("Visa Inc.", new BigDecimal("901.23"), Timestamp.valueOf("2024-05-09 18:00:00"), Timestamp.valueOf("2024-05-09 20:00:00")),
					new Stock("Procter & Gamble", new BigDecimal("101.34"), Timestamp.valueOf("2024-05-10 19:00:00"), Timestamp.valueOf("2024-05-10 21:00:00")),
					new Stock("NVIDIA Corporation", new BigDecimal("212.45"), Timestamp.valueOf("2024-05-11 20:00:00"), Timestamp.valueOf("2024-05-11 22:00:00")),
					new Stock("PayPal Holdings", new BigDecimal("323.56"), Timestamp.valueOf("2024-05-12 21:00:00"), Timestamp.valueOf("2024-05-12 23:00:00")),
					new Stock("Netflix Inc.", new BigDecimal("434.67"), Timestamp.valueOf("2024-05-13 22:00:00"), Timestamp.valueOf("2024-05-14 00:00:00")),
					new Stock("Intel Corporation", new BigDecimal("545.78"), Timestamp.valueOf("2024-05-14 23:00:00"), Timestamp.valueOf("2024-05-15 01:00:00")),
					new Stock("Coca-Cola Company", new BigDecimal("656.89"), Timestamp.valueOf("2024-05-15 00:00:00"), Timestamp.valueOf("2024-05-15 02:00:00")),
					new Stock("PepsiCo Inc.", new BigDecimal("767.90"), Timestamp.valueOf("2024-05-16 01:00:00"), Timestamp.valueOf("2024-05-16 03:00:00")),
					new Stock("Walmart Inc.", new BigDecimal("878.01"), Timestamp.valueOf("2024-05-17 02:00:00"), Timestamp.valueOf("2024-05-17 04:00:00")),
					new Stock("Home Depot", new BigDecimal("989.12"), Timestamp.valueOf("2024-05-18 03:00:00"), Timestamp.valueOf("2024-05-18 05:00:00")),
					new Stock("Verizon Communications", new BigDecimal("109.23"), Timestamp.valueOf("2024-05-19 04:00:00"), Timestamp.valueOf("2024-05-19 06:00:00")),
					new Stock("Comcast Corporation", new BigDecimal("210.34"), Timestamp.valueOf("2024-05-20 05:00:00"), Timestamp.valueOf("2024-05-20 07:00:00"))
			));
		};
	}

}
