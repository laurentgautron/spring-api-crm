package fr.m2i.apicrm.dto;

import fr.m2i.apicrm.model.Status;

public class OrderDTO {
    
    private String type;
    
    private String label;
    
    private CustomerDTO customer;
    
    private Integer numberOfDays;
    
    private Double unitPrice;
    
    private Integer totalExcludeTaxe;
    
    private Integer totalWithTaxe;
    
    private Status state;

    public OrderDTO(String type, String label, CustomerDTO customer, Integer numberOfDays, Double unitPrice, Integer totalExcludeTaxe, Integer totalWithTaxe, Status state) {
        this.type = type;
        this.label = label;
        this.numberOfDays = numberOfDays;
        this.unitPrice = unitPrice;
        this.totalExcludeTaxe = totalExcludeTaxe;
        this.totalWithTaxe = totalWithTaxe;
        this.state = state;
    }

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

    public Status getState() {
        return state;
    }

    public void setStatus(Status state) {
        this.state = state;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
    
}
