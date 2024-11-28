package com.qiserve.supermaket.model;

/**
 *
 * @author Alvaro
 */
public class AppliedPromotion {

    public AppliedPromotion(final String id, final String type){
        this.id = id;
        this.type = type;
    }
    
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
    private String id;
    private String type;
    
}
