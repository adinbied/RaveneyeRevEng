package com.facebook.soloader;

import com.facebook.soloader.nativeloader.NativeLoaderDelegate;
import java.io.IOException;

public class NativeLoaderToSoLoaderDelegate
  implements NativeLoaderDelegate
{
  public String getLibraryPath(String paramString)
    throws IOException
  {
    return SoLoader.getLibraryPath(paramString);
  }
  
  public int getSoSourcesVersion()
  {
    return SoLoader.getSoSourcesVersion();
  }
  
  public boolean loadLibrary(String paramString, int paramInt)
  {
    if ((paramInt & 0x1) != 0) {
      paramInt = 16;
    } else {
      paramInt = 0;
    }
    return SoLoader.loadLibrary(paramString, paramInt | 0x0);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\soloader\NativeLoaderToSoLoaderDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */