package com.example.vocabularyapp.controllers;

import com.example.vocabularyapp.models.Word;
import com.example.vocabularyapp.services.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class WordController {

    private final WordService wordService;
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    // 単語一覧ページ
    @GetMapping("/words")
    public String getAllWords(Model model) {
        List<Word> words = wordService.getAllWords();
        model.addAttribute("words", words);
        return "words";  // resources/templates/words.html を返す
    }

    // 単語詳細ページ
    @GetMapping("/words/{id}")
    public String getWordById(@PathVariable Integer id, Model model) {
        Word word = wordService.getWordById(id);
        model.addAttribute("word", word);
        return "word-detail";  // resources/templates/word-detail.html を返す
    }
}