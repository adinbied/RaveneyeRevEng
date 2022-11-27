package com.nineoldandroids.view;

import android.animation.Animator;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

class ViewPropertyAnimatorICS
  extends ViewPropertyAnimator
{
  private static final long RETURN_WHEN_NULL = -1L;
  private final WeakReference<android.view.ViewPropertyAnimator> mNative;
  
  ViewPropertyAnimatorICS(View paramView)
  {
    this.mNative = new WeakReference(paramView.animate());
  }
  
  public ViewPropertyAnimator alpha(float paramFloat)
  {
    return null;
  }
  
  public ViewPropertyAnimator alphaBy(float paramFloat)
  {
    return null;
  }
  
  /* Error */
  public void cancel()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public long getDuration()
  {
    return 211330749L;
  }
  
  public long getStartDelay()
  {
    return 211330754L;
  }
  
  public ViewPropertyAnimator rotation(float paramFloat)
  {
    return null;
  }
  
  public ViewPropertyAnimator rotationBy(float paramFloat)
  {
    return null;
  }
  
  public ViewPropertyAnimator rotationX(float paramFloat)
  {
    return null;
  }
  
  public ViewPropertyAnimator rotationXBy(float paramFloat)
  {
    return null;
  }
  
  public ViewPropertyAnimator rotationY(float paramFloat)
  {
    return null;
  }
  
  public ViewPropertyAnimator rotationYBy(float paramFloat)
  {
    return null;
  }
  
  public ViewPropertyAnimator scaleX(float paramFloat)
  {
    return null;
  }
  
  public ViewPropertyAnimator scaleXBy(float paramFloat)
  {
    return null;
  }
  
  public ViewPropertyAnimator scaleY(float paramFloat)
  {
    return null;
  }
  
  public ViewPropertyAnimator scaleYBy(float paramFloat)
  {
    return null;
  }
  
  public ViewPropertyAnimator setDuration(long paramLong)
  {
    return null;
  }
  
  public ViewPropertyAnimator setInterpolator(Interpolator paramInterpolator)
  {
    return null;
  }
  
  public ViewPropertyAnimator setListener(com.nineoldandroids.animation.Animator.AnimatorListener paramAnimatorListener)
  {
    return null;
  }
  
  public ViewPropertyAnimator setStartDelay(long paramLong)
  {
    return null;
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public ViewPropertyAnimator translationX(float paramFloat)
  {
    return null;
  }
  
  public ViewPropertyAnimator translationXBy(float paramFloat)
  {
    return null;
  }
  
  public ViewPropertyAnimator translationY(float paramFloat)
  {
    return null;
  }
  
  public ViewPropertyAnimator translationYBy(float paramFloat)
  {
    return null;
  }
  
  public ViewPropertyAnimator x(float paramFloat)
  {
    return null;
  }
  
  public ViewPropertyAnimator xBy(float paramFloat)
  {
    return null;
  }
  
  public ViewPropertyAnimator y(float paramFloat)
  {
    return null;
  }
  
  public ViewPropertyAnimator yBy(float paramFloat)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\nineoldandroids\view\ViewPropertyAnimatorICS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */