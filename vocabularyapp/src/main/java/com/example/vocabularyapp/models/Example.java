package com.example.vocabularyapp.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "examples")
@Data
public class Example {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer exampleid;  // 自動採番
    @Column(name = "engSentence")
    private String engSentence;
    @Column(name = "jpnSentence")
    private String jpnSentence;
    @ManyToOne
    @JoinColumn(name = "wordid")
    private Word word;
}