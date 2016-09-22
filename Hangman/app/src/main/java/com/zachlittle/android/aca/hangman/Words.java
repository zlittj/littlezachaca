package com.zachlittle.android.aca.hangman;


import java.lang.reflect.Array;
import java.util.Random;

public class Words {

        //16 in now
        private int mLength;
        private String[] wordsToHangYou =  {
        "worms", "test", "password", "magnet", "talking", "wordy", "java", "comment",
        "desk", "computer", "range", "working", "chair", "water", "finder",
        "horse", "door", "song", "trip", "backbone", "bomb", "round", "treasure", "garbage",
        "park", "pirate", "ski", "state", "whistle", "palace", "baseball", "coal", "queen",
        "dominoes", "photograph", "hockey", "aircraft", "salt", "pepper", "whisk", "frog", "lawnmower",
        "mattress", "pinwheel", "cake", "circus", "battery", "mailman", "cowboy", "bicycle",
        "skate", "electricity", "lightsaber", "thief", "teapot", "deep", "spring", "nature", "shallow",
        "toast", "outside", "America", "roller", "gingerbread", "bowtie", "half", "spare", "wax",
        "light", "bulb", "platypus", "music"
    };

    public String getWordToHangYou(){
        Random ranGen = new Random();
        int ranNum = ranGen.nextInt(72);
        return wordsToHangYou[ranNum];

    }
    public int getLength(){
        mLength = Array.getLength(wordsToHangYou);
        return mLength;
    }
}
