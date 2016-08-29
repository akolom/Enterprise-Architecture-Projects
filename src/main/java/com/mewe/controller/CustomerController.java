package com.mewe.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mewe.model.Customer;
import com.mewe.service.CustomerService;



@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String allCustomers(Model model){
		model.addAttribute("customers", customerService.getAllCustomers());
		
		return "listCustomer";
	}
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String newCustomer(@ModelAttribute("newCustomer") Customer customer){
		
		return "addCustomer";
		
		
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveCustomer(@Valid @ModelAttribute("newCustomer") Customer customer, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "addCustomer";
		}
		customerService.createCustomer(customer);
		return "redirect:/list";
	}
	@RequestMapping(value="/remove/{id}", method=RequestMethod.GET)
	public String removeCustomer(@PathVariable("id") long id){
		customerService.removeCustomer(id);
		return "redirect:/list";
	}
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editCustomer(@PathVariable("id") long id, Model model){
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("editCustomerv1", customer);
		return "editCustomer";
		
		
		
		
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateCustomer(@Valid @ModelAttribute("editCustomerv1") Customer customer, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "editCustomer";
		}
		customerService.updateCustomer(customer);
		return "redirect:/list";
	}
	
	

}
