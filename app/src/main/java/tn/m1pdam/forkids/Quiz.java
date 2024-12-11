package tn.m1pdam.forkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Quiz extends AppCompatActivity {
    QuizQuestions[] questions;
    int currentQuestionIndex = 0;
    Random random;
    TextView questionText;
    Button option1, option2, option3, option4, goBackButton;

//    private Button[] optionButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questions = QuizData.getQuestions();

        questionText = findViewById(R.id.questionText);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        goBackButton = findViewById(R.id.goBackBTN);

        random = new Random();

        shuffleQuestions();
        displayQuiz();

    }

    public void shuffleQuestions() {
        Collections.shuffle(Arrays.asList(questions), random);
    }

    public void displayQuiz() {
        option1.setBackgroundColor(Color.parseColor("#065a82"));
        option2.setBackgroundColor(Color.parseColor("#065a82"));
        option3.setBackgroundColor(Color.parseColor("#065a82"));
        option4.setBackgroundColor(Color.parseColor("#065a82"));

        QuizQuestions currentQuestion = questions[currentQuestionIndex];
        String question = currentQuestion.getQuestion();
        String[] options = currentQuestion.getOptions();

        questionText.setText(question);
        option1.setText(options[0]);
        option2.setText(options[1]);
        option3.setText(options[2]);
        option4.setText(options[3]);

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(options[0], option1.getId());
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(options[1], option2.getId());
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(options[2], option3.getId());
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(options[3], option4.getId());
            }
        });

        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Quiz.this, Homepage.class);
                startActivity(i);
            }
        });

        //        displayOptionButtons(options);
    }

//    public void displayOptionButtons(String[] options){
//        LinearLayout optionsContainer = findViewById(R.id.buttonsContainer);
//        optionsContainer.removeAllViews(); // Clear the previous buttons
//        optionButtons = new Button[options.length]; //creates a new array of Button objects with a size equal to the length of the options array
//        for (int i = 0; i < options.length; i++) {
//            Button button = new Button(this);
//            button.setLayoutParams(new ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.WRAP_CONTENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT
//            ));
//            button.setText(options[i]);
//            button.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//                    checkAnswer(((Button) v).getText().toString(), button.getId());
//                }
//            });
//            optionsContainer.addView(button);
//            optionButtons[i] = button;
//        }
//    }

    private void checkAnswer(String answer, int id) {
        String correctAnswer = questions[currentQuestionIndex].getCorrectAnswer();
        if (correctAnswer.equals(answer)) {
//            Button button = findViewById(id);
//            button.setBackgroundColor(Color.GREEN);
            tapToBounce(id);
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct_answer_sound_effect);
            mediaPlayer.setVolume(1.0f, 1.0f);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
//            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
            currentQuestionIndex++;
        } else {
            tapToShake(id);
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong_answer_sound_effect);
            mediaPlayer.setVolume(1.0f, 1.0f);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
//            Toast.makeText(getApplicationContext(), "Incorrect! Correct answer is: " + correctAnswer, Toast.LENGTH_SHORT).show();
        }

        if (currentQuestionIndex < questions.length) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    displayQuiz();
                }
            }, 3000);
        } else {
            Toast.makeText(getApplicationContext(), "Quiz completed!", Toast.LENGTH_SHORT).show();
        }

    }

    public void tapToBounce(int correctAnswerID) {
        Button correctAnswerButton = (Button) findViewById(correctAnswerID);
        correctAnswerButton.setBackgroundColor(Color.GREEN);
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        BounceInterpolator interpolator = new BounceInterpolator(0.2, 20);
        animation.setInterpolator(interpolator);
        correctAnswerButton.startAnimation(animation);
    }

    public void tapToShake(int wrongAnswerID) {
        Button wrongAnswerButton = (Button) findViewById(wrongAnswerID);
        wrongAnswerButton.setBackgroundColor(Color.RED);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.shake);
        wrongAnswerButton.startAnimation(animation);
    }
}