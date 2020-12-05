package com.luv2code.springboot.cruddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.CounterDAO;
import com.luv2code.springboot.cruddemo.entity.Counter;

@Service
public class CounterServiceImpl implements CounterService {

	@Autowired
	private CounterDAO counterDAO;

	@Override
	@Transactional
	public Counter update() {
		return counterDAO.update();
	}

}
