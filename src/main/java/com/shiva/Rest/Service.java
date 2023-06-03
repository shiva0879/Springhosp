package com.shiva.Rest;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import org.springframework.util.ReflectionUtils;
@org.springframework.stereotype.Service
public class Service {
	List<Hospital> hospital1= new ArrayList<Hospital>(Arrays.asList(new Hospital(101,"sunrise","srnagar",4.6),
  		  new Hospital(201,"Rajahome","Ameerpet",3.9),
  		  new Hospital(301,"vijay hos","secundrabad",4.8)));
		

	public Hospital saveDate(Hospital hospital) {
		return hospital1.add(hospital)?hospital:null;


	}

	public List<Hospital> getDetails() {
		
		return hospital1;
	}



	public Hospital gethospitalById(Long id) {
		
		return hospital1.stream().filter(hosp->hosp.getId()==id).findAny().get();
	}

	public List<Hospital> gethospitalByRating(Double rating) {
		
		return hospital1.stream().filter(hos->hos.getRating()<=rating).collect(Collectors.toList());
	}

	public List<Hospital> getHospitalByLocationAndrating(String location, double rating) {
		
		return hospital1.stream().filter(h1->h1.getLocation().equalsIgnoreCase(location)&&h1.getRating()<=rating).collect(Collectors.toList());
	}

	public boolean deleteById(Long id) {
	
		Hospital h= hospital1.stream().filter(delete->delete.getId()==id).findAny().get();
		return hospital1.remove(h);
		
	}

	

	public Hospital updateById(Long id, Hospital newhosp) {
		Hospital exhos=hospital1.stream().filter(update->update.getId()==id).findAny().get();
		exhos.setId(newhosp.getId());
		exhos.setName(newhosp.getName());
		exhos.setLocation(newhosp.getLocation());
		exhos.setRating(newhosp.getRating());
		return exhos;
	}

	public Hospital partialUpdateById(Long id, Map<String, Object> newBody) {
		Hospital exhos=hospital1.stream().filter(update->update.getId()==id).findFirst().get();
		newBody.forEach((key,value)-> {
			Field field= ReflectionUtils.findField(Hospital.class,key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, exhos, value);
		});
		return exhos;
			
		}
	
	

	
	






}
