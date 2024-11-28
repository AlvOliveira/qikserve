package com.qiserve.supermaket.controller;

import com.qiserve.supermaket.dto.CheckoutResponse;
import com.qiserve.supermaket.model.BasketItem;
import com.qiserve.supermaket.model.CommandResultDefault;
import com.qiserve.supermaket.service.CheckoutService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alvaro
 */
@RestController
@RequestMapping("/api")
public class CheckoutController {

    private final CheckoutService checkoutService;
    private static final Logger log = LoggerFactory.getLogger(CheckoutController.class);

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/checkout")
    public ResponseEntity<CommandResultDefault> calculateTotal(@RequestBody List<BasketItem> basket) {
        
        try {
            
            CheckoutResponse response = checkoutService.calculateTotalCost(basket);
            return ResponseEntity.ok(new CommandResultDefault(true, "Realizado com sucesso.", response));
            
        } catch (RuntimeException e) {
            
            var error = "Erro ao processar o checkout";
            log.error(error, e);
            
            return ResponseEntity.ok(new CommandResultDefault(false, error, e.getMessage()));
        }
    }
}
