package com.example.demodeploy.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demodeploy.Entity.CarEntity;

@Service
public class carService 
{
	public static ArrayList<CarEntity> al=new ArrayList<CarEntity>();
	
	public Boolean addcar(CarEntity c)
	{
		boolean flag=al.add(c);
		if(flag==true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public ArrayList<CarEntity> getCars()
	{
		return al;
	}
	

}
