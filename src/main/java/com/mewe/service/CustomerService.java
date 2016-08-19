package com.mewe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mewe.model.Customer;
import com.mewe.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public void createCustomer(Customer customer) {
		customerRepository.save(customer);

	}

	public void updateCustomer(Customer customer) {
		Customer cutomerToBeUpdated = customerRepository.findOne(customer.getId());
		System.out.println(customer.getId());
		cutomerToBeUpdated.setFirstName(customer.getFirstName());
		cutomerToBeUpdated.setLastName(customer.getLastName());
		cutomerToBeUpdated.setDateOfBirth(customer.getDateOfBirth());
		cutomerToBeUpdated.setPlaceOfBirth(customer.getPlaceOfBirth());
		cutomerToBeUpdated.setAddress(customer.getAddress());
	}

	public void removeCustomer(long id) {
		customerRepository.delete(id);
	}

	public Customer getCustomer(long id) {
		return customerRepository.findOne(id);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

}
