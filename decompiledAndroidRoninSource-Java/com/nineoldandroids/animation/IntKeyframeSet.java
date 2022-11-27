package com.nineoldandroids.animation;

class IntKeyframeSet
  extends KeyframeSet
{
  private int deltaValue;
  private boolean firstTime = true;
  private int firstValue;
  private int lastValue;
  
  public IntKeyframeSet(Keyframe.IntKeyframe... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public IntKeyframeSet clone()
  {
    return null;
  }
  
  public int getIntValue(float paramFloat)
  {
    return 0;
  }
  
  public Object getValue(float paramFloat)
  {
    return Integer.valueOf(getIntValue(paramFloat));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\nineoldandroids\animation\IntKeyframeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */