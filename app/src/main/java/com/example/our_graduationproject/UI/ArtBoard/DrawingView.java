package com.example.our_graduationproject.UI.ArtBoard;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.our_graduationproject.R;

import java.util.ArrayList;

//public class DrawingView extends View {
//    private ArrayList<Path> paths = new ArrayList<>();
//    private ArrayList<Integer> colors = new ArrayList<>();
//    private int currentColor = 0xFF000000;
//    private ArrayList<Integer> widths = new ArrayList<>();
//    private int currentWidth = 6;
//
//    // ...
//
//
//    public ArrayList<Path> getPaths() {
//        return paths;
//    }
//
//    public void setPaths(ArrayList<Path> paths) {
//        this.paths = paths;
//    }
//
//    public void setCurrentColor(int color) {
//        currentColor = color;
//    }
//
//
//    public DrawingView(Context context) {
//        super(context);
//    }
//
//    public DrawingView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//
//
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }
//
//    public void addPath(Path path) {
//        paths.add(path);
//        colors.add(currentColor);
//        widths.add(currentWidth);
//
//    }
//
//    public Path getLastPath() {
//        if (paths.size() > 0) {
//            return paths.get(paths.size() - 1);
//        }
//
//        return null;
//    }
//
//    public EditText getEditText() {
//        return editText;
//    }
//
//    public void setEditText(EditText editText) {
//        this.editText = editText;
//    }
//
//    private EditText editText;
//    private float lastTouchX;
//    private float lastTouchY;
//    // Declare the EditText as a member variable
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        float x = event.getX();
//        float y = event.getY();
//
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                lastTouchX = x;
//                lastTouchY = y;
//                invalidate();
//                return true;
//            case MotionEvent.ACTION_MOVE:
//                float dx = x - lastTouchX;
//                float dy = y - lastTouchY;
//                // Update the text position by dx and dy
//                // You can use the setX() and setY() methods of the EditText view
//                invalidate();
//                lastTouchX = dx;
//                lastTouchY = dy;
//                return true;
//        }
//        return super.onTouchEvent(event);
//    }
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        int i = 0;
//        for (Path path : paths) {
//            Paint paint = new Paint();
//            paint.setColor(colors.get(i));
//            paint.setStyle(Paint.Style.STROKE);
//            paint.setStrokeWidth(widths.get(i));
//
//            // Get the text from the EditText
//            String text = editText.getText().toString();
//
//            // Draw the text on the canvas at the updated position
//            float x = 100 + lastTouchX; // Replace with your desired x position
//            float y = 100 + lastTouchY; // Replace with your desired y position
//            canvas.drawText(text, x, y, paint);
//
//            canvas.drawPath(path, paint);
//            i++;
//        }
//    }
//
////    @Override
////    protected void onDraw(Canvas canvas) {
////        super.onDraw(canvas);
////        int i = 0;
////        for (Path path : paths) {
////            Paint paint = new Paint();
////            paint.setColor(colors.get(i));
////            paint.setStyle(Paint.Style.STROKE);
////            paint.setStrokeWidth(widths.get(i));
////
////
////            canvas.drawPath(path, paint);
////            i++;
////        }
////    }
//
//    public void setCurrentWidth(int width) {
//        currentWidth = (width + 1) * 2;
//    }
//    public void erase() {
//        paths.clear();
//        colors.clear();
//        widths.clear();
//        invalidate();
//    }
//}

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;

