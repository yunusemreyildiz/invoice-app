package com.emlakjet.invoiceControl.resources;


import com.emlakjet.invoiceControl.entities.ProductEntity;
import com.emlakjet.invoiceControl.models.CreateInvoiceRequest;
import com.emlakjet.invoiceControl.services.InvoiceControlAppServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/confirmation")
@Data
public class InvoiceControlAppResource {
    @Autowired
    private InvoiceControlAppServiceImpl confirmationAppService;

    @PostMapping(path = "/saveProduct")
    public ResponseEntity<String> saveProduct(@RequestBody CreateInvoiceRequest request) {
        confirmationAppService.saveProduct(request);
        return new ResponseEntity("Succes", HttpStatus.OK);
    }

    @GetMapping(path = "/getList")
    public ResponseEntity<List<ProductEntity>> getList() {
        List<ProductEntity> productEntity = confirmationAppService.getAllProducts();
        return new ResponseEntity(productEntity, HttpStatus.OK);
    }

    @PostMapping(path = "/getListByUserAndMail")
    public ResponseEntity<List<ProductEntity>> getListByUserAndMail(@RequestParam("userName") String userName, @RequestParam("email") String email) {
        List<ProductEntity> productEntities = confirmationAppService.getProductListByNameAndEmail(userName, email);
        return new ResponseEntity(productEntities, HttpStatus.OK);
    }

    @PostMapping(path = "/isApprove")
    public ResponseEntity<List<ProductEntity>> isApprove(@RequestParam("isApprove") boolean isApprove) {
        List<ProductEntity> productEntities = confirmationAppService.isApprove(isApprove);
        return new ResponseEntity(productEntities, HttpStatus.OK);
    }

}
