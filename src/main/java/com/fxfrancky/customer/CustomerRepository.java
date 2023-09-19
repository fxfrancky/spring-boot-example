package com.fxfrancky.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Return true if a customer exist with that email
    boolean existsCustomerByEmail(String email);

    // Return true if a customer exist with that id
    boolean existsCustomerById(Long id);

}
