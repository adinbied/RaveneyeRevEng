package com.google.android.gms.dynamite;

import dalvik.system.PathClassLoader;

final class zzh
  extends PathClassLoader
{
  zzh(String paramString, ClassLoader paramClassLoader)
  {
    super(paramString, paramClassLoader);
  }
  
  protected final Class<?> loadClass(String paramString, boolean paramBoolean)
    throws ClassNotFoundException
  {
    if ((!paramString.startsWith("java.")) && (!paramString.startsWith("android."))) {}
    try
    {
      Class localClass = findClass(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
    return super.loadClass(paramString, paramBoolean);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\dynamite\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */