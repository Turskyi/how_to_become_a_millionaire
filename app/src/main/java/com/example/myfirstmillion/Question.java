package com.example.myfirstmillion;

import java.util.ArrayList;

class Question {

    private String mQuestion;
    private ArrayList<Option> mOptions;
    private int mCorrectIndex;

    Question(String question, int correctIndex, ArrayList<Option> options) {
        mQuestion = question;
        mOptions = options;
        mCorrectIndex = correctIndex;
    }

    String getQuestion() {
        return mQuestion;
    }

    ArrayList<Option> getOptions() {
        return mOptions;
    }

    int getCorrectIndex() {
        return mCorrectIndex;
    }
}
