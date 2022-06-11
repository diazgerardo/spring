package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Compania;
import com.example.demo.repository.CompaniaRepository;
import com.example.demo.service.CompaniaService;
import com.example.demo.service.dto.CompaniaResponseDto;

@Service
public class CompaniaServiceImpl implements CompaniaService {
	
	@Value("${page.size}")
	private Integer pageSize;
	@Autowired
	private CompaniaRepository companiaRepository;
	
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public List<CompaniaResponseDto> getCompanias(Integer pageNumber, Sort sortingOrder) {
		// default page size
		return getCompanias(pageNumber, pageSize, sortingOrder);
	}
		
	@Override
	public List<CompaniaResponseDto> getCompanias(Integer pageNumber, Integer pageSize, Sort sortingOrder) {
		
		List<CompaniaResponseDto> companias = new ArrayList<CompaniaResponseDto>();
		companiaRepository
		.findAll(
				// este es el paginador!
				PageRequest.of(pageNumber, pageSize, sortingOrder)
		)
		.forEach(compania 
			-> {
					companias.add(this.mapper.map(compania, CompaniaResponseDto.class));
			}
		);
		return companias;
	}

	@Override
	public void save(Compania c) {
		companiaRepository.save(c);	
	}

}