//public class DrawingView extends View {
//    private ArrayList<Path> paths = new ArrayList<>();
//    private ArrayList<Integer> colors = new ArrayList<>();
//    private int currentColor = 0xFF000000;
//    private ArrayList<Integer> widths = new ArrayList<>();
//    private int currentWidth = 6;
//
//    // Declare the EditText as a member variable
//    private EditText mEditText;
//
//    public DrawingView(Context context) {
//        super(context);
//    }
//
//    public DrawingView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }
//
//    public ArrayList<Path> getPaths() {
//        return paths;
//    }
//
//    public void setPaths(ArrayList<Path> paths) {
//        this.paths = paths;
//    }
//
//    public void setCurrentColor(int color) {
//        currentColor = color;
//    }
//
//    public void addPath(Path path) {
//        paths.add(path);
//        colors.add(currentColor);
//        widths.add(currentWidth);
//    }
//
//    public Path getLastPath() {
//        if (paths.size() > 0) {
//            return paths.get(paths.size() - 1);
//        }
//
//        return null;
//    }
//
//    public EditText getEditText() {
//        return mEditText;
//    }
//
//    public void setEditText(EditText editText) {
//        mEditText = editText;
//    }
//
//    private float lastTouchX;
//    private float lastTouchY;
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        float x = event.getX();
//        float y = event.getY();
//
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                lastTouchX = x;
//                lastTouchY = y;
//                // Check if the touch is inside the EditText's bounds
//                if (mEditText != null && mEditText.getVisibility() == View.VISIBLE) {
//                    float editTextX = mEditText.getX();
//                    float editTextY = mEditText.getY();
//                    float editTextWidth = mEditText.getWidth();
//                    float editTextHeight = mEditText.getHeight();
//                    if (x >= editTextX && x <= editTextX + editTextWidth &&
//                            y >= editTextY && y <= editTextY + editTextHeight) {
//                        return true;
//                    }
//                }
//                invalidate();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                float dx = x - lastTouchX;
//                float dy = y - lastTouchY;
//                // Move the EditText by the difference between the current and last touch positions
//                if (mEditText != null && mEditText.getVisibility() == View.VISIBLE) {
//                    mEditText.setX(mEditText.getX() + dx);
//                    mEditText.setY(mEditText.getY() + dy);
//                }
//                invalidate();
//                lastTouchX = x;
//                lastTouchY = y;
//                break;
//        }
//        return true;
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        int i = 0;
//        for (Path path : paths) {
//            Paint paint = new Paint();
//            paint.setColor(colors.get(i));
//            paint.setStyle(Paint.Style.STROKE);
//            paint.setStrokeWidth(widths.get(i));
//
//            canvas.drawPath(path, paint);
//            i++;
//        }
//
//        // Draw the EditText on the canvas
//        if (mEditText != null) {
//            canvas.translate(mEditText.getX(), mEditText.getY());
//            mEditText.draw(canvas);
//        }
//    }
//
//    public void setCurrentWidth(int width) {
//        currentWidth = (width + 1) * 2;
//    }
//
//    public void erase() {
//        paths.clear();
//        colors.clear();
//        widths.clear();
//        invalidate();
//    }
//}
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;

//public class DrawingView extends View {
//    private ArrayList<Path> paths = new ArrayList<>();
//    private ArrayList<Integer> colors = new ArrayList<>();
//    private int currentColor = 0xFF000000;
//    private ArrayList<Integer> widths = new ArrayList<>();
//    private int currentWidth = 6;
//
//    // Declare the EditText as a member variable
//    private EditText mEditText;
//
//    public DrawingView(Context context) {
//        super(context);
//    }
//
//    public DrawingView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }
//
//    public ArrayList<Path> getPaths() {
//        return paths;
//    }
//
//    public void setPaths(ArrayList<Path> paths) {
//        this.paths = paths;
//    }
//
//    public void setCurrentColor(int color) {
//        currentColor = color;
//    }
//
//    public void addPath(Path path) {
//        paths.add(path);
//        colors.add(currentColor);
//        widths.add(currentWidth);
//    }
//
//    public Path getLastPath() {
//        if (paths.size() > 0) {
//            return paths.get(paths.size() - 1);
//        }
//
//        return null;
//    }
//
//    public EditText getEditText() {
//        return mEditText;
//    }
//
//    public void setEditText(EditText editText) {
//        mEditText = editText;
//    }
//
//    private float lastTouchX;
//    private float lastTouchY;
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        float x = event.getX();
//        float y = event.getY();
//
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                lastTouchX = x;
//                lastTouchY = y;
//                // Check if the touch is inside the EditText's bounds
//                if (mEditText != null && mEditText.getVisibility() == View.VISIBLE) {
//                    float editTextX = mEditText.getX();
//                    float editTextY = mEditText.getY();
//                    float editTextWidth = mEditText.getWidth();
//                    float editTextHeight = mEditText.getHeight();
//                    if (x >= editTextX && x <= editTextX + editTextWidth &&
//                            y >= editTextY && y <= editTextY + editTextHeight) {
//                        return true;
//                    }
//                }
//                invalidate();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                float dx = x - lastTouchX;
//                float dy = y - lastTouchY;
//                // Move the EditText by the difference between the current and last touch positions
//                if (mEditText != null && mEditText.getVisibility() == View.VISIBLE) {
//                    mEditText.setX(mEditText.getX() + dx);
//                    mEditText.setY(mEditText.getY() + dy);
//                }
//                invalidate();
//                lastTouchX = x;
//                lastTouchY = y;
//                break;
//        }
//        return true;
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        int i = 0;
//        for (Path path : paths) {
//            Paint paint = new Paint();
//            paint.setColor(colors.get(i));
//            paint.setStyle(Paint.Style.STROKE);
//            paint.setStrokeWidth(widths.get(i));
//
//            canvas.drawPath(path, paint);
//            i++;
//        }
//
//        // Draw the EditText on the canvas
//        if (mEditText != null) {
//            canvas.translate(mEditText.getX(), mEditText.getY());
//            mEditText.draw(canvas);
//        }
//    }
//
//    public void setCurrentWidth(int width) {
//        currentWidth = (width + 1) * 2;
//    }
//
//    public void erase() {
//        paths.clear();
//        colors.clear();
//        widths.clear();
//        invalidate();
//    }

