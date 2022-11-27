package com.facebook.soloader;

import android.os.StrictMode.ThreadPolicy;
import java.io.File;

public class NoopSoSource
  extends SoSource
{
  public int loadLibrary(String paramString, int paramInt, StrictMode.ThreadPolicy paramThreadPolicy)
  {
    return 1;
  }
  
  public File unpackLibrary(String paramString)
  {
    throw new UnsupportedOperationException("unpacking not supported in test mode");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\soloader\NoopSoSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */