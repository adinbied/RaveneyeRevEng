package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;

public class TextScale
  extends Transition
{
  private static final String PROPNAME_SCALE = "android:textscale:scale";
  
  private void captureValues(TransitionValues paramTransitionValues)
  {
    if ((paramTransitionValues.view instanceof TextView))
    {
      TextView localTextView = (TextView)paramTransitionValues.view;
      paramTransitionValues.values.put("android:textscale:scale", Float.valueOf(localTextView.getScaleX()));
    }
  }
  
  public void captureEndValues(TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    final TextView localTextView = null;
    paramViewGroup = localTextView;
    if (paramTransitionValues1 != null)
    {
      paramViewGroup = localTextView;
      if (paramTransitionValues2 != null)
      {
        paramViewGroup = localTextView;
        if ((paramTransitionValues1.view instanceof TextView))
        {
          if (!(paramTransitionValues2.view instanceof TextView)) {
            return null;
          }
          localTextView = (TextView)paramTransitionValues2.view;
          paramViewGroup = paramTransitionValues1.values;
          paramTransitionValues1 = paramTransitionValues2.values;
          paramTransitionValues2 = paramViewGroup.get("android:textscale:scale");
          float f2 = 1.0F;
          float f1;
          if (paramTransitionValues2 != null) {
            f1 = ((Float)paramViewGroup.get("android:textscale:scale")).floatValue();
          } else {
            f1 = 1.0F;
          }
          if (paramTransitionValues1.get("android:textscale:scale") != null) {
            f2 = ((Float)paramTransitionValues1.get("android:textscale:scale")).floatValue();
          }
          if (f1 == f2) {
            return null;
          }
          paramViewGroup = ValueAnimator.ofFloat(new float[] { f1, f2 });
          paramViewGroup.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
            {
              float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
              localTextView.setScaleX(f);
              localTextView.setScaleY(f);
            }
          });
        }
      }
    }
    return paramViewGroup;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\internal\TextScale.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */