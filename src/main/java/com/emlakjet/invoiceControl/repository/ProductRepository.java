package com.emlakjet.invoiceControl.repository;


import com.emlakjet.invoiceControl.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    ProductEntity save(ProductEntity productEntity);

    List<ProductEntity> findAll();

    @Query(value="SELECT * FROM products p " +
            "inner join users u on p.user_id = u.user_id " +
            "WHERE u.first_name=:firstName and u.email =:email",
            nativeQuery=true)
    List<ProductEntity> findByNameAndMail(@Param("firstName") String name, @Param("email") String mail);

    @Query(value="SELECT * FROM products p WHERE p.is_approve=:isApprove",
            nativeQuery=true)
    List<ProductEntity> isApprove(@Param("isApprove") boolean isApprove);

}
