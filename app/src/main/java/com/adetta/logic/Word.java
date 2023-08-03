package com.adetta.logic;

import java.util.List;

public class Word {

    private String value;
    private int imagePath;
    private  List<String> syllables;

    public Word(String value, List<String> syllables, int imagePath) {
        this.value = value;
        this.imagePath = imagePath;
        this.syllables = syllables;
    }

    public String getFull(){
        return value;
    }

    public List<String> getSyllables(){
        return syllables;
    }

    public int getImagePath(){
        return imagePath;
    }
}
