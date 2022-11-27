package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.RectF;

public abstract interface TransformCallback
{
  public abstract void getRootBounds(RectF paramRectF);
  
  public abstract void getTransform(Matrix paramMatrix);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\drawable\TransformCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */