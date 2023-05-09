package com.citiustech.flightmanagement.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.citiustech.flightmanagement.modals.Flight;
@Repository
public class FlightDAO {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int insert(Flight flight) {

		Integer i = (Integer) hibernateTemplate.save(flight);
		return i;

	}

	@Transactional
	public void update(Flight flight) {
		hibernateTemplate.update(flight);

	}

	public Object get(int id) {
		return hibernateTemplate.get(Flight.class, id);
	}

	public Object getAll() {
		return hibernateTemplate.loadAll(Flight.class);
	}

	public Object get(String flightname) {
		Flight flight = null;
		List<Flight> list = (List<Flight>) getAll();
		for (Flight f : list) {
			if (f.getFlightname().equals(flightname.toUpperCase())) {
				flight = f;
			}

		}
		return flight;
	}
	public Object getsource(){
		Set<String> source = new HashSet();
		List<Flight> lis= (List<Flight>) getAll();
		for(Flight c: lis){
			source.add(c.getSource());
		}
	return source;	
	}
	
	public Object getdestination(){
		Set<String> destination = new HashSet();
		List<Flight> lis= (List<Flight>) getAll();
		for(Flight c: lis){
			destination.add(c.getDestination());
		}
		return destination;
	}
	

	@Transactional
	public void delete(Flight flight) {
		hibernateTemplate.delete(flight);
	}
}
