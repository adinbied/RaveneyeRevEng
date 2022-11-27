package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;

public class SimpleImageTranscoderFactory
  implements ImageTranscoderFactory
{
  private final int mMaxBitmapSize;
  
  public SimpleImageTranscoderFactory(int paramInt)
  {
    this.mMaxBitmapSize = paramInt;
  }
  
  public ImageTranscoder createImageTranscoder(ImageFormat paramImageFormat, boolean paramBoolean)
  {
    return new SimpleImageTranscoder(paramBoolean, this.mMaxBitmapSize);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\transcoder\SimpleImageTranscoderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */