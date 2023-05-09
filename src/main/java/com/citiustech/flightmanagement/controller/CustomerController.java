package com.citiustech.flightmanagement.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.citiustech.flightmanagement.modals.Customer;
import com.citiustech.flightmanagement.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService custservice;
	@RequestMapping("/home")
	public String homepage(){
		return "home";
	}
	
	@RequestMapping("/register")
	public String registration(){
		System.out.println();
		return "registeration";
	}
	@RequestMapping("/resetpassword")
	public String resetpassword(){
		
		return "resetpassword";
	}
	@RequestMapping(path="/resetuserpassword",method=RequestMethod.POST)
	public String resetuserpassword(@ModelAttribute Customer cust){
		String username = cust.getUsername();
		String email = cust.getEmail();
		String password = cust.getPassword();
		if(custservice.resetCustomerPassword(username, email,password)){
			return "login";
		}
		return "resetpassword";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		/*Cookie[] cook = request.getCookies();
		for(Cookie tp:cook){
			if("username".equals(tp.getName())){
				//System.out.println(tp.getValue());
			}
		}
		System.out.println();
*/		return "login";
	}
	
	@RequestMapping(path="/loginuser" ,method=RequestMethod.POST)
	public String login(@ModelAttribute Customer cust,HttpServletResponse response){
		String username = cust.getUsername();
		String password = cust.getPassword();
		System.out.println(username+password);
		if(custservice.validateCustomer(username, password)){
			System.out.println("valid customer");
			Cookie ck = new Cookie("username", username);
			ck.setMaxAge(60*24*60);
			response.addCookie(ck);
			return "customermenu";
		}
		else{
			return "login";
		}
		
		
	}
	@RequestMapping(path="/userregistration",method = RequestMethod.POST)
	public String handleForm(@ModelAttribute Customer cust){
		System.out.println(cust);
		
		custservice.insertCustomer(cust);
		return "login";
	}
	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest request){
		System.out.println("Inside update controller");
		Cookie[] cook = request.getCookies();
		String username="";
		for(Cookie tp:cook){
			if("username".equals(tp.getName())){
				//System.out.println(tp.getValue());
				username = tp.getValue();
			}
		}
		Customer cust = custservice.getCustomer(username);
		ModelAndView m = new ModelAndView();
		m.addObject("customer", cust);
		m.setViewName("updatecustomer");
		return m;
		
	}
	@RequestMapping(path="/updateuser",method = RequestMethod.POST)
	public String updateuser(@ModelAttribute Customer cust,HttpServletRequest request){
		Cookie[] cook = request.getCookies();
		String username="";
		for(Cookie tp:cook){
			if("username".equals(tp.getName())){
				//System.out.println(tp.getValue());
				username = tp.getValue();
			}
		}
		Customer c = custservice.getCustomer(username);
		System.out.println("inside updateuser");
		System.out.println(cust.getUsername());
		//String username = cust.getUsername();
		//Customer c = custservice.getCustomer(username);
		System.out.println(c);
		c.setEmail(cust.getEmail());
		c.setName(cust.getName());
		c.setPassword(cust.getPassword());
		c.setPhone(cust.getPhone());
		System.out.println(c);
		System.out.println(custservice.getCustomerId(username));
		cust.setCustid(custservice.getCustomerId(username));
		//Customer updatedcustomer = custservice.getCustomer(username);
		//System.out.println(updatedcustomer);
		//cust.setCustid(updatedcustomer.getCustid());
		custservice.updateCustomer(c);
		return "customermenu";
	}
	@RequestMapping("logout")
	public String logout(HttpServletResponse response){
		Cookie ck = new Cookie("username", null);
		ck.setMaxAge(0);
		response.addCookie(ck);
		return "home";
	}

}
