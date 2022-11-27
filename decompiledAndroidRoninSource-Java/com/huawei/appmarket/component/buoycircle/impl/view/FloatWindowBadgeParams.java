package com.huawei.appmarket.component.buoycircle.impl.view;

import android.content.Context;
import android.widget.FrameLayout.LayoutParams;

public class FloatWindowBadgeParams
{
  private int bottomMargin;
  private int height;
  private int leftMargin;
  private int rightMargin;
  private int topMargin;
  private int width;
  
  public int getBottomMargin()
  {
    return this.bottomMargin;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public FrameLayout.LayoutParams getLayoutParams(Context paramContext)
  {
    return null;
  }
  
  public int getLeftMargin()
  {
    return this.leftMargin;
  }
  
  public int getRightMargin()
  {
    return this.rightMargin;
  }
  
  public int getTopMargin()
  {
    return this.topMargin;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void initParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.rightMargin = paramInt3;
    this.leftMargin = paramInt4;
    this.topMargin = paramInt5;
    this.bottomMargin = paramInt6;
  }
  
  public void setBottomMargin(int paramInt)
  {
    this.bottomMargin = paramInt;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setLeftMargin(int paramInt)
  {
    this.leftMargin = paramInt;
  }
  
  public void setRightMargin(int paramInt)
  {
    this.rightMargin = paramInt;
  }
  
  public void setTopMargin(int paramInt)
  {
    this.topMargin = paramInt;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\view\FloatWindowBadgeParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */