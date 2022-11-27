package com.facebook.soloader.nativeloader;

import java.io.IOException;

public abstract interface NativeLoaderDelegate
{
  public static final int SKIP_MERGED_JNI_ONLOAD = 1;
  
  public abstract String getLibraryPath(String paramString)
    throws IOException;
  
  public abstract int getSoSourcesVersion();
  
  public abstract boolean loadLibrary(String paramString, int paramInt);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\soloader\nativeloader\NativeLoaderDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */