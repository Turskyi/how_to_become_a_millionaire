package com.example.myfirstmillion;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvQuestion;
    private Button mBtnA;
    private Button mBtnB;
    private Button mBtnC;
    private Button mBtnD;
    private Button mBtn50;
    private Button mBtnCall;
    private Button mBtnAudience;
    private ArrayList<Question> mQuestions;
    ArrayList<Option> hintOptions;
    private Random mRandom = new Random();
    private int mCurrentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvQuestion = findViewById(R.id.tvQuestion);
        mBtnA = findViewById(R.id.btn_a);
        mBtnB = findViewById(R.id.btn_b);
        mBtnC = findViewById(R.id.btn_c);
        mBtnD = findViewById(R.id.btn_d);
        mBtn50 = findViewById(R.id.btn50);
        mBtnAudience = findViewById(R.id.btnAudience);
        mBtnCall = findViewById(R.id.btnCall);

        mBtnA.setOnClickListener(this);
        mBtnB.setOnClickListener(this);
        mBtnC.setOnClickListener(this);
        mBtnD.setOnClickListener(this);
        mBtn50.setOnClickListener(this);
        mBtnAudience.setOnClickListener(this);
        mBtnCall.setOnClickListener(this);

        mQuestions = Utils.setQuestionsBlock();
        updateQuestionUI();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_a:
            case R.id.btn_b:
            case R.id.btn_c:
            case R.id.btn_d:
                View view = null;
                int index = -1;
                switch (v.getId()) {
                    case R.id.btn_a:
                        view = mBtnA;
                        index = 0;
                        break;
                    case R.id.btn_b:
                        view = mBtnB;
                        index = 1;
                        break;
                    case R.id.btn_c:
                        view = mBtnC;
                        index = 2;
                        break;
                    case R.id.btn_d:
                        view = mBtnD;
                        index = 3;
                        break;
                }
                if (view == null) {
                    return;
                }
                final View selectedView = view;
                final int currentIndex = index;
                final Drawable background = view.getBackground();

                selectedView.post(() -> {
                    final boolean correct = currentIndex == mQuestions.get(mCurrentQuestionIndex).getCorrectIndex();

                    selectedView.post(() -> {
                        if (correct) {
                            if (mQuestions.size() == 1) {
                                mBtnA.setVisibility(View.GONE);
                                mBtnB.setVisibility(View.GONE);
                                mBtnC.setVisibility(View.GONE);
                                mBtnD.setVisibility(View.GONE);
                                mBtn50.setVisibility(View.GONE);
                                mBtnAudience.setVisibility(View.GONE);
                                mBtnCall.setVisibility(View.GONE);
                                mTvQuestion.setText(getString(R.string.victory));
                            } else {
                                AlertDialog dialog =
                                        new AlertDialog.Builder(MainActivity.this).setTitle("Answer is correct").setMessage("Next Question").setCancelable(false).setPositiveButton("Ok", (dialog1, which) -> {
                                        }).create();
                                dialog.show();

                                mQuestions.remove(mCurrentQuestionIndex);
                                updateQuestionUI();
                            }
                        }
                        if (!correct) {
                            AlertDialog lastDialog =
                                    new AlertDialog.Builder(MainActivity.this).setTitle("Answer is incorrect").setMessage("Game Over").setCancelable(false).setPositiveButton("New Game", (dialog, which) -> {
                                        mQuestions.remove(mCurrentQuestionIndex);
                                        Intent newIntent = new Intent(MainActivity.this, MainActivity.class);
                                        startActivity(newIntent);
                                    }).create();
                            lastDialog.show();
                        }
                        selectedView.setBackground(background);
                    });
                });
                break;

            case R.id.btn50:
                Question currentQuestion = mQuestions.get(mCurrentQuestionIndex);
                //noinspection unchecked
                hintOptions = (ArrayList<Option>) currentQuestion.getOptions().clone();
                hintOptions.remove(currentQuestion.getCorrectIndex());

                int firstHintIndex = mRandom.nextInt(hintOptions.size());
                Option firstOption = hintOptions.get(firstHintIndex);
                hintOptions.remove(firstHintIndex);
                int secondHintIndex = mRandom.nextInt(2);
                Option secondOption = hintOptions.get(secondHintIndex);

                ArrayList<Option> options = currentQuestion.getOptions();
                int[] hintIndexes = {options.indexOf(firstOption), options.indexOf(secondOption)};
                for (int hintIndex : hintIndexes) {
                    if (hintIndex == 0) {
                        mBtnA.setEnabled(false);
                    } else if (hintIndex == 1) {
                        mBtnB.setEnabled(false);
                    } else if (hintIndex == 2) {
                        mBtnC.setEnabled(false);
                    } else {
                        mBtnD.setEnabled(false);
                    }
                }
                mBtn50.setVisibility(View.GONE);
                hintOptions.clear();
                break;

            case R.id.btnAudience:
                currentQuestion = mQuestions.get(mCurrentQuestionIndex);
