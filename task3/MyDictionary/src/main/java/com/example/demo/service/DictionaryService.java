package com.example.demo.service;
import java.util.List;
import com.example.demo.model.Dictionary;

public interface DictionaryService {
	Iterable<Dictionary> findAll();

    List<Dictionary> search(String q);

    Dictionary findOne(int id);

    void save(Dictionary contact);

    void delete(int id);
}