package com.example.demo.onetoone.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.onetoone.entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {
	
	public EntityManager entityManager;
	
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Instructor instructor) {
		entityManager.persist(instructor);
	}

	@Override
	@Transactional
	public Instructor findById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Instructor.class, id);
	}

	@Override
	@Transactional
	public void delete(int theId) {
		//find the Instructor by id
		
		//delete the Instructor.
		
		Instructor instructor = entityManager.find(Instructor.class, theId);
		
		entityManager.remove(instructor);
		
	}

}
