package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.core.NativeCodeSetup;
import com.facebook.imagepipeline.nativecode.NativeImageTranscoderFactory;
import javax.annotation.Nullable;

public class MultiImageTranscoderFactory
  implements ImageTranscoderFactory
{
  private final boolean mEnsureTranscoderLibraryLoaded;
  @Nullable
  private final Integer mImageTranscoderType;
  private final int mMaxBitmapSize;
  @Nullable
  private final ImageTranscoderFactory mPrimaryImageTranscoderFactory;
  private final boolean mUseDownSamplingRatio;
  
  public MultiImageTranscoderFactory(int paramInt, boolean paramBoolean1, @Nullable ImageTranscoderFactory paramImageTranscoderFactory, @Nullable Integer paramInteger, boolean paramBoolean2)
  {
    this.mMaxBitmapSize = paramInt;
    this.mUseDownSamplingRatio = paramBoolean1;
    this.mPrimaryImageTranscoderFactory = paramImageTranscoderFactory;
    this.mImageTranscoderType = paramInteger;
    this.mEnsureTranscoderLibraryLoaded = paramBoolean2;
  }
  
  @Nullable
  private ImageTranscoder getCustomImageTranscoder(ImageFormat paramImageFormat, boolean paramBoolean)
  {
    ImageTranscoderFactory localImageTranscoderFactory = this.mPrimaryImageTranscoderFactory;
    if (localImageTranscoderFactory == null) {
      return null;
    }
    return localImageTranscoderFactory.createImageTranscoder(paramImageFormat, paramBoolean);
  }
  
  @Nullable
  private ImageTranscoder getImageTranscoderWithType(ImageFormat paramImageFormat, boolean paramBoolean)
  {
    Integer localInteger = this.mImageTranscoderType;
    if (localInteger == null) {
      return null;
    }
    int i = localInteger.intValue();
    if (i != 0)
    {
      if (i == 1) {
        return getSimpleImageTranscoder(paramImageFormat, paramBoolean);
      }
      throw new IllegalArgumentException("Invalid ImageTranscoderType");
    }
    return getNativeImageTranscoder(paramImageFormat, paramBoolean);
  }
  
  @Nullable
  private ImageTranscoder getNativeImageTranscoder(ImageFormat paramImageFormat, boolean paramBoolean)
  {
    return NativeImageTranscoderFactory.getNativeImageTranscoderFactory(this.mMaxBitmapSize, this.mUseDownSamplingRatio, this.mEnsureTranscoderLibraryLoaded).createImageTranscoder(paramImageFormat, paramBoolean);
  }
  
  private ImageTranscoder getSimpleImageTranscoder(ImageFormat paramImageFormat, boolean paramBoolean)
  {
    return new SimpleImageTranscoderFactory(this.mMaxBitmapSize).createImageTranscoder(paramImageFormat, paramBoolean);
  }
  
  public ImageTranscoder createImageTranscoder(ImageFormat paramImageFormat, boolean paramBoolean)
  {
    Object localObject2 = getCustomImageTranscoder(paramImageFormat, paramBoolean);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = getImageTranscoderWithType(paramImageFormat, paramBoolean);
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (NativeCodeSetup.getUseNativeCode()) {
        localObject2 = getNativeImageTranscoder(paramImageFormat, paramBoolean);
      }
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = getSimpleImageTranscoder(paramImageFormat, paramBoolean);
    }
    return (ImageTranscoder)localObject1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\transcoder\MultiImageTranscoderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */