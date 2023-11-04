package dev.myapp.invoicemanager.model;

public class InvoiceModel {
    private String nameCustomer;
    private String address;
    private Double value;
    private Integer numberOfPages;

    public InvoiceModel() {
    }

    public InvoiceModel(String nameCustomer, String address, Double value, Integer numberOfPages) {
        this.nameCustomer = nameCustomer;
        this.address = address;
        this.value = value;
        this.numberOfPages = numberOfPages;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
