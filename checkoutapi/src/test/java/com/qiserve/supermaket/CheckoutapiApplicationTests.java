package com.qiserve.supermaket;

import com.qiserve.supermaket.dto.CheckoutResponse;
import com.qiserve.supermaket.model.BasketItem;
import com.qiserve.supermaket.service.CheckoutService;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CheckoutapiApplicationTests {

    @Autowired
    private CheckoutService checkoutService;
    
    @Test
    public void testCalculateTotalCostWithBasketItems() {
        // Carrinho de compras
        var basketItems = List.of(
                new BasketItem("PWWe3w1SDU", 3), // 3 burgers
                new BasketItem("C8GDyLrHJb", 2), // 2 salads
                new BasketItem("4MB7UfpTQs", 1)  // 1 fries
        );
        
        // Executar o cálculo
        CheckoutResponse response = checkoutService.calculateTotalCost(basketItems);
        
        // Verificar os resultados esperados
        assertEquals(3095, response.getTotalCost()); // Total em centavos: $30.95
        assertEquals(1098, response.getTotalSavings()); // Economia em centavos: $10.98
        assertEquals(3095+1098, response.getTotalWithoutDiscount()); // Economia em centavos: $10.98
    }        

}
