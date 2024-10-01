package com.example.constapi.service;

import com.example.constapi.model.Stock;
import com.example.constapi.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public Stock saveStock(Stock stock) {
      return stockRepository.save(stock);
    }

}
