package com.qiserve.supermaket.model;

/**
 *
 * @author Alvaro
 */
public class Promotion {

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the required_qty
     */
    public int getRequired_qty() {
        return required_qty;
    }

    /**
     * @param required_qty the requiredQty to set
     */
    public void setRequired_qty(int required_qty) {
        this.required_qty = required_qty;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the free_qty
     */
    public int getFree_qty() {
        return free_qty;
    }

    /**
     * @param free_qty the freeQty to set
     */
    public void setFree_qty(int free_qty) {
        this.free_qty = free_qty;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
    private String id;
    private String type;
    private int required_qty;
    private int price;  
    private int free_qty;
    private int amount;
}
