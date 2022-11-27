package com.nineoldandroids.animation;

import android.view.animation.Interpolator;

public abstract class Keyframe
  implements Cloneable
{
  float mFraction;
  boolean mHasValue = false;
  private Interpolator mInterpolator = null;
  Class mValueType;
  
  public static Keyframe ofFloat(float paramFloat)
  {
    return new FloatKeyframe(paramFloat);
  }
  
  public static Keyframe ofFloat(float paramFloat1, float paramFloat2)
  {
    return new FloatKeyframe(paramFloat1, paramFloat2);
  }
  
  public static Keyframe ofInt(float paramFloat)
  {
    return new IntKeyframe(paramFloat);
  }
  
  public static Keyframe ofInt(float paramFloat, int paramInt)
  {
    return new IntKeyframe(paramFloat, paramInt);
  }
  
  public static Keyframe ofObject(float paramFloat)
  {
    return new ObjectKeyframe(paramFloat, null);
  }
  
  public static Keyframe ofObject(float paramFloat, Object paramObject)
  {
    return new ObjectKeyframe(paramFloat, paramObject);
  }
  
  public abstract Keyframe clone();
  
  public float getFraction()
  {
    return this.mFraction;
  }
  
  public Interpolator getInterpolator()
  {
    return this.mInterpolator;
  }
  
  public Class getType()
  {
    return this.mValueType;
  }
  
  public abstract Object getValue();
  
  public boolean hasValue()
  {
    return this.mHasValue;
  }
  
  public void setFraction(float paramFloat)
  {
    this.mFraction = paramFloat;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.mInterpolator = paramInterpolator;
  }
  
  public abstract void setValue(Object paramObject);
  
  static class FloatKeyframe
    extends Keyframe
  {
    float mValue;
    
    FloatKeyframe(float paramFloat)
    {
      this.mFraction = paramFloat;
      this.mValueType = Float.TYPE;
    }
    
    FloatKeyframe(float paramFloat1, float paramFloat2)
    {
      this.mFraction = paramFloat1;
      this.mValue = paramFloat2;
      this.mValueType = Float.TYPE;
      this.mHasValue = true;
    }
    
    public FloatKeyframe clone()
    {
      return null;
    }
    
    public float getFloatValue()
    {
      return this.mValue;
    }
    
    public Object getValue()
    {
      return Float.valueOf(this.mValue);
    }
    
    /* Error */
    public void setValue(Object arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static class IntKeyframe
    extends Keyframe
  {
    int mValue;
    
    IntKeyframe(float paramFloat)
    {
      this.mFraction = paramFloat;
      this.mValueType = Integer.TYPE;
    }
    
    IntKeyframe(float paramFloat, int paramInt)
    {
      this.mFraction = paramFloat;
      this.mValue = paramInt;
      this.mValueType = Integer.TYPE;
      this.mHasValue = true;
    }
    
    public IntKeyframe clone()
    {
      return null;
    }
    
    public int getIntValue()
    {
      return this.mValue;
    }
    
    public Object getValue()
    {
      return Integer.valueOf(this.mValue);
    }
    
    /* Error */
    public void setValue(Object arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static class ObjectKeyframe
    extends Keyframe
  {
    Object mValue;
    
    ObjectKeyframe(float paramFloat, Object paramObject)
    {
      this.mFraction = paramFloat;
      this.mValue = paramObject;
      boolean bool;
      if (paramObject != null) {
        bool = true;
      } else {
        bool = false;
      }
      this.mHasValue = bool;
      if (this.mHasValue) {
        paramObject = paramObject.getClass();
      } else {
        paramObject = Object.class;
      }
      this.mValueType = ((Class)paramObject);
    }
    
    public ObjectKeyframe clone()
    {
      return null;
    }
    
    public Object getValue()
    {
      return this.mValue;
    }
    
    public void setValue(Object paramObject)
    {
      this.mValue = paramObject;
      boolean bool;
      if (paramObject != null) {
        bool = true;
      } else {
        bool = false;
      }
      this.mHasValue = bool;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\nineoldandroids\animation\Keyframe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */