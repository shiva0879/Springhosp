package com.shiva.Rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
	private long id;
	private String name;
	private String location;
	private double rating;
	
	}


