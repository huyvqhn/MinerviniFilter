package signal.minervini.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import signal.minervini.entity.StockEntity;
import signal.minervini.service.StockService;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/stocks")
public class MinerviniStocksController {

    @Autowired
    private StockService stockService;

    @GetMapping("/all")
    public List<StockEntity> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/sortList")
    public String getFilteredStock() {
        return "MBB, BID";
    }

    @GetMapping("/add")
    @ResponseBody
    public ResponseEntity<String> addNewStock(@RequestParam(required = true) String ticker) {
        if (!StringUtils.hasText(ticker)) {
            return ResponseEntity.badRequest().body("Invalid input for parameter tickerName");
        }
        try {
            stockService.createStock(ticker.toUpperCase(Locale.ROOT));
        } catch (Exception e) {
            return new ResponseEntity<>("Add new stock failed " + e.getMessage() + "//\n"
                    + e.getCause(), HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok("Add new stock successes");
    }

    @GetMapping("/remove")
    @ResponseBody
    public ResponseEntity<String> removeStock(@RequestParam(required = true) String ticker) {
        if (!StringUtils.hasText(ticker)) {
            return ResponseEntity.badRequest().body("Invalid input for parameter tickerName");
        }
        try {
            if (stockService.deleteStock(ticker.toUpperCase(Locale.ROOT))) {

                return ResponseEntity.ok("Remove stock successes " + ticker + " success");
            } else {
                return new ResponseEntity<>("Remove stock failed", HttpStatus.EXPECTATION_FAILED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Remove stock " + ticker + " failed " + e.getMessage() + "//\n"
                    + e.getCause(), HttpStatus.FORBIDDEN);
        }
    }


}
