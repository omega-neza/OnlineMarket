package com.project.market.service;

import com.project.market.dto.CustomerDto;
import com.project.market.model.SignUpForm;

import java.util.List;

public interface CustomerService {
     List<CustomerDto> getAllCustomers();
     SignUpForm getCustomerById(Long id);


}
