package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.domain.Compania;

public interface CompaniaRepository extends MongoRepository<Compania, String> {

}
