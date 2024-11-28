package com.qiserve.supermaket;

import com.qiserve.supermaket.service.ProductService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Alvaro
 */
@SpringBootTest
public class ProductApplicationTests {
    
    @Autowired
    private ProductService productService;
    
     @Test
    public void testGetProducts(){

        var products = productService.getAllProducts();

        assertNotNull(products);
        assertTrue(!products.isEmpty());
        
        products.forEach(prt -> {
            
            assertNotNull(prt.getId());
            assertNotNull(prt.getName());
            assertTrue(prt.getPrice() > 0);
            
        });
        
        products.forEach(prt -> {
            
            var prtDetais = productService.getProductById(prt.getId());
            
            assertNotNull(prtDetais.getId());
            assertNotNull(prtDetais.getName());
            assertNotNull(prtDetais.getName());
            
        });
        
    }


     @Test
    public void testGetProduct(){
        var product = productService.getProductById("PWWe3w1SDU");
        
        assertEquals("BUY_X_GET_Y_FREE", product.getPromotions().getFirst().getType());
    }
}
