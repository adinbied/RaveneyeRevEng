package com.facebook.drawee.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.ArrayList;

public class MultiDraweeHolder<DH extends DraweeHierarchy>
{
  ArrayList<DraweeHolder<DH>> mHolders = new ArrayList();
  boolean mIsAttached = false;
  
  public void add(int paramInt, DraweeHolder<DH> paramDraweeHolder)
  {
    Preconditions.checkNotNull(paramDraweeHolder);
    Preconditions.checkElementIndex(paramInt, this.mHolders.size() + 1);
    this.mHolders.add(paramInt, paramDraweeHolder);
    if (this.mIsAttached) {
      paramDraweeHolder.onAttach();
    }
  }
  
  public void add(DraweeHolder<DH> paramDraweeHolder)
  {
    add(this.mHolders.size(), paramDraweeHolder);
  }
  
  public void clear()
  {
    if (this.mIsAttached)
    {
      int i = 0;
      while (i < this.mHolders.size())
      {
        ((DraweeHolder)this.mHolders.get(i)).onDetach();
        i += 1;
      }
    }
    this.mHolders.clear();
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = 0;
    while (i < this.mHolders.size())
    {
      Drawable localDrawable = get(i).getTopLevelDrawable();
      if (localDrawable != null) {
        localDrawable.draw(paramCanvas);
      }
      i += 1;
    }
  }
  
  public DraweeHolder<DH> get(int paramInt)
  {
    return (DraweeHolder)this.mHolders.get(paramInt);
  }
  
  public void onAttach()
  {
    if (this.mIsAttached) {
      return;
    }
    this.mIsAttached = true;
    int i = 0;
    while (i < this.mHolders.size())
    {
      ((DraweeHolder)this.mHolders.get(i)).onAttach();
      i += 1;
    }
  }
  
  public void onDetach()
  {
    if (!this.mIsAttached) {
      return;
    }
    int i = 0;
    this.mIsAttached = false;
    while (i < this.mHolders.size())
    {
      ((DraweeHolder)this.mHolders.get(i)).onDetach();
      i += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    while (i < this.mHolders.size())
    {
      if (((DraweeHolder)this.mHolders.get(i)).onTouchEvent(paramMotionEvent)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void remove(int paramInt)
  {
    DraweeHolder localDraweeHolder = (DraweeHolder)this.mHolders.get(paramInt);
    if (this.mIsAttached) {
      localDraweeHolder.onDetach();
    }
    this.mHolders.remove(paramInt);
  }
  
  public int size()
  {
    return this.mHolders.size();
  }
  
  public boolean verifyDrawable(Drawable paramDrawable)
  {
    int i = 0;
    while (i < this.mHolders.size())
    {
      if (paramDrawable == get(i).getTopLevelDrawable()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\view\MultiDraweeHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */