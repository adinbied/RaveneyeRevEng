package com.jakewharton.rxbinding2.view;

import android.view.View;

public abstract class ViewScrollChangeEvent
{
  public static ViewScrollChangeEvent create(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new AutoValue_ViewScrollChangeEvent(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public abstract int oldScrollX();
  
  public abstract int oldScrollY();
  
  public abstract int scrollX();
  
  public abstract int scrollY();
  
  public abstract View view();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\ViewScrollChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */