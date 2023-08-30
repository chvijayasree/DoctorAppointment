package com.amdocs.dao;

import com.amdocs.model.Customer;

import java.sql.SQLException;

import com.amdocs.model.Appointment;
public interface CustomerDao {

	void insert(Customer user) throws SQLException;
	Customer findById(String email) ;

}

