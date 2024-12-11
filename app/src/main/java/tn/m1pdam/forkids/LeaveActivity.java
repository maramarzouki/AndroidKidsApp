package tn.m1pdam.forkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class LeaveActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave);

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
                if (LeaveActivity.this!=null) {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        };

        // Post the Runnable with the specified delay
        handler.postDelayed(runnable, delayMillis);
    }
}