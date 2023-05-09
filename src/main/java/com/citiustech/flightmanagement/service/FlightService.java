package com.citiustech.flightmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.flightmanagement.dao.FlightDAO;
import com.citiustech.flightmanagement.modals.Flight;

@Service
public class FlightService {
	
	@Autowired
	private FlightDAO flightdao;
	
	public int inserFlight(Flight flight){
		return flightdao.insert(flight);
	}
	
	public Flight getFlight(int id){
		return (Flight) flightdao.get(id);
	}
	
	public Flight getFlightByName(String flightname){
		return (Flight) flightdao.get(flightname);
	}
	public void updateFlight(Flight f){
	  flightdao.update(f);
	}
	

}
