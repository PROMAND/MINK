package pl.byd.promand.Team1;


import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class SurfaceViewDraw extends View {

    private Paint paint = new Paint();
    private Path path = new Path();

    public ViewGroup.LayoutParams params;

    public SurfaceViewDraw(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SurfaceViewDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SurfaceViewDraw(Context context) {
        super(context);

        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor(ModelRoot.getRoot().getColor()));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(Float.parseFloat(ModelRoot.getRoot().getWidth()) * 2);

        params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        path.reset();
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float pointX = event.getX();
        float pointY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                path.moveTo(pointX, pointY);
                return true;
            }
            case MotionEvent.ACTION_MOVE: {
                path.lineTo(pointX, pointY);
                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
            default: {
                return false;
            }
        }

        postInvalidate();
        return true;
    }

    @Override
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
    }
}

