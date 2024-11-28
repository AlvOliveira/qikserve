package com.qiserve.supermaket.service;

import com.qiserve.supermaket.dto.ProductResponse;
import com.qiserve.supermaket.model.Product;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Alvaro
 */
@Service
public class ProductService {
    private final RestTemplate restTemplate;
    private final String baseUrl;

    public ProductService(RestTemplateBuilder builder, Environment env) {
        this.restTemplate = builder.build();
        // Recupera a variável de ambiente ou utiliza um valor padrão
        this.baseUrl = env.getProperty("API_SIMULATOR_URL", "http://localhost:8081");
    }

    public List<ProductResponse> getAllProducts() {
        String url = baseUrl + "/products";
        ResponseEntity<ProductResponse[]> response = restTemplate.getForEntity(url, ProductResponse[].class);
        return Arrays.asList(response.getBody());
    }

    public Product getProductById(String productId) {
        String url = baseUrl + "/products/" + productId;
        return restTemplate.getForObject(url, Product.class);
    }
}
