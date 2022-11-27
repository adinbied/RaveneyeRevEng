package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

public abstract class Animator
  implements Cloneable
{
  ArrayList<AnimatorListener> mListeners = null;
  
  /* Error */
  public void addListener(AnimatorListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void cancel() {}
  
  public Animator clone()
  {
    return null;
  }
  
  public void end() {}
  
  public abstract long getDuration();
  
  public ArrayList<AnimatorListener> getListeners()
  {
    return this.mListeners;
  }
  
  public abstract long getStartDelay();
  
  public abstract boolean isRunning();
  
  public boolean isStarted()
  {
    return isRunning();
  }
  
  /* Error */
  public void removeAllListeners()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void removeListener(AnimatorListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public abstract Animator setDuration(long paramLong);
  
  public abstract void setInterpolator(Interpolator paramInterpolator);
  
  public abstract void setStartDelay(long paramLong);
  
  public void setTarget(Object paramObject) {}
  
  public void setupEndValues() {}
  
  public void setupStartValues() {}
  
  public void start() {}
  
  public static abstract interface AnimatorListener
  {
    public abstract void onAnimationCancel(Animator paramAnimator);
    
    public abstract void onAnimationEnd(Animator paramAnimator);
    
    public abstract void onAnimationRepeat(Animator paramAnimator);
    
    public abstract void onAnimationStart(Animator paramAnimator);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\nineoldandroids\animation\Animator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */