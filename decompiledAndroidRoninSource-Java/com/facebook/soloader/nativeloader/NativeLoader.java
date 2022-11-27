package com.facebook.soloader.nativeloader;

import java.io.IOException;

public class NativeLoader
{
  private static NativeLoaderDelegate sDelegate;
  
  public static String getLibraryPath(String paramString)
    throws IOException
  {
    try
    {
      if (sDelegate != null) {
        return sDelegate.getLibraryPath(paramString);
      }
      throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
    }
    finally {}
  }
  
  public static int getSoSourcesVersion()
  {
    try
    {
      if (sDelegate != null) {
        return sDelegate.getSoSourcesVersion();
      }
      throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
    }
    finally {}
  }
  
  public static void init(NativeLoaderDelegate paramNativeLoaderDelegate)
  {
    try
    {
      if (sDelegate == null)
      {
        sDelegate = paramNativeLoaderDelegate;
        return;
      }
      throw new IllegalStateException("Cannot re-initialize NativeLoader.");
    }
    finally {}
  }
  
  public static boolean isInitialized()
  {
    try
    {
      NativeLoaderDelegate localNativeLoaderDelegate = sDelegate;
      boolean bool;
      if (localNativeLoaderDelegate != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static boolean loadLibrary(String paramString)
  {
    return loadLibrary(paramString, 0);
  }
  
  public static boolean loadLibrary(String paramString, int paramInt)
  {
    try
    {
      if (sDelegate != null) {
        return sDelegate.loadLibrary(paramString, paramInt);
      }
      throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\soloader\nativeloader\NativeLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */