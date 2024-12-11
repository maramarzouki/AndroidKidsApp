package tn.m1pdam.forkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MixColors extends AppCompatActivity {
    MixColorsCustomView mixColorsCustomView1, mixColorsCustomView2, mixColorsCustomView3;
    Button mixColorsBTN, goBackButton;
    String customView1_currentColor = "Yellow", customView2_currentColor = "Yellow";

    private static final Map<String, Map<String, String>> colorMap = new HashMap<>();

    static {
        Map<String, String> redCombinations = new HashMap<>();
        redCombinations.put("Red", "#ef233c");
        redCombinations.put("Yellow", "#f77f00");
        redCombinations.put("Blue", "#3c096c");
        colorMap.put("Red", redCombinations);

        Map<String, String> yellowCombinations = new HashMap<>();
        yellowCombinations.put("Red", "#f77f00");
        yellowCombinations.put("Yellow", "#fdc500");
        yellowCombinations.put("Blue", "#70e000");
        colorMap.put("Yellow", yellowCombinations);

        Map<String, String> blueCombinations = new HashMap<>();
        blueCombinations.put("Red", "#3c096c");
        blueCombinations.put("Yellow", "#70e000");
        blueCombinations.put("Blue", "#219ebc");
        colorMap.put("Blue", blueCombinations);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mix_colors);

        MixColorsCustomView mixColorsCustomView = new MixColorsCustomView(this);

        mixColorsCustomView1 = findViewById(R.id.customView1);
        mixColorsCustomView2 = findViewById(R.id.customView2);
        mixColorsCustomView3 = findViewById(R.id.customView3);

        mixColorsBTN = findViewById(R.id.mixBTN);
        goBackButton = findViewById(R.id.goBackButton);

        mixColorsCustomView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mixColorsCustomView1.swapColor();
                customView1_currentColor = mixColorsCustomView1.getCurrentColorName();
//                Toast.makeText(MixColors.this, "Color: " + customView1_currentColor, Toast.LENGTH_SHORT).show();
            }
        });

        mixColorsCustomView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mixColorsCustomView2.swapColor();
                customView2_currentColor = mixColorsCustomView2.getCurrentColorName();
            }
        });

        mixColorsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultColor = getResultColor(customView1_currentColor, customView2_currentColor);
//                Toast.makeText(MixColors.this, ""+resultColor, Toast.LENGTH_SHORT).show();
                mixColorsCustomView3.setResultColor(resultColor);
            }
        });

        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MixColors.this, Homepage.class);
                startActivity(i);
            }
        });
    }

    public String getResultColor(String color1, String color2) {
        String resultColor = "";

        if (colorMap.containsKey(color1) && colorMap.get(color1).containsKey(color2)) {
            resultColor = colorMap.get(color1).get(color2);
        } else if (colorMap.containsKey(color2) && colorMap.get(color2).containsKey(color1)) {
            resultColor = colorMap.get(color2).get(color1);
        }

        return resultColor;
//        String resultColor = "";
//        if (color1.equals("Red") && color2.equals("Red")) {
//            resultColor = "Red";
//        } else if (color1.equals("Red") && color2.equals("Yellow")) {
//            resultColor = "Orange";
//        } else if (color1.equals("Red") && color2.equals("Blue")) {
//            resultColor = "Purple";
//        } else if (color1.equals("Yellow") && color2.equals("Yellow")) {
//            resultColor = "Yellow";
//        } else if (color1.equals("Yellow") && color2.equals("Red")) {
//            resultColor = "Orange";
//        }else if(color1.equals("Yellow") && color2.equals("Blue")){
//            resultColor = "Green";
//        }
//        return resultColor;
    }
}