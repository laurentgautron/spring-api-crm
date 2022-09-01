//package fr.m2i.apicrm.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "order")
//public class Order {
//    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    
//    @Column(name = "type")
//    private String type;
//    
//    @Column(name = "label")
//    private String label;
//    
////    @JoinColumn(name = "customer_id")
////    @ManyToOne(fetch = FetchType.LAZY)
////    private Customer customer;
//    
//    @Column(name = "numberOfDays")
//    private Integer numberOfDays;
//    
//    @Column(name = "unitPrice")
//    private Double unitPrice;
//    
//    @Column(name = "totalExcludeTaxe")
//    private Integer totalExcludeTaxe;
//    
//    @Column(name = "totalWithTaxe")
//    private Integer totalWithTaxe;
//    
//    @Enumerated(EnumType.STRING)
//    @Column(name = "status")
//    private Status status;
//
//    public Order() {
//        
//    }
//
//    public Order(String type, String label, Integer numberOfDays, Double unitPrice, Integer totalExcludeTaxe, Integer totalWithTaxe, Status status) {
//        this.type = type;
//        this.label = label;
//        //this.customer = customer;
//        this.numberOfDays = numberOfDays;
//        this.unitPrice = unitPrice;
//        this.totalExcludeTaxe = totalExcludeTaxe;
//        this.totalWithTaxe = totalWithTaxe;
//        this.status = status;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getLabel() {
//        return label;
//    }
//
//    public void setLabel(String label) {
//        this.label = label;
//    }
//
////    public Customer getCustomer() {
////        return customer;
////    }
////
////    public void setCustomer(Customer customer) {
////        this.customer = customer;
////    }
//
//    public Integer getNumberOfDays() {
//        return numberOfDays;
//    }
//
//    public void setNumberOfDays(Integer numberOfDays) {
//        this.numberOfDays = numberOfDays;
//    }
//
//    public Double getUnitPrice() {
//        return unitPrice;
//    }
//
//    public void setUnitPrice(Double unitPrice) {
//        this.unitPrice = unitPrice;
//    }
//
//    public Integer getTotalExcludeTaxe() {
//        return totalExcludeTaxe;
//    }
//
//    public void setTotalExcludeTaxe(Integer totalExcludeTaxe) {
//        this.totalExcludeTaxe = totalExcludeTaxe;
//    }
//
//    public Integer getTotalWithTaxe() {
//        return totalWithTaxe;
//    }
//
//    public void setTotalWithTaxe(Integer totalWithTaxe) {
//        this.totalWithTaxe = totalWithTaxe;
//    }
//
//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }
//    
//    
//}
