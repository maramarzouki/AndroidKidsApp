package tn.m1pdam.forkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class Homepage extends AppCompatActivity {
    Button quizPageButton, mixColorsButton, whiteBoardButton, leaveButton;
    Animation scaleUp, scaleDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        quizPageButton = findViewById(R.id.quizBtn);
        mixColorsButton = findViewById(R.id.mixColorsBtn);
        whiteBoardButton = findViewById(R.id.whiteBoardBtn);
        leaveButton = findViewById(R.id.leaveAppBtn);

        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        quizPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Homepage.this, Quiz.class);
                startActivity(i);
            }
        });

        quizPageButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==event.ACTION_DOWN){
                    quizPageButton.startAnimation(scaleUp);
                } else if(event.getAction()==event.ACTION_UP) {
                    quizPageButton.startAnimation(scaleDown);
                }
                MediaPlayer mediaPlayer = MediaPlayer.create(Homepage.this, R.raw.sound2);
                mediaPlayer.setVolume(1.0f, 1.0f);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
                return false;
            }
        });

        mixColorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Homepage.this, MixColors.class);
                startActivity(i);
            }
        });

        mixColorsButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==event.ACTION_DOWN){
                    mixColorsButton.startAnimation(scaleUp);
                } else if(event.getAction()==event.ACTION_UP) {
                    mixColorsButton.startAnimation(scaleDown);
                }
                MediaPlayer mediaPlayer = MediaPlayer.create(Homepage.this, R.raw.sound2);
                mediaPlayer.setVolume(1.0f, 1.0f);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
                return false;
            }
        });

        whiteBoardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Homepage.this, PaintingActivity.class);
                startActivity(i);
            }
        });

        whiteBoardButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==event.ACTION_DOWN){
                    whiteBoardButton.startAnimation(scaleUp);
                } else if(event.getAction()==event.ACTION_UP) {
                    whiteBoardButton.startAnimation(scaleDown);
                }
                MediaPlayer mediaPlayer = MediaPlayer.create(Homepage.this, R.raw.sound2);
                mediaPlayer.setVolume(1.0f, 1.0f);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
                return false;
            }
        });

        leaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Homepage.this, LeaveActivity.class);
                startActivity(i);
            }
        });

        leaveButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==event.ACTION_DOWN){
                    leaveButton.startAnimation(scaleUp);
                } else if(event.getAction()==event.ACTION_UP) {
                    leaveButton.startAnimation(scaleDown);
                }
                MediaPlayer mediaPlayer = MediaPlayer.create(Homepage.this, R.raw.sound2);
                mediaPlayer.setVolume(1.0f, 1.0f);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
                return false;
            }
        });

    }
}