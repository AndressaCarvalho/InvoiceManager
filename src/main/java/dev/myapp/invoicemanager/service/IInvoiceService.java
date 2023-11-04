package dev.myapp.invoicemanager.service;

import dev.myapp.invoicemanager.model.InvoiceModel;

public interface IInvoiceService {
    InvoiceModel create(String nameCustomer, String address, Double value, Integer numberOfPages);
}
