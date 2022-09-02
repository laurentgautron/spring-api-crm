package fr.m2i.apicrm.dto;

public class OrderDTO {
    
    private Long id;
    
    private String type;
    
    private String label;
    
    private CustomerDTO customer;
    
    private Integer numberOfDays;
    
    private Float unitPrice;
    
    private Float totalExcludeTaxe;
    
    private Float totalWithTaxe;
    
    private String state;

    public OrderDTO() {
    }

    public OrderDTO(Long id, String type, String label, CustomerDTO customer, Integer numberOfDays, Float unitPrice, Float totalExcludeTaxe, Float totalWithTaxe, String state) {
        this.id = id;
        this.type = type;
        this.label = label;
        this.customer = customer;
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

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Float getTotalExcludeTaxe() {
        return totalExcludeTaxe;
    }

    public void setTotalExcludeTaxe(Float totalExcludeTaxe) {
        this.totalExcludeTaxe = totalExcludeTaxe;
    }

    public Float getTotalWithTaxe() {
        return totalWithTaxe;
    }

    public void setTotalWithTaxe(Float totalWithTaxe) {
        this.totalWithTaxe = totalWithTaxe;
    }

    public String getState() {
        return state;
    }

    public void setStatus(String state) {
        this.state = state;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
    
}
