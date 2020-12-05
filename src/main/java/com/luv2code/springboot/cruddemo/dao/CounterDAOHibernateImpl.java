package com.luv2code.springboot.cruddemo.dao;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Counter;

@Repository
public class CounterDAOHibernateImpl implements CounterDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Counter update() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Counter theCounter = currentSession.get(Counter.class, 1);
		theCounter.setCount(theCounter.getCount() + 1);
		currentSession.save(theCounter);
		return theCounter;
	}

}
