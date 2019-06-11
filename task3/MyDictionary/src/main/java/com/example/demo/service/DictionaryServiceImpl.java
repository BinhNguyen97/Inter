package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Dictionary;

import com.example.demo.repository.DictionaryRepository;

@Service
public class DictionaryServiceImpl implements DictionaryService {
	@Autowired
    private DictionaryRepository DictionaryRepository;

    @Override
    public Iterable<Dictionary> findAll() {
        return DictionaryRepository.findAll();
    }

    @Override
    public List<Dictionary> search(String q) {
        return DictionaryRepository.findByWordContaining(q);
    }

    @Override
    public Dictionary findOne(int id) {
        return  ((DictionaryServiceImpl) DictionaryRepository).findOne(id);
    }


    @Override
    public void save(Dictionary contact) {
    	DictionaryRepository.save(contact);
    }

    @Override
    public void delete(int id) {
    	DictionaryRepository.deleteById(id);
    }
}