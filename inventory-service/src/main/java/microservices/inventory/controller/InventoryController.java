package microservices.inventory.controller;

import lombok.RequiredArgsConstructor;
import microservices.inventory.dto.InventoryResponse;
import microservices.inventory.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam("sku-code") List<String> skuCodes){
        return inventoryService.isInStock(skuCodes);
    }

}
