package com.qiserve.supermaket.controller;

import com.qiserve.supermaket.model.CommandResultDefault;
import com.qiserve.supermaket.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alvaro
 */
@RestController
@RequestMapping("/api")
public class ProductController {
    
    private final ProductService productService;
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public CommandResultDefault getProducts() {
        
        try{
            
            return new CommandResultDefault(true, "Realizado com sucesso.", productService.getAllProducts());
            
        } catch (RuntimeException e) {
            
            var error = "Erro ao processar o get products";
            log.error(error, e);
            
            return new CommandResultDefault(false, error, e.getMessage());
        }
    }

    @GetMapping("/product/{id}")
    public CommandResultDefault getProduct(@PathVariable String id) {
        
        try{
            
        return new CommandResultDefault(true, "Realizado com sucesso.", productService.getProductById(id));
        
        } catch (RuntimeException e) {
            
            var error = "Erro ao processar o get product por id [%s]".formatted(id);
            log.error(error, e);            
            
            return new CommandResultDefault(false, error, e.getMessage());
        }
    }
}
