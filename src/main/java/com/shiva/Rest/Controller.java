package com.shiva.Rest;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	Service service;
	
	@PostMapping("/save")
	public Hospital saveDate(@RequestBody Hospital hospital) {
		return service.saveDate(hospital);
		
	}
	@GetMapping("/getall")
	public List<Hospital> getAll(){
		return service.getDetails();
		
	}
	
	
	@GetMapping("/hos/{id}")
	public Hospital gethospital(@PathVariable long id) {
		return service.gethospitalById(id);
		
	}
	@GetMapping("/hosp/{rating}")
	public List<Hospital> getHospital(@PathVariable Double rating) {
		return service.gethospitalByRating(rating);
	}
	@GetMapping("/h1/{location}/{rating}")
	public List<Hospital> getHospitals(@PathVariable String location,@PathVariable double rating){
		return service.getHospitalByLocationAndrating(location,rating);
		
	}
	@DeleteMapping("/h2/{id}")
	public boolean deleteById(@PathVariable Long id) {
		return service.deleteById(id);
		
	}
	@PutMapping("/h3/{id}")
	public Hospital updateById(@PathVariable Long id,@RequestBody Hospital newhosp) {
		return service.updateById(id,newhosp);
		
	}
	@PatchMapping("/h4/{id}")
	public  Hospital partialUpdateById(@PathVariable Long id,@RequestBody Map<String, Object> newBody) {
		return service.partialUpdateById(id,newBody);
		
	}
	
	
	

}
