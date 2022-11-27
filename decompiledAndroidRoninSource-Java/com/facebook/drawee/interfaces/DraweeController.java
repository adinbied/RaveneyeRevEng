package com.facebook.drawee.interfaces;

import android.graphics.drawable.Animatable;
import android.view.MotionEvent;
import javax.annotation.Nullable;

public abstract interface DraweeController
{
  public abstract Animatable getAnimatable();
  
  public abstract String getContentDescription();
  
  @Nullable
  public abstract DraweeHierarchy getHierarchy();
  
  public abstract boolean isSameImageRequest(DraweeController paramDraweeController);
  
  public abstract void onAttach();
  
  public abstract void onDetach();
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void onViewportVisibilityHint(boolean paramBoolean);
  
  public abstract void setContentDescription(String paramString);
  
  public abstract void setHierarchy(@Nullable DraweeHierarchy paramDraweeHierarchy);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\interfaces\DraweeController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */