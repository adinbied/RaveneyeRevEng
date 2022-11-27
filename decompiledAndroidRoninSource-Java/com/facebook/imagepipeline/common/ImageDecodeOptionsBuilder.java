package com.facebook.imagepipeline.common;

import android.graphics.Bitmap.Config;
import android.graphics.ColorSpace;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import javax.annotation.Nullable;

public class ImageDecodeOptionsBuilder<T extends ImageDecodeOptionsBuilder>
{
  private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;
  @Nullable
  private BitmapTransformation mBitmapTransformation;
  @Nullable
  private ColorSpace mColorSpace;
  @Nullable
  private ImageDecoder mCustomImageDecoder;
  private boolean mDecodeAllFrames;
  private boolean mDecodePreviewFrame;
  private boolean mForceStaticImage;
  private int mMaxDimensionPx = Integer.MAX_VALUE;
  private int mMinDecodeIntervalMs = 100;
  private boolean mUseLastFrameForPreview;
  
  public ImageDecodeOptions build()
  {
    return new ImageDecodeOptions(this);
  }
  
  public Bitmap.Config getBitmapConfig()
  {
    return this.mBitmapConfig;
  }
  
  @Nullable
  public BitmapTransformation getBitmapTransformation()
  {
    return this.mBitmapTransformation;
  }
  
  @Nullable
  public ColorSpace getColorSpace()
  {
    return this.mColorSpace;
  }
  
  @Nullable
  public ImageDecoder getCustomImageDecoder()
  {
    return this.mCustomImageDecoder;
  }
  
  public boolean getDecodeAllFrames()
  {
    return this.mDecodeAllFrames;
  }
  
  public boolean getDecodePreviewFrame()
  {
    return this.mDecodePreviewFrame;
  }
  
  public boolean getForceStaticImage()
  {
    return this.mForceStaticImage;
  }
  
  public int getMaxDimensionPx()
  {
    return this.mMaxDimensionPx;
  }
  
  public int getMinDecodeIntervalMs()
  {
    return this.mMinDecodeIntervalMs;
  }
  
  protected T getThis()
  {
    return this;
  }
  
  public boolean getUseLastFrameForPreview()
  {
    return this.mUseLastFrameForPreview;
  }
  
  public T setBitmapConfig(Bitmap.Config paramConfig)
  {
    this.mBitmapConfig = paramConfig;
    return getThis();
  }
  
  public T setBitmapTransformation(@Nullable BitmapTransformation paramBitmapTransformation)
  {
    this.mBitmapTransformation = paramBitmapTransformation;
    return getThis();
  }
  
  public T setColorSpace(ColorSpace paramColorSpace)
  {
    this.mColorSpace = paramColorSpace;
    return getThis();
  }
  
  public T setCustomImageDecoder(@Nullable ImageDecoder paramImageDecoder)
  {
    this.mCustomImageDecoder = paramImageDecoder;
    return getThis();
  }
  
  public T setDecodeAllFrames(boolean paramBoolean)
  {
    this.mDecodeAllFrames = paramBoolean;
    return getThis();
  }
  
  public T setDecodePreviewFrame(boolean paramBoolean)
  {
    this.mDecodePreviewFrame = paramBoolean;
    return getThis();
  }
  
  public T setForceStaticImage(boolean paramBoolean)
  {
    this.mForceStaticImage = paramBoolean;
    return getThis();
  }
  
  public ImageDecodeOptionsBuilder setFrom(ImageDecodeOptions paramImageDecodeOptions)
  {
    this.mMinDecodeIntervalMs = paramImageDecodeOptions.minDecodeIntervalMs;
    this.mMaxDimensionPx = paramImageDecodeOptions.maxDimensionPx;
    this.mDecodePreviewFrame = paramImageDecodeOptions.decodePreviewFrame;
    this.mUseLastFrameForPreview = paramImageDecodeOptions.useLastFrameForPreview;
    this.mDecodeAllFrames = paramImageDecodeOptions.decodeAllFrames;
    this.mForceStaticImage = paramImageDecodeOptions.forceStaticImage;
    this.mBitmapConfig = paramImageDecodeOptions.bitmapConfig;
    this.mCustomImageDecoder = paramImageDecodeOptions.customImageDecoder;
    this.mBitmapTransformation = paramImageDecodeOptions.bitmapTransformation;
    this.mColorSpace = paramImageDecodeOptions.colorSpace;
    return getThis();
  }
  
  public T setMaxDimensionPx(int paramInt)
  {
    this.mMaxDimensionPx = paramInt;
    return getThis();
  }
  
  public T setMinDecodeIntervalMs(int paramInt)
  {
    this.mMinDecodeIntervalMs = paramInt;
    return getThis();
  }
  
  public T setUseLastFrameForPreview(boolean paramBoolean)
  {
    this.mUseLastFrameForPreview = paramBoolean;
    return getThis();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\common\ImageDecodeOptionsBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */