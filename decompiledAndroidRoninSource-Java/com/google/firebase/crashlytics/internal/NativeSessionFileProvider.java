package com.google.firebase.crashlytics.internal;

import java.io.File;

public abstract interface NativeSessionFileProvider
{
  public abstract File getAppFile();
  
  public abstract File getBinaryImagesFile();
  
  public abstract File getDeviceFile();
  
  public abstract File getMetadataFile();
  
  public abstract File getMinidumpFile();
  
  public abstract File getOsFile();
  
  public abstract File getSessionFile();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\NativeSessionFileProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */