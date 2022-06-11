package com.example.demo.domain;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;


@Document(collection = "companias")
@Data
@AllArgsConstructor
public class Compania {
	
	@Id
	private String id;
	
	private String cuit;
	
	private String name;

	private Adress adress;
	


	public String companiaData() {
		return "Cuil: " + cuit + ", Company Name: " + name;
	}
}
