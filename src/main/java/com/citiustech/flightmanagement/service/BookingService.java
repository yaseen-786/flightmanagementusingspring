package com.citiustech.flightmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.flightmanagement.dao.BookingDAO;
import com.citiustech.flightmanagement.dao.CustomerDAO;
import com.citiustech.flightmanagement.dao.FlightDAO;
import com.citiustech.flightmanagement.modals.Booking;
import com.citiustech.flightmanagement.modals.Customer;
import com.citiustech.flightmanagement.modals.Flight;

@Service
public class BookingService {
	@Autowired
	private CustomerDAO custdao;

	@Autowired
	private FlightDAO flightdao;

	@Autowired
	private BookingDAO bookdao;

	public Object showAvailableFlight(String s, String d ,int c){
		List<Flight> availableflight = new ArrayList<Flight>();
		List<Flight> flight = (List<Flight>) flightdao.getAll();
		for( Flight f:flight ){
			if(f.getSource().equals(s) && f.getDestination().equals(d) && f.getCapacity()>=c){
				availableflight.add(f);
			}
			
		}
		return availableflight;
		
	}
	public Object bookflight(int capacity,String username,int flightid){
		System.out.println("inside bookservice");
		Flight f = (Flight) flightdao.get(flightid);
		Customer c = (Customer) custdao.get(username);
		f.setCapacity(f.getCapacity()-capacity);
		flightdao.update(f);
		System.out.println(f);
		System.out.println(c);
		Booking b= new Booking();
		b.setBooking(f.getPrice()*capacity);
		b.setCustid(c.getCustid());
		b.setFlightid(flightid);
		b.setSeatno(f.getCapacity()+f.getFlightid()+c.getCustid());
		System.out.println(b);
		bookdao.insert(b);
		return b;
		
	}
	public Object getCustomerHistory(Integer custid) {
		return bookdao.get(custid);
		
	}
	public Object getAllBookingId(Integer custid) {
		// TODO Auto-generated method stub
		return bookdao.getbookid(custid);
		
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		System.out.println("delete");
		bookdao.delete((Booking)bookdao.get(id));
	}
	public void deleteFlight(int id) {
		// TODO Auto-generated method stub
		 bookdao.deleteflight(id);
		
	}
}
