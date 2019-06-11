package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Dictionary;

public interface DictionaryRepository extends CrudRepository<Dictionary, Integer> {

    List<Dictionary> findByWordContaining(String q);

}