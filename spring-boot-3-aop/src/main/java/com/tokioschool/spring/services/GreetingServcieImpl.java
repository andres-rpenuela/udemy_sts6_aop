package com.tokioschool.spring.services;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GreetingServcieImpl implements GreetingService {

	@Override
	public String sayHello(String person, String phrase) {
		String greeting = phrase + " " + person;
		log.info(greeting);
		return greeting;
	}

	@Override
	public void throwException() {
		throw new IllegalArgumentException("Invalid data");
	}

}