//                hintOptions = currentQuestion.getOptions();
//                int hintIndex = Math.random() >= 0.0 ? currentQuestion.getCorrectIndex() + 1 : hintOptions.size();
////                int hintIndex = mRandom.nextInt(Math.random() > 0.3 ? currentQuestion.getCorrectIndex() + 1 : hintOptions.size());
//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
////                    hintIndex = mRandom.nextInt(ThreadLocalRandom.current().nextInt(10) > 3 ? currentQuestion.getCorrectIndex() + 1 : hintOptions.size());
//                    hintIndex = mRandom.nextInt(ThreadLocalRandom.current().nextInt(10) >= 0 ? currentQuestion.getCorrectIndex() + 1 : hintOptions.size());
//                }
//                Option option = hintOptions.get(hintIndex);
//
//                options = currentQuestion.getOptions();
//                int[] audienceHintIndexes = {options.indexOf(option)};
//                for (int audienceHintIndex : audienceHintIndexes) {
                if (currentQuestion.getCorrectIndex() == 3) {
                    mBtnA.setEnabled(false);
                    mBtnB.setEnabled(false);
                    mBtnC.setEnabled(false);
                } else if (currentQuestion.getCorrectIndex() == 2) {
                    mBtnA.setEnabled(false);
                    mBtnB.setEnabled(false);
                    mBtnD.setEnabled(false);
                } else if (currentQuestion.getCorrectIndex() == 1) {
                    mBtnA.setEnabled(false);
                    mBtnC.setEnabled(false);
                    mBtnD.setEnabled(false);
                } else {
                    mBtnB.setEnabled(false);
                    mBtnC.setEnabled(false);
                    mBtnD.setEnabled(false);
                }
//                }
                mBtnAudience.setVisibility(View.GONE);
//                hintOptions.clear();
                break;

            case R.id.btnCall:
                currentQuestion = mQuestions.get(mCurrentQuestionIndex);
//                hintOptions = currentQuestion.getOptions();
//                int hintIndex1 = Math.random() >= 0.0 ? currentQuestion.getCorrectIndex() + 1 : hintOptions.size();
////                int hintIndex = mRandom.nextInt(Math.random() > 0.3 ? currentQuestion.getCorrectIndex() + 1 : hintOptions.size());
//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
////                    hintIndex = mRandom.nextInt(ThreadLocalRandom.current().nextInt(10) > 3 ? currentQuestion.getCorrectIndex() + 1 : hintOptions.size());
//                    hintIndex1 = mRandom.nextInt(ThreadLocalRandom.current().nextInt(10) >= 0 ? currentQuestion.getCorrectIndex() + 1 : hintOptions.size());
//                }
//                Option option1 = hintOptions.get(hintIndex1);

//                options = currentQuestion.getOptions();
//                int[] audienceHintIndexes1 = {options.indexOf(option1)};
//                for (int audienceHintIndex : audienceHintIndexes1) {
//
                if (currentQuestion.getCorrectIndex() == 3) {
                    mBtnA.setEnabled(false);
                    mBtnB.setEnabled(false);
                    mBtnC.setEnabled(false);
                } else if (currentQuestion.getCorrectIndex() == 2) {
                    mBtnA.setEnabled(false);
                    mBtnB.setEnabled(false);
                    mBtnD.setEnabled(false);
                } else if (currentQuestion.getCorrectIndex() == 1) {
                    mBtnA.setEnabled(false);
                    mBtnC.setEnabled(false);
                    mBtnD.setEnabled(false);
                } else {
                    mBtnB.setEnabled(false);
                    mBtnC.setEnabled(false);
                    mBtnD.setEnabled(false);
                }

//
                Intent intent = new Intent(Intent.ACTION_DIAL);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                mBtnCall.setVisibility(View.GONE);
//                hintOptions.clear();
            default:
                break;
        }
    }

    private void updateQuestionUI() {
        Question currentQuestion = getRandomQuestion();
        ArrayList<Option> options = currentQuestion.getOptions();

        mBtnA.setVisibility(View.VISIBLE);
        mBtnB.setVisibility(View.VISIBLE);
        mBtnC.setVisibility(View.VISIBLE);
        mBtnD.setVisibility(View.VISIBLE);
        if (mBtn50.getVisibility() == View.GONE) {
            mBtn50.setVisibility(View.GONE);
        }
        if (mBtnCall.getVisibility() == View.GONE) {
            mBtnCall.setVisibility(View.GONE);
        }
        if (mBtnAudience.getVisibility() == View.GONE) {
            mBtnAudience.setVisibility(View.GONE);
        }
        mBtnA.setEnabled(true);
        mBtnB.setEnabled(true);
        mBtnC.setEnabled(true);
        mBtnD.setEnabled(true);

        mTvQuestion.setText(currentQuestion.getQuestion());
        mBtnA.setText(options.get(0).getText());
        mBtnB.setText(options.get(1).getText());
        mBtnC.setText(options.get(2).getText());
        mBtnD.setText(options.get(3).getText());
    }

    private Question getRandomQuestion() {
        mCurrentQuestionIndex = mRandom.nextInt(mQuestions.size());
        return mQuestions.get(mCurrentQuestionIndex);
    }
}
