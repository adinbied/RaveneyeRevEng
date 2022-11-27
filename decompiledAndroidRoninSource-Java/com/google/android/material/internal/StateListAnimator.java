package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

public final class StateListAnimator
{
  private final Animator.AnimatorListener animationListener = new AnimatorListenerAdapter()
  {
    public void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      if (StateListAnimator.this.runningAnimator == paramAnonymousAnimator) {
        StateListAnimator.this.runningAnimator = null;
      }
    }
  };
  private Tuple lastMatch = null;
  ValueAnimator runningAnimator = null;
  private final ArrayList<Tuple> tuples = new ArrayList();
  
  private void cancel()
  {
    ValueAnimator localValueAnimator = this.runningAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.runningAnimator = null;
    }
  }
  
  private void start(Tuple paramTuple)
  {
    paramTuple = paramTuple.animator;
    this.runningAnimator = paramTuple;
    paramTuple.start();
  }
  
  public void addState(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
  {
    paramArrayOfInt = new Tuple(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(this.animationListener);
    this.tuples.add(paramArrayOfInt);
  }
  
  public void jumpToCurrentState()
  {
    ValueAnimator localValueAnimator = this.runningAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.end();
      this.runningAnimator = null;
    }
  }
  
  public void setState(int[] paramArrayOfInt)
  {
    int j = this.tuples.size();
    int i = 0;
    while (i < j)
    {
      localTuple = (Tuple)this.tuples.get(i);
      if (StateSet.stateSetMatches(localTuple.specs, paramArrayOfInt))
      {
        paramArrayOfInt = localTuple;
        break label55;
      }
      i += 1;
    }
    paramArrayOfInt = null;
    label55:
    Tuple localTuple = this.lastMatch;
    if (paramArrayOfInt == localTuple) {
      return;
    }
    if (localTuple != null) {
      cancel();
    }
    this.lastMatch = paramArrayOfInt;
    if (paramArrayOfInt != null) {
      start(paramArrayOfInt);
    }
  }
  
  static class Tuple
  {
    final ValueAnimator animator;
    final int[] specs;
    
    Tuple(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
    {
      this.specs = paramArrayOfInt;
      this.animator = paramValueAnimator;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\internal\StateListAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */