package com.squareup.wire;

public final class Wire
{
  public static <T> T get(T paramT1, T paramT2)
  {
    if (paramT1 != null) {
      return paramT1;
    }
    return paramT2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\squareup\wire\Wire.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */