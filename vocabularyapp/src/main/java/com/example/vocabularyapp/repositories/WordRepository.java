package com.example.vocabularyapp.repositories;

import com.example.vocabularyapp.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Integer> {
}