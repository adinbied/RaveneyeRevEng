package com.google.firebase.platforminfo;

import kotlin.KotlinVersion;

public final class KotlinDetector
{
  public static String detectVersion()
  {
    try
    {
      String str = KotlinVersion.CURRENT.toString();
      return str;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      for (;;) {}
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\platforminfo\KotlinDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */