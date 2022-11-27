package com.facebook.imageformat;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ImageFormat
{
  public static final ImageFormat UNKNOWN = new ImageFormat("UNKNOWN", null);
  @Nullable
  private final String mFileExtension;
  private final String mName;
  
  public ImageFormat(String paramString1, @Nullable String paramString2)
  {
    this.mName = paramString1;
    this.mFileExtension = paramString2;
  }
  
  @Nullable
  public String getFileExtension()
  {
    return this.mFileExtension;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String toString()
  {
    return getName();
  }
  
  public static abstract interface FormatChecker
  {
    @Nullable
    public abstract ImageFormat determineFormat(@Nonnull byte[] paramArrayOfByte, int paramInt);
    
    public abstract int getHeaderSize();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imageformat\ImageFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */