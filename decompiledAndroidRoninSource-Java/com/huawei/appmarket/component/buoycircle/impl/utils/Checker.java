package com.huawei.appmarket.component.buoycircle.impl.utils;

public final class Checker
{
  public static <T> T assertNonNull(T paramT, String paramString)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException(String.valueOf(paramString));
  }
  
  public static <T> T checkNonNull(T paramT, String paramString)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException(String.valueOf(paramString));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\utils\Checker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */