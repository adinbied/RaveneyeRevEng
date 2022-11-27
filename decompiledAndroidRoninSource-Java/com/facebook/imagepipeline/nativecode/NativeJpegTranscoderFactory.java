package com.facebook.imagepipeline.nativecode;

import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import javax.annotation.Nullable;

public class NativeJpegTranscoderFactory
  implements ImageTranscoderFactory
{
  private final boolean mEnsureTranscoderLibraryLoaded;
  private final int mMaxBitmapSize;
  private final boolean mUseDownSamplingRatio;
  
  public NativeJpegTranscoderFactory(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mMaxBitmapSize = paramInt;
    this.mUseDownSamplingRatio = paramBoolean1;
    this.mEnsureTranscoderLibraryLoaded = paramBoolean2;
  }
  
  @Nullable
  public ImageTranscoder createImageTranscoder(ImageFormat paramImageFormat, boolean paramBoolean)
  {
    if (paramImageFormat != DefaultImageFormats.JPEG) {
      return null;
    }
    return new NativeJpegTranscoder(paramBoolean, this.mMaxBitmapSize, this.mUseDownSamplingRatio, this.mEnsureTranscoderLibraryLoaded);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\nativecode\NativeJpegTranscoderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */