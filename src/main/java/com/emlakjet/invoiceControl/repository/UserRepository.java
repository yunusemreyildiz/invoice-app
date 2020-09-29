package com.emlakjet.invoiceControl.repository;

import com.emlakjet.invoiceControl.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAll();

    UserEntity save(UserEntity userEntity);

    @Query(value="SELECT COALESCE(SUM(t.amount),0) AS total FROM users u " +
            "INNER JOIN products t on t.user_id = u.user_id " +
            "where u.first_name=:firstName and u.email=:email",
    nativeQuery=true)
    Integer checkAmountRule(@Param("firstName") String firstName, @Param("email") String email);

}
