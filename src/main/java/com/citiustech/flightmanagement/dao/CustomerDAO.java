package com.citiustech.flightmanagement.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.citiustech.flightmanagement.modals.Customer;


@Repository
public class CustomerDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int insert(Customer cust){
		
		Integer i = (Integer) hibernateTemplate.save(cust);
		return i;
		
	}
	@Transactional
	public void update(Customer cust){
		hibernateTemplate.update(cust);
		
	}
	public Object get(int id){
		return hibernateTemplate.get(Customer.class, id);
	}
 
	public Object getAll(){
		return hibernateTemplate.loadAll(Customer.class);
	}
	public Object get(String user){
		Customer cust = null;
		List<Customer> list = (List<Customer>) getAll();
		for(Customer c:list){
			if(c.getUsername().equals(user)){
				cust = c;
			}
			
		}
		return cust;
	}
	public int getId(String user){
		int i = 0;
		List<Customer> list = (List<Customer>) getAll();
		for(Customer c:list){
			if(c.getUsername().equals(user)){
				i = c.getCustid();
			}
			
		}
		return i;
	}
	
	@Transactional
	public void delete(Customer cust){
		hibernateTemplate.delete(cust);
	}
}
