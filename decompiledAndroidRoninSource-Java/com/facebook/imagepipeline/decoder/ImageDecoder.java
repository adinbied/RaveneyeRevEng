package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;
import javax.annotation.Nonnull;

public abstract interface ImageDecoder
{
  public abstract CloseableImage decode(@Nonnull EncodedImage paramEncodedImage, int paramInt, @Nonnull QualityInfo paramQualityInfo, @Nonnull ImageDecodeOptions paramImageDecodeOptions);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\decoder\ImageDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */