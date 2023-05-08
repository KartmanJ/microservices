package microservices.inventory.service;


import lombok.RequiredArgsConstructor;
import microservices.inventory.dto.InventoryResponse;
import microservices.inventory.model.Inventory;
import microservices.inventory.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCodes){
        return inventoryRepository.findAllBySkuCodeIn(skuCodes).stream()
                .map(inventory ->
                    InventoryResponse
                            .builder()
                            .skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity() > 0)
                            .build())
                .collect(Collectors.toList());
    }
}
