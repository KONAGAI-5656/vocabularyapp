package com.example.vocabularyapp.models;


import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

//@DataはLombokのやつで、GetterとかSetterとかたくさんやってくれます
//Entity that represents table
@Entity
@Table(name = "words")
@Data
public class Word {
    @Id//IDくっつけまーす
    private Integer wordid;
    private String headword;
    private String ipa;
    @Column(columnDefinition = "TEXT")
    private String jpnMeaning;
    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL)
    private List<Example> examples;
}