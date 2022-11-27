package com.facebook.drawee.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import javax.annotation.Nullable;

public class GestureDetector
{
  long mActionDownTime;
  float mActionDownX;
  float mActionDownY;
  @Nullable
  ClickListener mClickListener;
  boolean mIsCapturingGesture;
  boolean mIsClickCandidate;
  final float mSingleTapSlopPx;
  
  public GestureDetector(Context paramContext)
  {
    this.mSingleTapSlopPx = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    init();
  }
  
  public static GestureDetector newInstance(Context paramContext)
  {
    return new GestureDetector(paramContext);
  }
  
  public void init()
  {
    this.mClickListener = null;
    reset();
  }
  
  public boolean isCapturingGesture()
  {
    return this.mIsCapturingGesture;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
          this.mIsCapturingGesture = false;
          this.mIsClickCandidate = false;
          return true;
        }
        if ((Math.abs(paramMotionEvent.getX() - this.mActionDownX) > this.mSingleTapSlopPx) || (Math.abs(paramMotionEvent.getY() - this.mActionDownY) > this.mSingleTapSlopPx))
        {
          this.mIsClickCandidate = false;
          return true;
        }
      }
      else
      {
        this.mIsCapturingGesture = false;
        if ((Math.abs(paramMotionEvent.getX() - this.mActionDownX) > this.mSingleTapSlopPx) || (Math.abs(paramMotionEvent.getY() - this.mActionDownY) > this.mSingleTapSlopPx)) {
          this.mIsClickCandidate = false;
        }
        if ((this.mIsClickCandidate) && (paramMotionEvent.getEventTime() - this.mActionDownTime <= ViewConfiguration.getLongPressTimeout()))
        {
          paramMotionEvent = this.mClickListener;
          if (paramMotionEvent != null) {
            paramMotionEvent.onClick();
          }
        }
        this.mIsClickCandidate = false;
        return true;
      }
    }
    else
    {
      this.mIsCapturingGesture = true;
      this.mIsClickCandidate = true;
      this.mActionDownTime = paramMotionEvent.getEventTime();
      this.mActionDownX = paramMotionEvent.getX();
      this.mActionDownY = paramMotionEvent.getY();
    }
    return true;
  }
  
  public void reset()
  {
    this.mIsCapturingGesture = false;
    this.mIsClickCandidate = false;
  }
  
  public void setClickListener(ClickListener paramClickListener)
  {
    this.mClickListener = paramClickListener;
  }
  
  public static abstract interface ClickListener
  {
    public abstract boolean onClick();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\gestures\GestureDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */