package Malian.inventoryservice.repository;

import Malian.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Optional<Inventory> findBySkuCode(String skucode);
    List<Inventory> findBySkuCodeIn(List<String> skucodeList);

}
