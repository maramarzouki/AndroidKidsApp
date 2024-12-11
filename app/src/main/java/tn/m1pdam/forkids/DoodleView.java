package tn.m1pdam.forkids;

import static tn.m1pdam.forkids.PaintingActivity.paint_brush;
import static tn.m1pdam.forkids.PaintingActivity.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DoodleView extends View {
    public static ArrayList<Path> pathList = new ArrayList<>();
    public static ArrayList<Integer> colorList = new ArrayList<>();
    public ViewGroup.LayoutParams params;
    public static int current_brush;

    public DoodleView(Context context) {
        super(context);
        init(context);
    }

    public DoodleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DoodleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public DoodleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context){
        paint_brush.setAntiAlias(true);
        paint_brush.setColor(Color.BLACK);
        paint_brush.setStyle(Paint.Style.STROKE);
        paint_brush.setStrokeCap(Paint.Cap.ROUND);
        paint_brush.setStrokeJoin(Paint.Join.ROUND);
        paint_brush.setStrokeWidth(10f);

        params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch ((motionEvent.getAction())){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                pathList.add(path);
                colorList.add(current_brush);
                invalidate();
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        for(int i=0;i<pathList.size();i++){
            paint_brush.setColor(colorList.get(i));
            canvas.drawPath(pathList.get(i), paint_brush);
            invalidate();
        }
    }

    //    private Paint _paintDoodle = new Paint();
//    private Path _path = new Path();
//    private Map<Integer, Path> _pathsByColor = new HashMap<>();
//    private int _currentColor = Color.BLACK;
//
//    public DoodleView(Context context) {
//        super(context);
//        init(null, 0);
//    }
//
//    public DoodleView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        init(attributeSet, 0);
//    }
//
//    public DoodleView(Context context, AttributeSet attributeSet, int defStyle) {
//        super(context, attributeSet, defStyle);
//        init(attributeSet, defStyle);
//    }
//
//    public void init(AttributeSet attributeSet, int defStyle) {
////        _paintDoodle.setColor(Color.BLACK);
//        _paintDoodle.setAntiAlias(true);
//        _paintDoodle.setStyle(Paint.Style.STROKE);
//
//        _paintDoodle.setStrokeWidth(5); // Set the stroke width as needed
//        _paintDoodle.setStrokeJoin(Paint.Join.ROUND);
//        _paintDoodle.setStrokeCap(Paint.Cap.ROUND);
//    }
//
//    public void setStrokeColor(int color) {
//        _currentColor = color;
//        if (!_pathsByColor.containsKey(color)) {
//            _pathsByColor.put(color, new Path());
//        }
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
////        canvas.drawLine(0, 0, getWidth(), getHeight(), _paintDoodle);
//        for (Path path : _pathsByColor.values()) {
//            _paintDoodle.setColor(getColorForPath(path));
//            canvas.drawPath(path, _paintDoodle);
//        }
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        float touchX = event.getX();
//        float touchY = event.getY();
//        Path path = _pathsByColor.get(_currentColor);
//
//        // Initialize path if it's null
//        if (path == null) {
//            path = new Path();
//            _pathsByColor.put(_currentColor, path);
//        }
//
//        switch(event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                path.moveTo(touchX,touchY);
//                invalidate();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                path.lineTo(touchX,touchY);
//                invalidate();
//                break;
//            case MotionEvent.ACTION_UP:
//                break;
//        }
//        invalidate();
//        return true;
//    }
//
//
//    private int getColorForPath(Path path) {
//        for (Map.Entry<Integer, Path> entry : _pathsByColor.entrySet()) {
//            if (entry.getValue() == path) {
//                return entry.getKey();
//            }
//        }
//        return _currentColor;
//    }
}
