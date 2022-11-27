package com.google.android.flexbox;

import android.view.View;
import java.util.List;

abstract interface FlexContainer
{
  public static final int NOT_SET = -1;
  
  public abstract void addView(View paramView);
  
  public abstract void addView(View paramView, int paramInt);
  
  public abstract int getAlignContent();
  
  public abstract int getAlignItems();
  
  public abstract int getChildHeightMeasureSpec(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int getChildWidthMeasureSpec(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int getDecorationLengthCrossAxis(View paramView);
  
  public abstract int getDecorationLengthMainAxis(View paramView, int paramInt1, int paramInt2);
  
  public abstract int getFlexDirection();
  
  public abstract View getFlexItemAt(int paramInt);
  
  public abstract int getFlexItemCount();
  
  public abstract List<FlexLine> getFlexLines();
  
  public abstract List<FlexLine> getFlexLinesInternal();
  
  public abstract int getFlexWrap();
  
  public abstract int getJustifyContent();
  
  public abstract int getLargestMainSize();
  
  public abstract int getMaxLine();
  
  public abstract int getPaddingBottom();
  
  public abstract int getPaddingEnd();
  
  public abstract int getPaddingLeft();
  
  public abstract int getPaddingRight();
  
  public abstract int getPaddingStart();
  
  public abstract int getPaddingTop();
  
  public abstract View getReorderedFlexItemAt(int paramInt);
  
  public abstract int getSumOfCrossSize();
  
  public abstract boolean isMainAxisDirectionHorizontal();
  
  public abstract void onNewFlexItemAdded(View paramView, int paramInt1, int paramInt2, FlexLine paramFlexLine);
  
  public abstract void onNewFlexLineAdded(FlexLine paramFlexLine);
  
  public abstract void removeAllViews();
  
  public abstract void removeViewAt(int paramInt);
  
  public abstract void setAlignContent(int paramInt);
  
  public abstract void setAlignItems(int paramInt);
  
  public abstract void setFlexDirection(int paramInt);
  
  public abstract void setFlexLines(List<FlexLine> paramList);
  
  public abstract void setFlexWrap(int paramInt);
  
  public abstract void setJustifyContent(int paramInt);
  
  public abstract void setMaxLine(int paramInt);
  
  public abstract void updateViewCache(int paramInt, View paramView);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\flexbox\FlexContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */