package com.shopme.repository;

import com.shopme.common.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    Customer getCustomerByEmail(String email);
}
