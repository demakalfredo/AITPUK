package com.example.aitpuk20;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

public class ZoomLayout extends ConstraintLayout implements ScaleGestureDetector.OnScaleGestureListener {
    private enum Mode{
        NONE,
        DRAG,
        ZOOM
    }

    private static final String TAG = "ZoomLayout";
    private static final float MIN_ZOOM = 1.0f;
    private static final float MAX_ZOOM = 4.0f;

    private Mode mode = Mode.NONE;
    private float scale = 1.0f;
    private float lastScaleFactor = 0f;

    //lokasi awal screen di sentuh
    private float startX = 0f;
    private float startY = 0f;

    //berapa banyak menerjemahkan kanvas
    private float dx = 0f;
    private float dy = 0f;
    private float prevDx = 0f;
    private float prevDy = 0f;

    //fungsi zoom kalo didouble tap gan
    private boolean firstTouch = false;
    private long time = System.currentTimeMillis();
    private boolean restore = false;

    public ZoomLayout(Context context){
        super(context);
        init(context);
    }

    public ZoomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ZoomLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public void init(Context context){
        final ScaleGestureDetector scaleDetector = new ScaleGestureDetector(context, this);
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() & MotionEvent.ACTION_MASK){
                    case MotionEvent.ACTION_DOWN:
                        Log.i(TAG, "DOWN");
                        if (firstTouch && (System.currentTimeMillis() - time) <= 300){
                            if (restore){
                                scale = 1.0f;
                                restore = false;
                            }
                            else {
                                scale *= 2f;
                                restore = true;
                            }
                            mode = Mode.ZOOM;
                            firstTouch = false;
                        }
                        else {
                            if (scale > MIN_ZOOM) {
                                mode = Mode.DRAG;
                                startX = event.getX() - prevDx;
                                startY = event.getY() - prevDy;
                            }
                            firstTouch = true;
                            time = System.currentTimeMillis();
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (mode == Mode.DRAG){
                            dx = event.getX() - startX;
                            dy = event.getY() - startY;
                        }
                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                      mode = Mode.ZOOM;
                      break;
                    case MotionEvent.ACTION_POINTER_UP:
                        //mode = Mode.DRAG;(tadinya make ini)
                        mode = Mode.NONE;
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i(TAG, "UP");
                        mode = Mode.NONE;
                        prevDx = dx;
                        prevDy = dy;
                        break;
                }
                scaleDetector.onTouchEvent(event);

                if ((mode == Mode.DRAG && scale >= MIN_ZOOM) || mode == Mode.ZOOM){
                    getParent().requestDisallowInterceptTouchEvent(true);
                    float maxDx = (child().getWidth() - (child().getWidth() / scale)) / 2 * scale;
                    float maxDy = (child().getHeight() - (child().getHeight() / scale))/ 2 * scale;
                    dx = Math.min(Math.max(dx, -maxDx), maxDx);
                    dy = Math.min(Math.max(dy, -maxDy), maxDy);
                    Log.i(TAG, "Width: " + child().getWidth() + ", scale " + scale + ", dx " + dx
                            + ", max " + maxDx);
                    applyScaleAndTranslation();
                }

                return true;
            }
        });
    }

    //ScaleGestureDetector

    @Override
    public boolean onScaleBegin(ScaleGestureDetector scaleDetector){
        Log.i(TAG, "onScaleBegin");
        return true;
    }

    @Override
    public boolean onScale(ScaleGestureDetector scaleDetector){
        float scaleFactor = scaleDetector.getScaleFactor();
        Log.i(TAG, "onScale" + scaleFactor);
        if (lastScaleFactor == 0 || (Math.signum(scaleFactor) == Math.signum(lastScaleFactor))) {
            scale *= scaleFactor;
            scale = Math.max(MIN_ZOOM, Math.min(scale, MAX_ZOOM));
            lastScaleFactor = scaleFactor;
        } else {
            lastScaleFactor = 0;
        }
        return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector scaleDetector){
        Log.i(TAG, "onScaleEnd");
    }

    private void applyScaleAndTranslation(){
        child().setScaleX(scale);
        child().setScaleY(scale);
        child().setTranslationX(dx);
        child().setTranslationY(dy);
    }

    private View child(){
        return getChildAt(0);
    }
}
