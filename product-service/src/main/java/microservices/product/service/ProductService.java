package microservices.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservices.product.dto.ProductRequest;
import microservices.product.model.Product;
import microservices.product.repository.ProductRepository;
import microservices.product.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .name(productRequest.getName())
                .build();
        productRepository.save(product);
        log.info("Product {} is saved",product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> list = productRepository.findAll().stream()
                .map(this::mapToProductResponse)
                .collect(Collectors.toList());
        log.info("All products were received");
        return list;
    }

    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .price(product.getPrice())
                .description(product.getDescription())
                .name(product.getName())
                .build();
    }
}
