package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

class KeyframeSet
{
  TypeEvaluator mEvaluator;
  Keyframe mFirstKeyframe;
  Interpolator mInterpolator;
  ArrayList<Keyframe> mKeyframes;
  Keyframe mLastKeyframe;
  int mNumKeyframes;
  
  public KeyframeSet(Keyframe... paramVarArgs)
  {
    this.mNumKeyframes = paramVarArgs.length;
    ArrayList localArrayList = new ArrayList();
    this.mKeyframes = localArrayList;
    localArrayList.addAll(Arrays.asList(paramVarArgs));
    this.mFirstKeyframe = ((Keyframe)this.mKeyframes.get(0));
    paramVarArgs = (Keyframe)this.mKeyframes.get(this.mNumKeyframes - 1);
    this.mLastKeyframe = paramVarArgs;
    this.mInterpolator = paramVarArgs.getInterpolator();
  }
  
  public static KeyframeSet ofFloat(float... paramVarArgs)
  {
    int j = paramVarArgs.length;
    Keyframe.FloatKeyframe[] arrayOfFloatKeyframe = new Keyframe.FloatKeyframe[Math.max(j, 2)];
    int i = 1;
    if (j == 1)
    {
      arrayOfFloatKeyframe[0] = ((Keyframe.FloatKeyframe)Keyframe.ofFloat(0.0F));
      arrayOfFloatKeyframe[1] = ((Keyframe.FloatKeyframe)Keyframe.ofFloat(1.0F, paramVarArgs[0]));
    }
    else
    {
      arrayOfFloatKeyframe[0] = ((Keyframe.FloatKeyframe)Keyframe.ofFloat(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfFloatKeyframe[i] = ((Keyframe.FloatKeyframe)Keyframe.ofFloat(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
    return new FloatKeyframeSet(arrayOfFloatKeyframe);
  }
  
  public static KeyframeSet ofInt(int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    Keyframe.IntKeyframe[] arrayOfIntKeyframe = new Keyframe.IntKeyframe[Math.max(j, 2)];
    int i = 1;
    if (j == 1)
    {
      arrayOfIntKeyframe[0] = ((Keyframe.IntKeyframe)Keyframe.ofInt(0.0F));
      arrayOfIntKeyframe[1] = ((Keyframe.IntKeyframe)Keyframe.ofInt(1.0F, paramVarArgs[0]));
    }
    else
    {
      arrayOfIntKeyframe[0] = ((Keyframe.IntKeyframe)Keyframe.ofInt(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfIntKeyframe[i] = ((Keyframe.IntKeyframe)Keyframe.ofInt(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
    return new IntKeyframeSet(arrayOfIntKeyframe);
  }
  
  public static KeyframeSet ofKeyframe(Keyframe... paramVarArgs)
  {
    int i2 = paramVarArgs.length;
    int i1 = 0;
    int n = 0;
    int j = 0;
    int m = 0;
    int k = 0;
    int i = 0;
    while (j < i2)
    {
      if ((paramVarArgs[j] instanceof Keyframe.FloatKeyframe)) {
        m = 1;
      } else if ((paramVarArgs[j] instanceof Keyframe.IntKeyframe)) {
        k = 1;
      } else {
        i = 1;
      }
      j += 1;
    }
    Object localObject;
    if ((m != 0) && (k == 0) && (i == 0))
    {
      localObject = new Keyframe.FloatKeyframe[i2];
      i = n;
      while (i < i2)
      {
        localObject[i] = ((Keyframe.FloatKeyframe)paramVarArgs[i]);
        i += 1;
      }
      return new FloatKeyframeSet((Keyframe.FloatKeyframe[])localObject);
    }
    if ((k != 0) && (m == 0) && (i == 0))
    {
      localObject = new Keyframe.IntKeyframe[i2];
      i = i1;
      while (i < i2)
      {
        localObject[i] = ((Keyframe.IntKeyframe)paramVarArgs[i]);
        i += 1;
      }
      return new IntKeyframeSet((Keyframe.IntKeyframe[])localObject);
    }
    return new KeyframeSet(paramVarArgs);
  }
  
  public static KeyframeSet ofObject(Object... paramVarArgs)
  {
    int j = paramVarArgs.length;
    Keyframe.ObjectKeyframe[] arrayOfObjectKeyframe = new Keyframe.ObjectKeyframe[Math.max(j, 2)];
    int i = 1;
    if (j == 1)
    {
      arrayOfObjectKeyframe[0] = ((Keyframe.ObjectKeyframe)Keyframe.ofObject(0.0F));
      arrayOfObjectKeyframe[1] = ((Keyframe.ObjectKeyframe)Keyframe.ofObject(1.0F, paramVarArgs[0]));
    }
    else
    {
      arrayOfObjectKeyframe[0] = ((Keyframe.ObjectKeyframe)Keyframe.ofObject(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfObjectKeyframe[i] = ((Keyframe.ObjectKeyframe)Keyframe.ofObject(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
    return new KeyframeSet(arrayOfObjectKeyframe);
  }
  
  public KeyframeSet clone()
  {
    return null;
  }
  
  public Object getValue(float paramFloat)
  {
    return null;
  }
  
  public void setEvaluator(TypeEvaluator paramTypeEvaluator)
  {
    this.mEvaluator = paramTypeEvaluator;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\nineoldandroids\animation\KeyframeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */