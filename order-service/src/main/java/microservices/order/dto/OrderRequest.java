package microservices.order.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class OrderRequest {

    private String orderNumber;
    private List<OrderLineItemsDto> orderLineItemsList;
}
