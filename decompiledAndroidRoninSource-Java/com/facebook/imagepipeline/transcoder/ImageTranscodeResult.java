package com.facebook.imagepipeline.transcoder;

import java.util.Locale;

public class ImageTranscodeResult
{
  private final int mTranscodeStatus;
  
  public ImageTranscodeResult(int paramInt)
  {
    this.mTranscodeStatus = paramInt;
  }
  
  public int getTranscodeStatus()
  {
    return this.mTranscodeStatus;
  }
  
  public String toString()
  {
    return String.format((Locale)null, "Status: %d", new Object[] { Integer.valueOf(this.mTranscodeStatus) });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\transcoder\ImageTranscodeResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */