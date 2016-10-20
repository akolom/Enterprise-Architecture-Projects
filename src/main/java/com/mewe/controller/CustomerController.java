package com.mewe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mewe.model.Customer;
import com.mewe.model.Student;
import com.mewe.service.CustomerService;



@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	  /*@GET
	  @Produces(MediaType.APPLICATION_JSON)*/
	
	@RequestMapping(value="/webservice", method=RequestMethod.GET)
	    public @ResponseBody List<Student> getResponse(){  
		
		System.out.println("Test");
	       //firstName,LastName,Age,Id
	        Student std1 = new Student("ik","test",22,2);
	        Student std2 = new Student("John","Vector",23,3);
	        Student std3 = new Student("iks","Roy",25,4);
	        List<Student> stuList = new ArrayList<Student>();
	        stuList.add(std1);
	        stuList.add(std2);
	        stuList.add(std3);
	        /*Gson gson = new GsonBuilder().create();
	        return gson.toJson(stuList);*/
	        return stuList;
	    }
	@RequestMapping(value="/webservicePage", method=RequestMethod.GET)
	public String webService(Model model){
		
		
		return "webservicePage";
	}
	
	
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
