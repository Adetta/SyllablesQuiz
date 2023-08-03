package com.adetta.logic;

import com.adetta.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Dictionary {
    private ArrayList<Word> words = new ArrayList<>();

    public Dictionary(){
        Word word = new Word("девочка",
                Arrays.asList("де", "воч", "ка"),
                R.drawable.girl);
        Word word2 = new Word("мальчик",
                Arrays.asList("маль", "чик"),
                R.drawable.boy);

        this.words.add(word);
        this.words.add(word2);
    }

    public int countDictionary(){
        return words.size();
    }

    public Word getWord(int index){
        return words.get(index);
    }
}
