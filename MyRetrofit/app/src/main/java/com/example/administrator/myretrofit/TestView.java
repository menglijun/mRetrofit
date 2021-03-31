package com.example.administrator.myretrofit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class TestView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path mPath = new Path();
    PathMeasure mPathMeasure;

    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * layout过程结束之后，实际尺寸改变后都会调用
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mPath.reset();
        /**
         * Path.Direction.CCW counter Clockwise 逆时针
         * CW 顺时针
         */
        mPath.addRect(getWidth()/2 - 150,getHeight()/2 - 300,getWidth()/2+150,
                getHeight()/2,Path.Direction.CCW);

        mPathMeasure = new PathMeasure(mPath,false);
        mPathMeasure.getLength();//测量整个路径长度
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        mPath.setFillType(Path.FillType.WINDING);
        canvas.drawCircle(getWidth()/2,getHeight()/2,
                Utils.dp2px(150),mPaint);
    }


}
