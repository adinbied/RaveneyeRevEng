package com.google.android.gms.common.util;

import android.os.Build.VERSION;
import androidx.core.os.BuildCompat;

public final class PlatformVersion
{
  public static boolean isAtLeastHoneycomb()
  {
    return true;
  }
  
  public static boolean isAtLeastHoneycombMR1()
  {
    return true;
  }
  
  public static boolean isAtLeastIceCreamSandwich()
  {
    return true;
  }
  
  public static boolean isAtLeastIceCreamSandwichMR1()
  {
    return true;
  }
  
  public static boolean isAtLeastJellyBean()
  {
    return true;
  }
  
  public static boolean isAtLeastJellyBeanMR1()
  {
    return Build.VERSION.SDK_INT >= 17;
  }
  
  public static boolean isAtLeastJellyBeanMR2()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
  
  public static boolean isAtLeastKitKat()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public static boolean isAtLeastKitKatWatch()
  {
    return Build.VERSION.SDK_INT >= 20;
  }
  
  public static boolean isAtLeastLollipop()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public static boolean isAtLeastLollipopMR1()
  {
    return Build.VERSION.SDK_INT >= 22;
  }
  
  public static boolean isAtLeastM()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  public static boolean isAtLeastN()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
  
  public static boolean isAtLeastO()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  public static boolean isAtLeastP()
  {
    return Build.VERSION.SDK_INT >= 28;
  }
  
  public static boolean isAtLeastQ()
  {
    if ((!BuildCompat.isAtLeastQ()) && ((!Build.VERSION.CODENAME.equals("REL")) || (Build.VERSION.SDK_INT < 29))) {
      return (Build.VERSION.CODENAME.length() == 1) && (Build.VERSION.CODENAME.charAt(0) >= 'Q') && (Build.VERSION.CODENAME.charAt(0) <= 'Z');
    }
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\commo\\util\PlatformVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */