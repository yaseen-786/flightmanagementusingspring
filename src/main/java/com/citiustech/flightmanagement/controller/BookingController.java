package com.citiustech.flightmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.citiustech.flightmanagement.dao.CustomerDAO;
import com.citiustech.flightmanagement.dao.FlightDAO;
import com.citiustech.flightmanagement.modals.Booking;
import com.citiustech.flightmanagement.modals.Customer;
import com.citiustech.flightmanagement.modals.Flight;
import com.citiustech.flightmanagement.service.BookingService;

@Controller
public class BookingController {
	@Autowired
	private FlightDAO flightdao;
	@Autowired
	private CustomerDAO custdao;
	@Autowired
	private BookingService bookservice;

	@RequestMapping("book")
	public ModelAndView bookticket() {
		// return "book";
		ModelAndView m = new ModelAndView();
		m.addObject("source", flightdao.getsource());
		m.addObject("destination", flightdao.getdestination());
		m.setViewName("book");
		return m;

	}
	@RequestMapping("delete")
	public String deletecustomer(HttpServletRequest request) {
		// return "book";
		Cookie[] cook = request.getCookies();
		String username = "";
		for (Cookie tp : cook) {
			if ("username".equals(tp.getName())) {
				// System.out.println(tp.getValue());
				username = tp.getValue();
			}
		}
		Customer cust = (Customer) custdao.get(username);
		List<Integer> l = (List<Integer>) bookservice.getAllBookingId(cust.getCustid());
		for(int i : l){
			bookservice.delete(i);
			
		}
		custdao.delete(cust);
		return "login";

	}
	@RequestMapping("deleteflight")
	public ModelAndView deleteflight() {
		// return "book";
		ModelAndView m = new ModelAndView();
		m.addObject("flight", flightdao.getAll());
		//m.addObject("destination", flightdao.getdestination());
		m.setViewName("deleteflight");
		return m;

	}
	@RequestMapping("delete/{flightid}")
	public String deletingflight(@PathVariable("flightid") int id) {
		// return "book";
		ModelAndView m = new ModelAndView();
		bookservice.deleteFlight(id);
		flightdao.delete((Flight) flightdao.get(id));
		
		
		return "redirect:/adminmenu";

	}
	@RequestMapping("cancel")
	public ModelAndView cancelticket(HttpServletRequest request) {
		// return "book";
		ModelAndView m = new ModelAndView();
//		m.addObject("source", flightdao.getsource());
//		m.addObject("destination", flightdao.getdestination());
		Cookie[] cook = request.getCookies();
		String username = "";
		for (Cookie tp : cook) {
			if ("username".equals(tp.getName())) {
				// System.out.println(tp.getValue());
				username = tp.getValue();
			}
		}
		Customer cust = (Customer) custdao.get(username);
		m.addObject("booking",bookservice.getAllBookingId(cust.getCustid()));
		m.setViewName("cancelticket");
		return m;

	}
	@RequestMapping(path = "cancelticket",method=RequestMethod.POST)
	public ModelAndView cancelingticket(HttpServletRequest request) {
		// return "book";
		ModelAndView m = new ModelAndView();
		Integer id = Integer.parseInt(request.getParameter("source"));
		System.out.println(id);
		System.out.println("Inside canelticket");
		bookservice.delete(id);
		//m.addObject("source", flightdao.getsource());
		//m.addObject("destination", flightdao.getdestination());
		m.setViewName("customermenu");
		return m;

	}

	@RequestMapping(path = "bookingdetails", method = RequestMethod.POST)
	public ModelAndView showingFlight(@ModelAttribute Flight f) {
		// return "book";
		ModelAndView m = new ModelAndView();
		String s = f.getSource();
		String d = f.getDestination();
		int c = f.getCapacity();
		List<Flight> flightavailable = (List<Flight>) bookservice.showAvailableFlight(s, d, c);
		System.out.println(s + d + c);
		System.out.println(flightavailable);
		m.addObject("flight", flightavailable);
		m.addObject("count", c);
		// m.addObject("source",flightdao.getsource() );
		// m.addObject("destination",flightdao.getdestination());
		m.setViewName("availflight");
		return m;

	}

	@RequestMapping(path = "book/{flightid}/{count}")
	public ModelAndView bookingFlight(@PathVariable("flightid") int id, @PathVariable("count") int c,
			HttpServletRequest request) {
		// return "book";
		ModelAndView m = new ModelAndView();
		System.out.println("Inside booking flight method");
		// System.out.println(id+c);
		// System.out.println(flightavailable);
		// m.addObject("flight", flightavailable);
		// m.addObject("source",flightdao.getsource() );
		// m.addObject("destination",flightdao.getdestination());
		Cookie[] cook = request.getCookies();
		String username = "";
		for (Cookie tp : cook) {
			if ("username".equals(tp.getName())) {
				// System.out.println(tp.getValue());
				username = tp.getValue();
			}
		}
		Flight f = (Flight) flightdao.get(id);
		System.out.println(username);
		Booking b = (Booking) bookservice.bookflight(c, username, id);
		System.out.println(b);
		m.addObject("booking", b);
		m.addObject("flight", f);

		m.setViewName("ticket");
		return m;

	}

	@RequestMapping("history")
	public ModelAndView customerbookhistory(HttpServletRequest request) {
		// return "book";
		Cookie[] cook = request.getCookies();
		String username = "";
		for (Cookie tp : cook) {
			if ("username".equals(tp.getName())) {
				// System.out.println(tp.getValue());
				username = tp.getValue();
			}
		}
		Customer cust = (Customer) custdao.get(username);
		ArrayList<Booking> b = (ArrayList<Booking>) bookservice.getCustomerHistory(cust.getCustid());
		System.out.println(b);
		ModelAndView m = new ModelAndView();
		m.addObject("booking", b);
		m.setViewName("custbookhistory");
		return m;

	}

}