//}
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class DrawingView extends View {
    private ArrayList<Path> paths = new ArrayList<>();
    private ArrayList<Integer> colors = new ArrayList<>();
    private int currentColor = 0xFF000000;
    private ArrayList<Integer> widths = new ArrayList<>();
    private int currentWidth = 6;

    // Declare the EditText as a member variable
    private EditText mEditText;

    public DrawingView(Context context) {
        super(context);
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public ArrayList<Path> getPaths() {
        return paths;
    }

    public void setPaths(ArrayList<Path> paths) {
        this.paths = paths;
    }

    public void setCurrentColor(int color) {
        currentColor = color;
    }

    public void addPath(Path path) {
        paths.add(path);
        colors.add(currentColor);
        widths.add(currentWidth);
    }

    public Path getLastPath() {
        if (paths.size() > 0) {
            return paths.get(paths.size() - 1);
        }

        return null;
    }

    public EditText getEditText() {
        return mEditText;
    }

    public void setEditText(EditText editText) {
        mEditText = editText;
    }

    private float lastTouchX;
    private float lastTouchY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastTouchX = x;
                lastTouchY = y;
                // Check if the touch is inside the EditText's bounds
                if (mEditText != null && mEditText.getVisibility() == View.VISIBLE) {
                    float editTextX = mEditText.getX();
                    float editTextY = mEditText.getY();
                    float editTextWidth = mEditText.getWidth();
                    float editTextHeight = mEditText.getHeight();
                    if (x >= editTextX && x <= editTextX + editTextWidth &&
                            y >= editTextY && y <= editTextY + editTextHeight) {
                        return true;
                    }
                }
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = x - lastTouchX;
                float dy = y - lastTouchY;
                // Move the EditText by the difference between the current and last touch positions
                if (mEditText != null && mEditText.getVisibility() == View.VISIBLE) {
                    ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) mEditText.getLayoutParams();
                    layoutParams.leftMargin += dx;
                    layoutParams.topMargin += dy;
                    mEditText.setLayoutParams(layoutParams);
                }
                invalidate();
                lastTouchX = x;
                lastTouchY = y;
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = 0;
        for (Path path : paths) {
            Paint paint = new Paint();
            paint.setColor(colors.get(i));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(widths.get(i));

            canvas.drawPath(path, paint);
            i++;
        }

        // Draw the EditText on the canvas
        if (mEditText != null) {
            canvas.translate(mEditText.getLeft(), mEditText.getTop());
            mEditText.draw(canvas);
        }
    }

    public void setCurrentWidth(int width) {
        currentWidth = (width + 1) * 2;
    }

    public void erase() {
        paths.clear();
        colors.clear();
        widths.clear();
        invalidate();
    }
}