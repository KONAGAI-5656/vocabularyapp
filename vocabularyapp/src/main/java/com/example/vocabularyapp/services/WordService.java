package com.example.vocabularyapp.services;

import com.example.vocabularyapp.models.Word;
import java.util.List;

public interface WordService {
    List<Word> getAllWords();
    Word getWordById(Integer id);
}