package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Compania;
import com.example.demo.service.CompaniaService;
import com.example.demo.service.dto.CompaniaResponseDto;

@Controller
@RequestMapping("/companias")
public class CompaniaController {

	@Autowired
	private CompaniaService companiaService;
	
	
	@GetMapping("/")
	private ResponseEntity<?>getDtos(@RequestParam(required = true) Integer pageNbr, @RequestParam(required=false) Boolean reverseSort, @RequestParam(required=false) Integer pageSize){
		Sort sort = null;
		if(reverseSort==null||!reverseSort)
			sort = Sort.by("name");
		else 
			sort = Sort.by("name").descending();
		
		List<CompaniaResponseDto> companias = pageSize==null ? companiaService.getCompanias(pageNbr, sort) : companiaService.getCompanias(pageNbr, pageSize, sort);
		if(companias.isEmpty())
			return ResponseEntity.created(null).body("La pagina "+pageNbr+" no existe.");
		else
			return ResponseEntity.ok(companias);
	}
		
	@PostMapping("/")
	private ResponseEntity<?>saveEmployee(@RequestBody Compania compania){
		companiaService.save(compania);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
