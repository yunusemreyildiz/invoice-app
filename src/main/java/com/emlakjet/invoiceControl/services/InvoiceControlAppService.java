package com.emlakjet.invoiceControl.services;


import com.emlakjet.invoiceControl.entities.ProductEntity;
import com.emlakjet.invoiceControl.models.CreateInvoiceRequest;

import java.util.List;


public interface InvoiceControlAppService {
    void saveProduct(CreateInvoiceRequest createInvoiceRequest);

    List<ProductEntity> getProductListByNameAndEmail(String userName, String email);

    List<ProductEntity> getAllProducts();

    List<ProductEntity> isApprove(boolean isApprove);

}
