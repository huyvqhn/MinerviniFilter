package signal.minervini.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import signal.minervini.entity.StockEntity;
import signal.minervini.repository.StockRepository;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class MinerviniStocksController {

    public MinerviniStocksController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Autowired
    private StockRepository stockRepository;

    @GetMapping("/all")
    public List<StockEntity> getAllStocks() {
        return stockRepository.findAll();
    }

    @GetMapping("/sortList")
    public String getFilteredStock() {
        return "MBB, BID";
    }
}
