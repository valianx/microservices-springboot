package Malian.inventoryservice.service;

import Malian.inventoryservice.dto.InventoryResponse;
import Malian.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> skucode){
        log.info("Wait Started");
     //   Thread.sleep(10000);
        log.info("Wait Ended");
         return inventoryRepository.findBySkuCodeIn(skucode)
                 .stream()
                 .map(inventory ->
             InventoryResponse.builder()
                     .isInStock(inventory.getQuantity() > 0)
                     .skucode(inventory.getSkuCode())
                     .build()
         ).collect(Collectors.toList());
    }
}
