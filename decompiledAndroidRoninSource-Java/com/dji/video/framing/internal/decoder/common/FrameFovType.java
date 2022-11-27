package com.dji.video.framing.internal.decoder.common;

public enum FrameFovType
{
  private static volatile FrameFovType[] values = null;
  private int value;
  
  static
  {
    Narrow = new FrameFovType("Narrow", 1, 2);
    NoGdc = new FrameFovType("NoGdc", 2, 3);
    FrameFovType localFrameFovType = new FrameFovType("Unknown", 3, 255);
    Unknown = localFrameFovType;
    $VALUES = new FrameFovType[] { Wide, Narrow, NoGdc, localFrameFovType };
  }
  
  private FrameFovType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static FrameFovType find(int paramInt)
  {
    if (values == null) {
      values = values();
    }
    FrameFovType[] arrayOfFrameFovType = values;
    int j = arrayOfFrameFovType.length;
    int i = 0;
    while (i < j)
    {
      FrameFovType localFrameFovType = arrayOfFrameFovType[i];
      if (localFrameFovType.value == paramInt) {
        return localFrameFovType;
      }
      i += 1;
    }
    return Unknown;
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\decoder\common\FrameFovType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */