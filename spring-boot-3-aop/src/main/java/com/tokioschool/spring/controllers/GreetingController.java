package com.tokioschool.spring.controllers;

import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokioschool.spring.services.GreetingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GreetingController {

	private final GreetingService greetingService;
	
	@GetMapping("/greeting")
	public ResponseEntity<?> greetingHandler(){
		String greeting = greetingService.sayHello("Andres", "Bienvenido al sistema");
		return ResponseEntity.ok(Collections.singletonMap("greeting", greeting));
	}
}
