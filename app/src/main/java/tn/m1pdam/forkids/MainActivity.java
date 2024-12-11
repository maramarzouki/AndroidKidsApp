package tn.m1pdam.forkids;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottieAnimationView = findViewById(R.id.animationView);

        lottieAnimationView.animate();

        // Delay in milliseconds
        int delayMillis = 4000;

        // Create a Handler
        Handler handler = new Handler();

        // Create a Runnable that will be executed after the specified delay
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                lottieAnimationView.cancelAnimation();
                // Start your activity or perform the desired task here
                if (MainActivity.this!=null) {
                    Intent intent = new Intent(MainActivity.this, Homepage.class);
                    startActivity(intent);
                }
            }
        };

        // Post the Runnable with the specified delay
        handler.postDelayed(runnable, delayMillis);
    }
}