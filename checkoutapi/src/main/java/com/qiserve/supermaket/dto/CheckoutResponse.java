package com.qiserve.supermaket.dto;

import com.qiserve.supermaket.model.AppliedPromotion;
import java.util.List;

/**
 *
 * @author Alvaro
 */
public class CheckoutResponse {

    /**
     * @return the totalWithoutDiscount
     */
    public int getTotalWithoutDiscount() {
        return totalWithoutDiscount;
    }

    /**
     * @param totalWithoutDiscount the totalWithoutDiscount to set
     */
    public void setTotalWithoutDiscount(int totalWithoutDiscount) {
        this.totalWithoutDiscount = totalWithoutDiscount;
    }

    public CheckoutResponse(
        final int totalCost, 
        final int totalSavings, 
        final int totalWithoutDiscount,
        final List<AppliedPromotion> appliedPromotions
    )
    {
        this.totalCost = totalCost;
        this.totalSavings = totalSavings;
        this.totalWithoutDiscount = totalWithoutDiscount;
        this.appliedPromotions = appliedPromotions;
        
    }
    /**
     * @return the totalCost
     */
    public int getTotalCost() {
        return totalCost;
    }

    /**
     * @param totalCost the totalCost to set
     */
    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * @return the totalSavings
     */
    public int getTotalSavings() {
        return totalSavings;
    }

    /**
     * @param totalSavings the totalSavings to set
     */
    public void setTotalSavings(int totalSavings) {
        this.totalSavings = totalSavings;
    }

    /**
     * @return the appliedPromotions
     */
    public List<AppliedPromotion> getAppliedPromotions() {
        return appliedPromotions;
    }

    /**
     * @param appliedPromotions the appliedPromotions to set
     */
    public void setAppliedPromotions(List<AppliedPromotion> appliedPromotions) {
        this.appliedPromotions = appliedPromotions;
    }
    private int totalCost; // em centavos
    private int totalSavings; // economia aplicada
    private int totalWithoutDiscount;
    private List<AppliedPromotion> appliedPromotions;    
}
