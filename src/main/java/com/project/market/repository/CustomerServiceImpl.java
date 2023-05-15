package com.project.market.repository;


import com.project.market.dto.CustomerDto;
import com.project.market.model.SignUpForm;
import com.project.market.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<SignUpForm> customers = customerRepository.findAll();
        return customers.stream()
                .map(customer -> new CustomerDto(customer.getId(), customer.getNames(), customer.getEmail(), customer.getPassword(), customer.getAddress()))
                .collect(Collectors.toList());
    }

    @Override
    public SignUpForm getCustomerById(Long id) {
        Optional<SignUpForm> optionalSignUpForm= customerRepository.findById(id);
       if(optionalSignUpForm.isEmpty()){
           throw new IllegalArgumentException("Invalid product id:" +id);
       }
       return optionalSignUpForm.get();
    }
}
