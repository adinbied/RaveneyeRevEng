package com.facebook.drawee.drawable;

public abstract interface Rounded
{
  public abstract int getBorderColor();
  
  public abstract float getBorderWidth();
  
  public abstract float getPadding();
  
  public abstract boolean getPaintFilterBitmap();
  
  public abstract float[] getRadii();
  
  public abstract boolean getScaleDownInsideBorders();
  
  public abstract boolean isCircle();
  
  public abstract void setBorder(int paramInt, float paramFloat);
  
  public abstract void setCircle(boolean paramBoolean);
  
  public abstract void setPadding(float paramFloat);
  
  public abstract void setPaintFilterBitmap(boolean paramBoolean);
  
  public abstract void setRadii(float[] paramArrayOfFloat);
  
  public abstract void setRadius(float paramFloat);
  
  public abstract void setScaleDownInsideBorders(boolean paramBoolean);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\drawable\Rounded.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */