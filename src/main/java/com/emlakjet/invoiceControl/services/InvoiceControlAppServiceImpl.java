package com.emlakjet.invoiceControl.services;

import com.emlakjet.invoiceControl.entities.ProductEntity;
import com.emlakjet.invoiceControl.entities.UserEntity;
import com.emlakjet.invoiceControl.models.CreateInvoiceRequest;
import com.emlakjet.invoiceControl.repository.ProductRepository;
import com.emlakjet.invoiceControl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceControlAppServiceImpl implements InvoiceControlAppService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @Value("${amount_limit}")
    private Integer amountLimit;

    @Override
    public void saveProduct(CreateInvoiceRequest createInvoiceRequest) {
        boolean checkResult = checkRule(createInvoiceRequest);
        ProductEntity productEntity = requestToEntity(createInvoiceRequest, checkResult);
        saveEntity(productEntity);
    }

    @Override
    public List<ProductEntity> getProductListByNameAndEmail(String userName, String email) {
        return productRepository.findByNameAndMail(userName, email);
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductEntity> isApprove(boolean isApprove) {
        return productRepository.isApprove(isApprove);
    }


    private boolean checkRule(CreateInvoiceRequest createInvoiceRequest) {

        Integer total = userRepository.checkAmountRule(createInvoiceRequest.getFirstName(), createInvoiceRequest.getEmail());
        return total < amountLimit ? true : false;
    }


    public void saveEntity(ProductEntity productEntity) {
        productRepository.save(productEntity);

    }

    private ProductEntity requestToEntity(CreateInvoiceRequest createInvoiceRequest, boolean checkResult) {

        ProductEntity productEntity = new ProductEntity();
        UserEntity userEntity = new UserEntity();
        productEntity.setApprove(checkResult);

        productEntity.setUser(userEntity);
        productEntity.setProductName(createInvoiceRequest.getProductName());
        productEntity.setAmount(createInvoiceRequest.getAmount());
        productEntity.setBillNo(createInvoiceRequest.getBillNo());

        userEntity.setFirstName(createInvoiceRequest.getFirstName());
        userEntity.setLastName(createInvoiceRequest.getLastName());
        userEntity.setEmail(createInvoiceRequest.getEmail());

        return productEntity;

    }
}

