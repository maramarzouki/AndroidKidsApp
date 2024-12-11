package tn.m1pdam.forkids;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MixColorsCustomView extends View {
    private static final int CIRCLE_RADIUS = 150;
    private RectF circleRect;
    private Paint circlePaint;
    private int currentColorIndex = 0;
    private int currentColor;
    private int[] colors = {Color.parseColor("#fdc500"), Color.parseColor("#ef233c"), Color.parseColor("#219ebc")};

    public MixColorsCustomView(Context context) {
        super(context);
        init(null);
    }

    public MixColorsCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MixColorsCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public MixColorsCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        circleRect = new RectF();
        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setColor(colors[currentColorIndex]);
    }

    public void swapColor() {
        currentColorIndex = (currentColorIndex + 1) % colors.length;
        circlePaint.setColor(colors[currentColorIndex]);
        currentColor = colors[currentColorIndex];
        postInvalidate();
    }

    public void setResultColor(String color){
        circlePaint.setColor(Color.parseColor(color));
        postInvalidate();
    }

    public String getCurrentColorName() {
        switch (currentColorIndex) {
            case 0:
                return "Yellow";
            case 1:
                return "Red";
            case 2:
                return "Blue";
            default:
                return "Unknown";
        }
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        circleRect.set(centerX - CIRCLE_RADIUS, centerY - CIRCLE_RADIUS, centerX + CIRCLE_RADIUS, centerY + CIRCLE_RADIUS);
        canvas.drawCircle(centerX, centerY, CIRCLE_RADIUS, circlePaint);
    }
}
