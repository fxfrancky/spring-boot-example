package com.fxfrancky.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {
    List<Customer> findAllCustomers();
    Optional<Customer> findCustomerById(Long customerId);
    void insertCustomer(Customer customer);
    boolean existsPersonWithEmail(String email);
    boolean existsPersonWithId(Long id);
    void deleteCustumerById(Long id);
    void updateCustomer(Customer customer);
}
