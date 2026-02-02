package com.example.demodeploy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demodeploy.Entity.CarEntity;
import com.example.demodeploy.Service.carService;

@RestController
public class addCarsController
{
	@Autowired
	private carService cs;
	
	@PostMapping("/addcar")
	public ResponseEntity<String> addcar(@RequestBody CarEntity ce)
	{
		 if (ce == null) {
		        return ResponseEntity
		                .badRequest()
		                .body("Car data is missing");
		    }
		System.out.println("Adding: "+ce);
		boolean flag=cs.addcar(ce);
		if(flag==true)
		{
			 return ResponseEntity
			            .status(HttpStatus.CREATED)
			            .body("Car added successfully");
		}
		else
		{
			 return ResponseEntity
			            .status(HttpStatus.BAD_REQUEST)
			            .body("Car adding failed");
		}
		
		 
	}
}
