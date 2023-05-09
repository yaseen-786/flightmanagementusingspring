package com.citiustech.flightmanagement.dao;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.citiustech.flightmanagement.modals.Booking;
import com.citiustech.flightmanagement.modals.Flight;

@Repository
public class BookingDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int insert(Booking book) {

		Integer i = (Integer) hibernateTemplate.save(book);
		return i;

	}

	@Transactional
	public void update(Booking book) {
		hibernateTemplate.update(book);

	}

	public Object get(int id) {
		return hibernateTemplate.get(Booking.class, id);
	}

	public Object getAll() {
		return hibernateTemplate.loadAll(Booking.class);
	}

	public Object get(Integer custid) {
		List<Booking> booking = new ArrayList();
		
		;
		List<Booking> list = (List<Booking>) getAll();
		for (Booking b : list) {
			if (b.getCustid()==custid) {
				booking.add(b);
			}

		}
		return booking;
	}
	public Object getbookid(Integer custid) {
		List<Integer> booking = new ArrayList<Integer>();
		List<Booking> list = (List<Booking>) getAll();
		for (Booking b : list) {
			if (b.getCustid()==custid) {
				booking.add(b.getBookid());
			}

		}
		return booking;
	}

	@Transactional
	public void delete(Booking book) {
		hibernateTemplate.delete(book);
	}
	
	@Transactional
	public void deleteflight(int id) {
		List<Booking> list = (List<Booking>) getAll();
		for(Booking b:list){
			if(b.getFlightid()==id){
				hibernateTemplate.delete(b);
			}
		}
		
	}

}
