package microservices.order.controller;

import lombok.RequiredArgsConstructor;
import microservices.order.dto.OrderRequest;
import microservices.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
        return "Order placed successfully";
    }

    @GetMapping
    public String getAllOrders(){
        return "Order placed successfully";
    }
}
