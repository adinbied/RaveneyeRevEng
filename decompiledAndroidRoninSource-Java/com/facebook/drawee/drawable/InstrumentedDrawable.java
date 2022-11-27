package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class InstrumentedDrawable
  extends ForwardingDrawable
{
  private boolean mIsChecked = false;
  private final Listener mListener;
  private final String mScaleType;
  
  public InstrumentedDrawable(Drawable paramDrawable, Listener paramListener)
  {
    super(paramDrawable);
    this.mListener = paramListener;
    this.mScaleType = getScaleType(paramDrawable);
  }
  
  private String getScaleType(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof ScaleTypeDrawable)) {
      return ((ScaleTypeDrawable)paramDrawable).getScaleType().toString();
    }
    return "none";
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!this.mIsChecked)
    {
      this.mIsChecked = true;
      Object localObject = new RectF();
      getRootBounds((RectF)localObject);
      int i = (int)((RectF)localObject).width();
      int j = (int)((RectF)localObject).height();
      getTransformedBounds((RectF)localObject);
      int k = (int)((RectF)localObject).width();
      int m = (int)((RectF)localObject).height();
      int n = getIntrinsicWidth();
      int i1 = getIntrinsicHeight();
      localObject = this.mListener;
      if (localObject != null) {
        ((Listener)localObject).track(i, j, n, i1, k, m, this.mScaleType);
      }
    }
    super.draw(paramCanvas);
  }
  
  public static abstract interface Listener
  {
    public abstract void track(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\drawable\InstrumentedDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */