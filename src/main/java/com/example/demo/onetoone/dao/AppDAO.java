package com.example.demo.onetoone.dao;

import com.example.demo.onetoone.entity.Instructor;

public interface AppDAO {
	
	void save(Instructor instructor);
	
	Instructor findById(int id);
	
	void delete(int theId);

}
