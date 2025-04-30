package com.example.vocabularyapp.repositories;

import com.example.vocabularyapp.models.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepository extends JpaRepository<Example, Integer> {
}