package com.example.demodeploy.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demodeploy.Entity.CarEntity;
import com.example.demodeploy.Service.carService;

@RestController
public class getCarsController 
{
	@Autowired
	private carService cs;
	
	@GetMapping("/getallcars")
	public ResponseEntity<?> getAllCars()
	{
		ArrayList<CarEntity> al=cs.getCars();
		if(al.isEmpty()==true)
		{
			return ResponseEntity.ok("No cars available");

		}
		return ResponseEntity.ok(al);
	}
}
