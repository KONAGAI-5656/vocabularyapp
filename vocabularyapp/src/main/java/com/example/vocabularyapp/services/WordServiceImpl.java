package com.example.vocabularyapp.services;

import com.example.vocabularyapp.models.Word;
import com.example.vocabularyapp.repositories.WordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;

    public WordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }

    @Override
    public Word getWordById(Integer id) {
        return wordRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Word not found with id: " + id));
    }
}