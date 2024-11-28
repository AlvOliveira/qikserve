package com.qiserve.supermaket.service;

import com.qiserve.supermaket.dto.CheckoutResponse;
import com.qiserve.supermaket.model.AppliedPromotion;
import com.qiserve.supermaket.model.BasketItem;
import com.qiserve.supermaket.model.Product;
import com.qiserve.supermaket.model.Promotion;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    private final ProductService productService;

    public CheckoutService(ProductService productService) {
        this.productService = productService;
    }

    public CheckoutResponse calculateTotalCost(List<BasketItem> basketItems) {
        int total = 0;
        int totalSavings = 0;
        List<AppliedPromotion> appliedPromotions = new ArrayList<>();

        Map<String, Long> productCount = basketItems.stream()
                .collect(Collectors.groupingBy(BasketItem::getProductId, Collectors.summingLong(BasketItem::getQuantity)));

        for (Map.Entry<String, Long> entry : productCount.entrySet()) {
            String productId = entry.getKey();
            long count = entry.getValue();

            // Buscar produto usando o ProductService
            Product product = productService.getProductById(productId);

            int productTotal = 0;

            if (product.getPromotions() != null) {
                for (Promotion promotion : product.getPromotions()) {
                    switch (promotion.getType()) {
                        case "QTY_BASED_PRICE_OVERRIDE" -> {
                            int requiredQty = promotion.getRequired_qty();
                            int promoPrice = promotion.getPrice();

                            productTotal += (count / requiredQty) * promoPrice;
                            productTotal += (count % requiredQty) * product.getPrice();

                            totalSavings += (count / requiredQty) * (requiredQty * product.getPrice() - promoPrice);
                            appliedPromotions.add(new AppliedPromotion(promotion.getId(), "QTY_BASED_PRICE_OVERRIDE"));
                            count = 0;
                        }

                        case "BUY_X_GET_Y_FREE" -> {
                            int requiredQty = promotion.getRequired_qty();
                            int freeQty = promotion.getFree_qty();
                            long groups = count / (requiredQty + freeQty);
                            long remaining = count % (requiredQty + freeQty);
                            productTotal += (groups * requiredQty + remaining) * product.getPrice();
                            totalSavings += groups * freeQty * product.getPrice();
                            appliedPromotions.add(new AppliedPromotion(promotion.getId(), "BUY_X_GET_Y_FREE"));
                            count = 0;
                        }

                        case "FLAT_PERCENT" -> {
                            int discountPercent = promotion.getAmount();
                            double discountedPrice = product.getPrice() * (1 - discountPercent / 100.0);

                            productTotal += count * discountedPrice;
                            totalSavings += count * (product.getPrice() - discountedPrice);
                            appliedPromotions.add(new AppliedPromotion(promotion.getId(), "FLAT_PERCENT"));
                            count = 0;
                        }

                        default -> throw new UnsupportedOperationException("Promoção não suportada: " + promotion.getType());
                    }
                }
            }

            productTotal += count * product.getPrice();
            total += productTotal;
        }

        return new CheckoutResponse(total, totalSavings, total+totalSavings, appliedPromotions);
    }
}