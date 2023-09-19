package com.fxfrancky.customer;

import com.fxfrancky.exception.DuplicateResourceException;
import com.fxfrancky.exception.RequestValidationException;
import com.fxfrancky.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerService(@Qualifier("jdbc") CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> findAllCustomers(){
        return customerDAO.findAllCustomers();
    }

    public Customer findCustomerById(Long customerId){

         return customerDAO.findCustomerById(customerId)
                 .orElseThrow(
                         () -> new ResourceNotFoundException("customer with id [%s] was not found".formatted(customerId)));

    }

    public void addCustomer(CustomerRegistrationRequest customerRegistrationRequest){
        // check if email exists
        String email = customerRegistrationRequest.email();
        if (customerDAO.existsPersonWithEmail(customerRegistrationRequest.email())){
            throw new DuplicateResourceException(
                    "email already taken".formatted(email));
        }

        // Add
        Customer customer = new Customer(customerRegistrationRequest.name(),
                                         customerRegistrationRequest.email(),
                                         customerRegistrationRequest.age());
        customerDAO.insertCustomer(customer);
    }

    public void deleteCustomerById(Long customerId){
        if(!customerDAO.existsPersonWithId(customerId)){
            throw new ResourceNotFoundException(
               "customer with id [%s] was not found".formatted(customerId)
            );
        }

        customerDAO.deleteCustumerById(customerId);
    }

    public void updateCustomer(Long id, CustomerUpdateRequest updateRequest){

        Customer customer = findCustomerById(id);

        boolean changes = false;

        if(updateRequest.name() !=null && !updateRequest.name().equals(customer.getName())){
            customer.setName(updateRequest.name());
            changes =true;
        }

        if(updateRequest.email() !=null && !updateRequest.email().equals(customer.getEmail())){
            // Check if the edited email is not already in use
            if(customerDAO.existsPersonWithEmail(updateRequest.email())){
                throw new DuplicateResourceException(
                        "email already taken"
                );
            }
            customer.setEmail(updateRequest.email());
            changes =true;
        }

        if(updateRequest.age() !=null && !updateRequest.age().equals(customer.getAge())){
            customer.setAge(updateRequest.age());
            changes =true;
        }


        if (!changes){
            throw new RequestValidationException("no data changes found");
        }

        customerDAO.updateCustomer(customer);


    }
}
