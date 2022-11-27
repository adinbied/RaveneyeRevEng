package com.jakewharton.rxbinding2.view;

import android.view.View;

public abstract class ViewLayoutChangeEvent
{
  public static ViewLayoutChangeEvent create(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    return new AutoValue_ViewLayoutChangeEvent(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public abstract int bottom();
  
  public abstract int left();
  
  public abstract int oldBottom();
  
  public abstract int oldLeft();
  
  public abstract int oldRight();
  
  public abstract int oldTop();
  
  public abstract int right();
  
  public abstract int top();
  
  public abstract View view();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\ViewLayoutChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */