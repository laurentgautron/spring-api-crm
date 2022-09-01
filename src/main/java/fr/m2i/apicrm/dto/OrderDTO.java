package fr.m2i.apicrm.dto;

import fr.m2i.apicrm.model.Status;

public class OrderDTO {
    
    private String type;
    
    private String label;
    
    private Integer numberOfDays;
    
    private Double unitPrice;
    
    private Integer totalExcludeTaxe;
    
    private Integer totalWithTaxe;
    
    private Status status;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getTotalExcludeTaxe() {
        return totalExcludeTaxe;
    }

    public void setTotalExcludeTaxe(Integer totalExcludeTaxe) {
        this.totalExcludeTaxe = totalExcludeTaxe;
    }

    public Integer getTotalWithTaxe() {
        return totalWithTaxe;
    }

    public void setTotalWithTaxe(Integer totalWithTaxe) {
        this.totalWithTaxe = totalWithTaxe;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    
    
}
