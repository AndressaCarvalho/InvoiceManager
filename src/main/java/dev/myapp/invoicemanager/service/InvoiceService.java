package dev.myapp.invoicemanager.service;

import dev.myapp.invoicemanager.model.InvoiceModel;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService implements IInvoiceService {
    @Override
    public InvoiceModel create(String nameCustomer, String address, Double value, Integer numberOfPages) {
        return new InvoiceModel(nameCustomer, address, value, numberOfPages);
    }
}
