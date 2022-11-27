package com.google.firebase.crashlytics.internal;

import java.io.File;

public final class MissingNativeComponent
  implements CrashlyticsNativeComponent
{
  private static final NativeSessionFileProvider MISSING_NATIVE_SESSION_FILE_PROVIDER = new MissingNativeSessionFileProvider(null);
  
  public boolean finalizeSession(String paramString)
  {
    return true;
  }
  
  public NativeSessionFileProvider getSessionFileProvider(String paramString)
  {
    return MISSING_NATIVE_SESSION_FILE_PROVIDER;
  }
  
  public boolean hasCrashDataForSession(String paramString)
  {
    return false;
  }
  
  public boolean openSession(String paramString)
  {
    return true;
  }
  
  public void writeBeginSession(String paramString1, String paramString2, long paramLong) {}
  
  public void writeSessionApp(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6) {}
  
  public void writeSessionDevice(String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt3, String paramString3, String paramString4) {}
  
  public void writeSessionOs(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
  
  private static final class MissingNativeSessionFileProvider
    implements NativeSessionFileProvider
  {
    public File getAppFile()
    {
      return null;
    }
    
    public File getBinaryImagesFile()
    {
      return null;
    }
    
    public File getDeviceFile()
    {
      return null;
    }
    
    public File getMetadataFile()
    {
      return null;
    }
    
    public File getMinidumpFile()
    {
      return null;
    }
    
    public File getOsFile()
    {
      return null;
    }
    
    public File getSessionFile()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\MissingNativeComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */