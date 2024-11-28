package com.qiserve.supermaket.model;

/**
 *
 * @author Alvaro
 */
public class BasketItem {

    public BasketItem(final String productId, final int quantity){
        this.productId = productId;
        this.quantity = quantity;
        
    }
    /**
     * @return the productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    private String productId;
    private int quantity;    
}
