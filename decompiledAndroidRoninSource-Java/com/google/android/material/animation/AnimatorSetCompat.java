package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.List;

public class AnimatorSetCompat
{
  public static void playTogether(AnimatorSet paramAnimatorSet, List<Animator> paramList)
  {
    int j = paramList.size();
    long l = 0L;
    int i = 0;
    while (i < j)
    {
      localObject = (Animator)paramList.get(i);
      l = Math.max(l, ((Animator)localObject).getStartDelay() + ((Animator)localObject).getDuration());
      i += 1;
    }
    Object localObject = ValueAnimator.ofInt(new int[] { 0, 0 });
    ((Animator)localObject).setDuration(l);
    paramList.add(0, localObject);
    paramAnimatorSet.playTogether(paramList);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\animation\AnimatorSetCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */