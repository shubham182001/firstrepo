package com.example.demodeploy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demodeploy.Entity.CarEntity;
import com.example.demodeploy.Service.carService;

@RestController
public class addCarsController
{
	
	@PostMapping("/addcar")
	public ResponseEntity<String> addcar(@RequestBody CarEntity ce)
	{
		 if (ce == null) {
		        return ResponseEntity
		                .badRequest()
		                .body("Car data is missing");
		    }
		System.out.println("Adding: "+ce);
		carService.al.add(ce);
		
		  return ResponseEntity
		            .status(HttpStatus.CREATED)
		            .body("Car added successfully");
	}
}
