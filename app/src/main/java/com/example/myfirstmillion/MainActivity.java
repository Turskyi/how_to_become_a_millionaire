package com.example.myfirstmillion;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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

        mQuestions = Utils.setQuestionsBlock(1);
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
                                Intent intent = new Intent(MainActivity.this, MyService.class);
                                startService(intent);
                                stopService(intent);
                                AlertDialog dialog =
                                        new AlertDialog.Builder(MainActivity.this).setTitle("Answer is correct").setMessage("Next Question").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                            }
                                        }).create();
                                dialog.show();

                                mQuestions.remove(mCurrentQuestionIndex);
                                updateQuestionUI();
                            }
                        }
                        if (!correct) {
                            Intent lastIntent = new Intent(MainActivity.this, MyService.class);
                            startService(lastIntent);
                            stopService(lastIntent);
                            AlertDialog lastDialog =
                                    new AlertDialog.Builder(MainActivity.this).setTitle("Answer is incorrect").setMessage("Game Over").setCancelable(false).setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            mQuestions.remove(mCurrentQuestionIndex);
                                            updateQuestionUI();
                                        }
                                    }).create();
                            lastDialog.show();
                        }
                        selectedView.setBackground(background);
                    });
                });
                break;

            case R.id.btn50:
                Question currentQuestion = mQuestions.get(mCurrentQuestionIndex);
                ArrayList<Option> hintOptions = (ArrayList<Option>) currentQuestion.getOptions().clone();
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
                break;

            case R.id.btnAudience:
                currentQuestion = mQuestions.get(mCurrentQuestionIndex);
                hintOptions = currentQuestion.getOptions();
                int hintIndex = Math.random() < 0.3 ? hintOptions.size() + 1 : currentQuestion.getCorrectIndex() + 1;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    hintIndex = mRandom.nextInt(ThreadLocalRandom.current().nextInt(10) > 3 ? currentQuestion.getCorrectIndex() : hintOptions.size());
                }
                Option option = hintOptions.get(hintIndex);

                options = currentQuestion.getOptions();
                int[] audienceHintIndexes = {options.indexOf(option)};
                for (int audienceHintIndex : audienceHintIndexes) {
                    if (audienceHintIndex == 0) {
                        mBtnA.setEnabled(false);
                        mBtnB.setEnabled(false);
                        mBtnC.setEnabled(false);
                    } else if (audienceHintIndex == 1) {
                        mBtnA.setEnabled(false);
                        mBtnB.setEnabled(false);
                        mBtnD.setEnabled(false);
                    } else if (audienceHintIndex == 2) {
                        mBtnA.setEnabled(false);
                        mBtnC.setEnabled(false);
                        mBtnD.setEnabled(false);
                    } else {
                        mBtnB.setEnabled(false);
                        mBtnC.setEnabled(false);
                        mBtnD.setEnabled(false);
                    }
                }
                break;

            case R.id.btnCall:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
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
        mBtn50.setVisibility(View.VISIBLE);
        mBtnCall.setVisibility(View.VISIBLE);
        mBtnAudience.setVisibility(View.VISIBLE);
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
