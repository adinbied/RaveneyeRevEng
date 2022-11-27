package com.facebook.common.memory;

public enum MemoryTrimType
{
  private double mSuggestedTrimRatio;
  
  static
  {
    OnSystemLowMemoryWhileAppInForeground = new MemoryTrimType("OnSystemLowMemoryWhileAppInForeground", 2, 0.5D);
    OnSystemLowMemoryWhileAppInBackground = new MemoryTrimType("OnSystemLowMemoryWhileAppInBackground", 3, 1.0D);
    MemoryTrimType localMemoryTrimType = new MemoryTrimType("OnAppBackgrounded", 4, 1.0D);
    OnAppBackgrounded = localMemoryTrimType;
    $VALUES = new MemoryTrimType[] { OnCloseToDalvikHeapLimit, OnSystemMemoryCriticallyLowWhileAppInForeground, OnSystemLowMemoryWhileAppInForeground, OnSystemLowMemoryWhileAppInBackground, localMemoryTrimType };
  }
  
  private MemoryTrimType(double paramDouble)
  {
    this.mSuggestedTrimRatio = paramDouble;
  }
  
  public double getSuggestedTrimRatio()
  {
    return this.mSuggestedTrimRatio;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\memory\MemoryTrimType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */