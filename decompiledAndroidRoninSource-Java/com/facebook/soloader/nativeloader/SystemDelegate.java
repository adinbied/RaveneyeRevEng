package com.facebook.soloader.nativeloader;

public class SystemDelegate
  implements NativeLoaderDelegate
{
  public String getLibraryPath(String paramString)
  {
    return null;
  }
  
  public int getSoSourcesVersion()
  {
    return 0;
  }
  
  public boolean loadLibrary(String paramString, int paramInt)
  {
    System.loadLibrary(paramString);
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\soloader\nativeloader\SystemDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */