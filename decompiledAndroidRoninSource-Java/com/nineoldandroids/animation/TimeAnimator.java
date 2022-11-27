package com.nineoldandroids.animation;

public class TimeAnimator
  extends ValueAnimator
{
  private TimeListener mListener;
  private long mPreviousTime = -1L;
  
  void animateValue(float paramFloat) {}
  
  boolean animationFrame(long paramLong)
  {
    return false;
  }
  
  void initAnimation() {}
  
  public void setTimeListener(TimeListener paramTimeListener)
  {
    this.mListener = paramTimeListener;
  }
  
  public static abstract interface TimeListener
  {
    public abstract void onTimeUpdate(TimeAnimator paramTimeAnimator, long paramLong1, long paramLong2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\nineoldandroids\animation\TimeAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */