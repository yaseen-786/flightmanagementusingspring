package com.citiustech.flightmanagement.modals;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookid;
	private Integer custid;
	private Integer flightid;
	private Float booking;
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer seatno;
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(Integer bookid, Integer custid, Integer flightid, Float booking, Integer seatno) {
		super();
		this.bookid = bookid;
		this.custid = custid;
		this.flightid = flightid;
		this.booking = booking;
		this.seatno = seatno;
	}
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public Integer getCustid() {
		return custid;
	}
	public void setCustid(Integer custid) {
		this.custid = custid;
	}
	public Integer getFlightid() {
		return flightid;
	}
	public void setFlightid(Integer flightid) {
		this.flightid = flightid;
	}
	public Float getBooking() {
		return booking;
	}
	public void setBooking(Float booking) {
		this.booking = booking;
	}
	public Integer getSeatno() {
		return seatno;
	}
	public void setSeatno(Integer seatno) {
		this.seatno = seatno;
	}
	@Override
	public String toString() {
		return "Booking [bookid=" + bookid + ", custid=" + custid + ", flightid=" + flightid + ", booking=" + booking
				+ ", seatno=" + seatno + "]";
	}
	

}
