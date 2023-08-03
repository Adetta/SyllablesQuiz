package com.adetta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.adetta.logic.Dictionary;
import com.adetta.logic.Word;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Dictionary dictionary = new Dictionary();
    private int currentWordIndex = -1;
    private Word currentWord;
    Button[] buttons = new Button[5];
    boolean[] buttonsState = { false, false, false, false, false };

    TextView answerWord;
    ImageView img;
    List<String> word = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);
        Button btn4 = (Button) findViewById(R.id.button4);
        Button btn5 = (Button) findViewById(R.id.button5);
        buttons[0] = btn1;
        buttons[1] = btn2;
        buttons[2] = btn3;
        buttons[3] = btn4;
        buttons[4] = btn5;
        img = (ImageView) findViewById(R.id.imageView);
        answerWord = (TextView) findViewById(R.id.tv_answer);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                checkText(btn1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                checkText(btn2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                checkText(btn3);
            }
        });

        fillPage();
    }

    private void fillPage() {
        word.clear();
        answerWord.setText("");

        currentWordIndex++;
        if (currentWordIndex < dictionary.countDictionary()) {
            currentWord = dictionary.getWord(currentWordIndex);
            img.setImageResource(currentWord.getImagePath());
            addButtonText();
        }
        else{
            answerWord.setText(R.string.hint_text2);
            for (Button button : buttons) {
                button.setVisibility(View.INVISIBLE);
            }
        }
    }

    private void addButtonText(){
        List<String> syllables =  currentWord.getSyllables();
        int i = 0;
        for(String syllable : syllables){
            buttons[i].setText(syllable);
            buttons[i].setBackgroundColor(0xFFD500F9);
            buttons[i].setSelected(false);
            i++;
        }

        for (int j = i; j < buttons.length; j++){
            buttons[j].setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onRestart() {
        System.out.println("onRestart");
        super.onRestart();
        fillPage();
    }

    private void checkText(Button btn){
        changeState(btn);

        if (currentWord.getSyllables().equals(word) ){
           showWin();
        }
    }

    private void showWin(){
        Toast.makeText(MainActivity.this, R.string.success, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Winner.class);
        startActivity(intent);
    }

    private void changeState(Button btn) {
/*ButtonState {
    int id;
    int syllableIndex;
    bool state;
        }*/

        if (btn.isSelected()){
            btn.setSelected(false);
            btn.setBackgroundColor(0xFFD500F9);
            word.remove(btn.getText().toString());
            answerWord.setText(word.toString());
        }
        else{
            btn.setSelected(true);
            btn.setBackgroundColor(0xFFF50057);
            word.add(btn.getText().toString());
            answerWord.setText(word.toString());
        }
    }
}