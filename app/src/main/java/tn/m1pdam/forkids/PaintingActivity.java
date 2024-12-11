package tn.m1pdam.forkids;

import static tn.m1pdam.forkids.DoodleView.current_brush;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaintingActivity extends AppCompatActivity {
    Button whiteBtn, redBtn, greenBtn, blueBtn, yellowBtn, orangeBtn, pinkBtn, greyBtn, blackBtn, purpleBtn;
    DoodleView doodleView;
    public static Path path = new Path();
    public static Paint paint_brush = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painting);

        whiteBtn = findViewById(R.id.white);
        redBtn = findViewById(R.id.red);
        greenBtn = findViewById(R.id.green);
        blueBtn = findViewById(R.id.blue);
        yellowBtn = findViewById(R.id.yellow);
        orangeBtn = findViewById(R.id.orange);
        pinkBtn = findViewById(R.id.pink);
        greyBtn = findViewById(R.id.grey);
        blackBtn = findViewById(R.id.black);
        purpleBtn = findViewById(R.id.purple);
        doodleView = findViewById(R.id.doodle_view);

        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int red = Color.parseColor("#d00000");
//                doodleView.setStrokeColor(red);
                paint_brush.setColor(red);
                currentColor(paint_brush.getColor());
            }
        });

        blueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int blue = Color.parseColor("#023e8a");
//                doodleView.setStrokeColor(blue);
                paint_brush.setColor(blue);
                currentColor(paint_brush.getColor());
            }
        });

        greenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int green = Color.parseColor("#38b000");
//                doodleView.setStrokeColor(green);
                paint_brush.setColor(green);
                currentColor(paint_brush.getColor());
            }
        });

        yellowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int yellow = Color.parseColor("#fdc500");
//                doodleView.setStrokeColor(yellow);
                paint_brush.setColor(yellow);
                currentColor(paint_brush.getColor());
            }
        });

        pinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pink = Color.parseColor("#c9184a");
//                doodleView.setStrokeColor(pink);
                paint_brush.setColor(pink);
                currentColor(paint_brush.getColor());
            }
        });

        greyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int grey = Color.parseColor("#353535");
//                doodleView.setStrokeColor(grey);
                paint_brush.setColor(grey);
                currentColor(paint_brush.getColor());
            }
        });

        orangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int orange = Color.parseColor("#f18701");
//                doodleView.setStrokeColor(orange);
                paint_brush.setColor(orange);
                currentColor(paint_brush.getColor());
            }
        });

        purpleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int purple = Color.parseColor("#3c096c");
//                doodleView.setStrokeColor(purple);
                paint_brush.setColor(purple);
                currentColor(paint_brush.getColor());
            }
        });

        blackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                doodleView.setStrokeColor(Color.BLACK);
                paint_brush.setColor(Color.BLACK);
                currentColor(paint_brush.getColor());
            }
        });

        whiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                doodleView.setStrokeColor(Color.WHITE);
                paint_brush.setColor(Color.WHITE);
                currentColor(paint_brush.getColor());
            }
        });
    }

    public void currentColor(int c){
        current_brush = c;
        path = new Path();
    }
}