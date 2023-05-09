package com.citiustech.flightmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.flightmanagement.dao.CustomerDAO;
import com.citiustech.flightmanagement.modals.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerDAO customerdao;
	
	public void insertCustomer(Customer c){
		customerdao.insert(c);
	}
	
	public boolean validateCustomer(String username,String password){
		boolean flag = false;
		if(customerdao.get(username).equals(null)){
			System.out.println("user dosn't exist");
			return flag;
		}
		else{
			Customer c = (Customer) customerdao.get(username);
			String pass = (c.getPassword());
			//String password1 = password;
			System.out.println(pass);
			System.out.println(password);
			if(pass.equals(password)){
				
				System.out.println("valid password");
				flag = true;
			}
			else{
				System.out.println("invalid password");
				flag = false;
			}
		}
		return flag;
		
	}
	public boolean resetCustomerPassword(String username,String email,String password){
		boolean flag = false;
		if(customerdao.get(username)==null){
			return flag;
		}
		else{
			Customer c = (Customer) customerdao.get(username);
			if(c.getEmail().equals(email)){
				flag = true;
				c.setPassword(password);
				customerdao.update(c);
			}
			else{
				flag = false;
			}
		}
		return flag;
		
	}
	public Customer getCustomer(String username){
		return (Customer) customerdao.get(username);
	}
	public int getCustomerId(String username){
		return (int) customerdao.getId(username);
	}
	public void updateCustomer(Customer cust){
		customerdao.update(cust);
	}

}
