package com.facebook.drawee.interfaces;

import android.graphics.drawable.Drawable;

public abstract interface SettableDraweeHierarchy
  extends DraweeHierarchy
{
  public abstract void reset();
  
  public abstract void setControllerOverlay(Drawable paramDrawable);
  
  public abstract void setFailure(Throwable paramThrowable);
  
  public abstract void setImage(Drawable paramDrawable, float paramFloat, boolean paramBoolean);
  
  public abstract void setProgress(float paramFloat, boolean paramBoolean);
  
  public abstract void setRetry(Throwable paramThrowable);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\interfaces\SettableDraweeHierarchy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */