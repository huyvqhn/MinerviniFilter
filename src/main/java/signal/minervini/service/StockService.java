package signal.minervini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import signal.minervini.entity.StockEntity;
import signal.minervini.repository.StockRepository;

import java.util.List;

@Component
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<StockEntity> getAllStocks() {
        return stockRepository.findAll();
    }

    public boolean createStock(String ticker, String name) {
        StockEntity stockToCreate = new StockEntity();
        stockToCreate.setTicker(ticker);
        stockToCreate.setName(name);
        try {
            stockRepository.saveAndFlush(stockToCreate);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteStock(String ticker) {
        try {
            stockRepository.deleteByTicker(ticker);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}
