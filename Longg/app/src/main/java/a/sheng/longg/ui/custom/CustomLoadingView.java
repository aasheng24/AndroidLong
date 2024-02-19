package a.sheng.longg.ui.custom;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomLoadingView extends View {
    public static final String TAG = "ez-LoadingView";
    private Paint paint;
    private RectF arcRect;
    private float startAngle;
    private float sweepAngle;

    public CustomLoadingView(Context context) {
        super(context);
        Log.i(TAG,"111 constructor");
        init();
    }

    public CustomLoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.i(TAG,"222 constructor");
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setAntiAlias(true);
        arcRect = new RectF();
        startAngle = 0;
        sweepAngle = 45;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        //float radius = Math.min(centerX, centerY) - paint.getStrokeWidth() / 2;
        float radius = 100;
        arcRect.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius);
        canvas.drawArc(arcRect, startAngle, sweepAngle, false, paint);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimation();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }
    private ValueAnimator animator;

    private void startAnimation() {
        animator = ValueAnimator.ofFloat(0, 360);
        animator.setDuration(1000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                startAngle = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.start();
    }

    private void stopAnimation() {
        if (animator != null) {
            animator.cancel();
            animator = null;
        }
    }
}
