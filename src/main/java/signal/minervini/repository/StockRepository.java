package signal.minervini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import signal.minervini.entity.StockEntity;

import java.util.UUID;

@Component
public interface StockRepository extends JpaRepository<StockEntity, UUID> {
    @Modifying
    @Transactional
    @Query("DELETE FROM StockEntity WHERE ticker = :ticker")
    void deleteByTicker(@Param("ticker") String ticker);
}
