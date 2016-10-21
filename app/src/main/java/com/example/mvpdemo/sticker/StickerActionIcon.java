package com.example.mvpdemo.sticker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

/**
 * 作者：ZhouYou
 * 日期：2016/8/31.
 */
public class StickerActionIcon {

    private Context context;
    // 资源缩放图片的位图
    private Bitmap srcIcon;
    private Rect rect;

    public StickerActionIcon(Context context) {
        this.context = context;
        rect = new Rect();
    }

    public void setSrcIcon(int resource) {
        srcIcon = BitmapFactory.decodeResource(context.getResources(), resource);
    }

    public void draw(Canvas canvas, float x, float y, Paint paint) {
        // 画顶点缩放图片
        rect.left = (int) (x - srcIcon.getWidth() / 2);
        rect.right = (int) (x + srcIcon.getWidth() / 2);
        rect.top = (int) (y - srcIcon.getHeight() / 2);
        rect.bottom = (int) (y + srcIcon.getHeight() / 2);
        canvas.drawCircle(x,y,srcIcon.getWidth() / 2,paint);
        canvas.drawBitmap(srcIcon, null, rect, null);
    }

    /**
     * 判断手指触摸的区域是否在顶点的操作按钮内
     *
     * @param event
     * @return
     */
    public boolean isInActionCheck(MotionEvent event) {
        int left = rect.left;
        int right = rect.right;
        int top = rect.top;
        int bottom = rect.bottom;
        boolean b=event.getX(0) >= left && event.getX(0) <= right && event.getY(0) >= top && event.getY(0) <= bottom;
        return b;
    }

}
