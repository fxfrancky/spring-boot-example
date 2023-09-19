package com.fxfrancky.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("list")
public class CustomerDAOImpl implements CustomerDAO{

    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer alex = new Customer(
                1l,
                "Alex",
                "alex@gmail.com",
                21);
        customers.add(alex);
        Customer jamila = new Customer(
                2l,
                "Jamila",
                "jamila@gmail.com",
                19);
        customers.add(jamila);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> findCustomerById(Long customerId) {
        return customers.stream()
                .filter(c -> c.getId().equals(customerId))
                .findFirst();
    }

    @Override
    public void insertCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        return customers.stream().anyMatch(c -> c.getEmail().equals(email));
    }

    @Override
    public boolean existsPersonWithId(Long id) {
        return customers.stream().anyMatch(c -> c.getId().equals(id));
    }

    @Override
    public void deleteCustumerById(Long id) {
        customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .ifPresent(o -> customers.remove(o));

    }

    @Override
    public void updateCustomer(Customer customer) {
        deleteCustumerById(customer.getId());
        insertCustomer(customer);
    }
}
