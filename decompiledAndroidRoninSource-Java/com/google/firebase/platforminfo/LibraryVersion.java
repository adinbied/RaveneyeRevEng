package com.google.firebase.platforminfo;

import javax.annotation.Nonnull;

abstract class LibraryVersion
{
  static LibraryVersion create(String paramString1, String paramString2)
  {
    return new AutoValue_LibraryVersion(paramString1, paramString2);
  }
  
  @Nonnull
  public abstract String getLibraryName();
  
  @Nonnull
  public abstract String getVersion();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\platforminfo\LibraryVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */