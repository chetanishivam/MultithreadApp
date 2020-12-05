package com.luv2code.springboot.cruddemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Counter;
import com.luv2code.springboot.cruddemo.service.CounterService;

@RestController
@RequestMapping("/api")
public class CounterRestController {

	@Autowired
	private CounterService counterService;

	@PutMapping("/count")
	public synchronized String updateCount() {
		Counter theCounter = counterService.update();
		if (theCounter == null) {
			throw new RuntimeException("Exception Occured");
		}
		return "Updated count value is: " + theCounter.getCount();
	}

}
