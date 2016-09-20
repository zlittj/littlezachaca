package com.zachlittle.android.aca.hangman;


import java.util.Random;

public class Words {

        //16 in now
        private String[] wordsToHangYou =  {

        "worms", "test", "butthole", "magnet", "talking", "wordy", "java", "comment",
        "desk", "doors", "computer", "range", "working", "chair", "water", "finder"
    };

    public String getWordToHangYou(){
        Random ranGen = new Random();
        int ranNum = ranGen.nextInt(16);
        return wordsToHangYou[ranNum];
    }
}
