package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;
import javax.annotation.Nullable;

public abstract interface ImageTranscoderFactory
{
  @Nullable
  public abstract ImageTranscoder createImageTranscoder(ImageFormat paramImageFormat, boolean paramBoolean);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\transcoder\ImageTranscoderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */