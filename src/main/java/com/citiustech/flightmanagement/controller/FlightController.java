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

import com.citiustech.flightmanagement.dao.BookingDAO;
import com.citiustech.flightmanagement.dao.CustomerDAO;
import com.citiustech.flightmanagement.dao.FlightDAO;
import com.citiustech.flightmanagement.modals.Customer;
import com.citiustech.flightmanagement.modals.Flight;
import com.citiustech.flightmanagement.service.FlightService;
@Controller
public class FlightController {
	
	@Autowired
	private FlightService flightservice;
	
	@Autowired
	private CustomerDAO custdao;
	
	@Autowired
	private FlightDAO flightdao;
	
	@Autowired
	private BookingDAO bookdao;
	
	@RequestMapping("admin")
	public String admin(){
		return "adminlogin";
	}
	
	@RequestMapping(path ="loginadmin",method=RequestMethod.POST)
	public String adminlogin(@ModelAttribute Customer c){
		if(c.getUsername().equals("admin") && c.getPassword().equals("admin123")){
			return "adminmenu";
			
		}
		else{
			return "adminlogin";
		}
	}
	@RequestMapping("addflight")
	public String insertFlight(){
		return "flightinsert";
		
	}
	@RequestMapping(path = "flightinsertion",method=RequestMethod.POST)
	public String flightinsertion(@ModelAttribute Flight f){
		System.out.println(f);
		System.out.println(flightservice.inserFlight(f));
		return "adminmenu";
		
	}
	@RequestMapping("updateflight")
	public String flightupdate(){
		
		return "updateid";
		
	}
	@RequestMapping(path = "flightupdation",method = RequestMethod.POST)
	public String flightupdationprocess(@ModelAttribute Flight f,HttpServletResponse response){
		int id = f.getFlightid();
		Flight fly = flightservice.getFlight(id);
		
		System.out.println(fly);
		if(fly.equals(null)){
			return "updateid";
		}
		else{
		//flightupdatingprocess( fly);
			String flightname = fly.getFlightname();
			Cookie ck = new Cookie("flightname", flightname);
			ck.setMaxAge(60*24*60);
			response.addCookie(ck);
		return "updateform";
		}
		
	}
	@RequestMapping("flightupdating")
	public String flightupdatingprocess(@ModelAttribute Flight f,HttpServletRequest request){
		Cookie[] cook = request.getCookies();
		String flightname="";
		for(Cookie tp:cook){
			if("flightname".equals(tp.getName())){
				//System.out.println(tp.getValue());
				flightname = tp.getValue();
			}
		}
		Flight f1 = flightservice.getFlightByName(flightname);
		
		System.out.println(f1);
		f1.setDate(f.getDate());
		f1.setSource(f.getSource());
		f1.setCapacity(f.getCapacity());
		f1.setDestination(f.getDestination());
		f1.setDuration(f.getDuration());
		f1.setPrice(f.getPrice());
		flightservice.updateFlight(f1);
		return "adminmenu";
		
	}
	@RequestMapping("showcustomer")
	public ModelAndView allCustomer(){
		ModelAndView m = new ModelAndView();
		m.addObject("customer", custdao.getAll());
		m.setViewName("allcustomer");
		return m;
	}
	@RequestMapping("showflight")
	public ModelAndView allflight(){
		ModelAndView m = new ModelAndView();
		m.addObject("flight", flightdao.getAll());
		m.setViewName("allflight");
		return m;
	}
	@RequestMapping("showbooking")
	public ModelAndView allbooking(){
		ModelAndView m = new ModelAndView();
		m.addObject("booking", bookdao.getAll());
		m.setViewName("allbooking");
		return m;
	}
	@RequestMapping("adminmenu")
	public String adminmenu(){
		
		return "adminmenu";
	}
	

}
