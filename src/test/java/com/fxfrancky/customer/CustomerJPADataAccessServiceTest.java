package com.fxfrancky.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerJPADataAccessServiceTest {

    private CustomerJPADataAccessService underTest;
    private AutoCloseable autoCloseable;
    @Mock private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        // initialize the mock
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CustomerJPADataAccessService(customerRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void findAllCustomers() {
        // When
        underTest.findAllCustomers();

        //Then
        verify(customerRepository)
                .findAll();
    }

    @Test
    void findCustomerById() {
        // Given
        Long id = 1l;

        // When
        underTest.findCustomerById(id);

        // Then
        verify(customerRepository).findById(id);
    }

    @Test
    void insertCustomer() {

        // Given
        Customer customer = new Customer(
                1l, "Ali", "ali@gmail.com",2
        );

        // When
        underTest.insertCustomer(customer);

        // Then
        verify(customerRepository).save(customer);
    }

    @Test
    void existsPersonWithEmail() {

        // Given
        String email = "ali@gmail.com";

        // When
        underTest.existsPersonWithEmail(email);

        // Then
        verify(customerRepository).existsCustomerByEmail(email);

    }

    @Test
    void existsPersonWithId() {

        // Given
        Long id = 1L;

        // When
        underTest.existsPersonWithId(id);

        // Then
        verify(customerRepository).existsCustomerById(id);
    }

    @Test
    void deleteCustumerById() {

        // Given
        Long id = 1L;

        // When
        underTest.deleteCustumerById(id);

        // Then
        verify(customerRepository).deleteById(id);
    }

    @Test
    void updateCustomer() {
        // Given
        Customer customer = new Customer(
                1L, "Ali", "ali@gmail.com", 2
        );

        // When
        underTest.updateCustomer(customer);

        // Then
        verify(customerRepository).save(customer);
    }
}