package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.example.demo.domain.Compania;
import com.example.demo.service.dto.CompaniaResponseDto;

public interface CompaniaService {
	
	public List<CompaniaResponseDto> getCompanias(Integer page, Integer pageSize, Sort sort);	
	public List<CompaniaResponseDto> getCompanias(Integer page, Sort sort);
	public void save(Compania c);

}
