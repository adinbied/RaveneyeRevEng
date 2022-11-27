package com.google.android.flexbox;

import android.os.Parcelable;

abstract interface FlexItem
  extends Parcelable
{
  public static final float FLEX_BASIS_PERCENT_DEFAULT = -1.0F;
  public static final float FLEX_GROW_DEFAULT = 0.0F;
  public static final float FLEX_SHRINK_DEFAULT = 1.0F;
  public static final float FLEX_SHRINK_NOT_SET = 0.0F;
  public static final int MAX_SIZE = 16777215;
  public static final int ORDER_DEFAULT = 1;
  
  public abstract int getAlignSelf();
  
  public abstract float getFlexBasisPercent();
  
  public abstract float getFlexGrow();
  
  public abstract float getFlexShrink();
  
  public abstract int getHeight();
  
  public abstract int getMarginBottom();
  
  public abstract int getMarginEnd();
  
  public abstract int getMarginLeft();
  
  public abstract int getMarginRight();
  
  public abstract int getMarginStart();
  
  public abstract int getMarginTop();
  
  public abstract int getMaxHeight();
  
  public abstract int getMaxWidth();
  
  public abstract int getMinHeight();
  
  public abstract int getMinWidth();
  
  public abstract int getOrder();
  
  public abstract int getWidth();
  
  public abstract boolean isWrapBefore();
  
  public abstract void setAlignSelf(int paramInt);
  
  public abstract void setFlexBasisPercent(float paramFloat);
  
  public abstract void setFlexGrow(float paramFloat);
  
  public abstract void setFlexShrink(float paramFloat);
  
  public abstract void setHeight(int paramInt);
  
  public abstract void setMaxHeight(int paramInt);
  
  public abstract void setMaxWidth(int paramInt);
  
  public abstract void setMinHeight(int paramInt);
  
  public abstract void setMinWidth(int paramInt);
  
  public abstract void setOrder(int paramInt);
  
  public abstract void setWidth(int paramInt);
  
  public abstract void setWrapBefore(boolean paramBoolean);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\flexbox\FlexItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */