package com.huawei.hms.support.api.game.c.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewTreeObserver;

public class b
{
  private static final String a = b.class.getSimpleName();
  
  public static void a(Bitmap paramBitmap, View paramView1, Activity paramActivity, View paramView2, a parama)
  {
    paramView1.getViewTreeObserver().addOnPreDrawListener(new c(paramView1, paramBitmap, paramActivity, parama, paramView2));
  }
  
  private static void b(Bitmap paramBitmap, View paramView, Activity paramActivity)
  {
    if (paramView.getMeasuredWidth() > 0)
    {
      if (paramView.getMeasuredHeight() <= 0) {
        return;
      }
      Bitmap localBitmap = Bitmap.createBitmap((int)(paramView.getMeasuredWidth() / 2.0F), (int)(paramView.getMeasuredHeight() / 2.0F), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.translate(-paramView.getLeft() / 2.0F, -paramView.getTop() / 2.0F);
      localCanvas.scale(0.5F, 0.5F);
      Paint localPaint = new Paint();
      localPaint.setFlags(2);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
      paramBitmap = new a().a(localBitmap, 10, true);
      paramView.setBackground(new BitmapDrawable(paramActivity.getResources(), paramBitmap));
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(Activity paramActivity, View paramView);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\game\c\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */