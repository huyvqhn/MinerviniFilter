package signal.minervini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import signal.minervini.entity.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity, Long> {
}
