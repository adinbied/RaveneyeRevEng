package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import java.util.Map;
import javax.annotation.Nullable;

public class DefaultImageDecoder
  implements ImageDecoder
{
  private final ImageDecoder mAnimatedGifDecoder;
  private final ImageDecoder mAnimatedWebPDecoder;
  @Nullable
  private final Map<ImageFormat, ImageDecoder> mCustomDecoders;
  private final ImageDecoder mDefaultDecoder = new ImageDecoder()
  {
    public CloseableImage decode(EncodedImage paramAnonymousEncodedImage, int paramAnonymousInt, QualityInfo paramAnonymousQualityInfo, ImageDecodeOptions paramAnonymousImageDecodeOptions)
    {
      ImageFormat localImageFormat = paramAnonymousEncodedImage.getImageFormat();
      if (localImageFormat == DefaultImageFormats.JPEG) {
        return DefaultImageDecoder.this.decodeJpeg(paramAnonymousEncodedImage, paramAnonymousInt, paramAnonymousQualityInfo, paramAnonymousImageDecodeOptions);
      }
      if (localImageFormat == DefaultImageFormats.GIF) {
        return DefaultImageDecoder.this.decodeGif(paramAnonymousEncodedImage, paramAnonymousInt, paramAnonymousQualityInfo, paramAnonymousImageDecodeOptions);
      }
      if (localImageFormat == DefaultImageFormats.WEBP_ANIMATED) {
        return DefaultImageDecoder.this.decodeAnimatedWebp(paramAnonymousEncodedImage, paramAnonymousInt, paramAnonymousQualityInfo, paramAnonymousImageDecodeOptions);
      }
      if (localImageFormat != ImageFormat.UNKNOWN) {
        return DefaultImageDecoder.this.decodeStaticImage(paramAnonymousEncodedImage, paramAnonymousImageDecodeOptions);
      }
      throw new DecodeException("unknown image format", paramAnonymousEncodedImage);
    }
  };
  private final PlatformDecoder mPlatformDecoder;
  
  public DefaultImageDecoder(ImageDecoder paramImageDecoder1, ImageDecoder paramImageDecoder2, PlatformDecoder paramPlatformDecoder)
  {
    this(paramImageDecoder1, paramImageDecoder2, paramPlatformDecoder, null);
  }
  
  public DefaultImageDecoder(ImageDecoder paramImageDecoder1, ImageDecoder paramImageDecoder2, PlatformDecoder paramPlatformDecoder, @Nullable Map<ImageFormat, ImageDecoder> paramMap)
  {
    this.mAnimatedGifDecoder = paramImageDecoder1;
    this.mAnimatedWebPDecoder = paramImageDecoder2;
    this.mPlatformDecoder = paramPlatformDecoder;
    this.mCustomDecoders = paramMap;
  }
  
  private void maybeApplyTransformation(@Nullable BitmapTransformation paramBitmapTransformation, CloseableReference<Bitmap> paramCloseableReference)
  {
    if (paramBitmapTransformation == null) {
      return;
    }
    paramCloseableReference = (Bitmap)paramCloseableReference.get();
    if ((Build.VERSION.SDK_INT >= 12) && (paramBitmapTransformation.modifiesTransparency())) {
      paramCloseableReference.setHasAlpha(true);
    }
    paramBitmapTransformation.transform(paramCloseableReference);
  }
  
  public CloseableImage decode(EncodedImage paramEncodedImage, int paramInt, QualityInfo paramQualityInfo, ImageDecodeOptions paramImageDecodeOptions)
  {
    if (paramImageDecodeOptions.customImageDecoder != null) {
      return paramImageDecodeOptions.customImageDecoder.decode(paramEncodedImage, paramInt, paramQualityInfo, paramImageDecodeOptions);
    }
    Object localObject2 = paramEncodedImage.getImageFormat();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2 != ImageFormat.UNKNOWN) {}
    }
    else
    {
      localObject1 = ImageFormatChecker.getImageFormat_WrapIOException(paramEncodedImage.getInputStream());
      paramEncodedImage.setImageFormat((ImageFormat)localObject1);
    }
    localObject2 = this.mCustomDecoders;
    if (localObject2 != null)
    {
      localObject1 = (ImageDecoder)((Map)localObject2).get(localObject1);
      if (localObject1 != null) {
        return ((ImageDecoder)localObject1).decode(paramEncodedImage, paramInt, paramQualityInfo, paramImageDecodeOptions);
      }
    }
    return this.mDefaultDecoder.decode(paramEncodedImage, paramInt, paramQualityInfo, paramImageDecodeOptions);
  }
  
  public CloseableImage decodeAnimatedWebp(EncodedImage paramEncodedImage, int paramInt, QualityInfo paramQualityInfo, ImageDecodeOptions paramImageDecodeOptions)
  {
    return this.mAnimatedWebPDecoder.decode(paramEncodedImage, paramInt, paramQualityInfo, paramImageDecodeOptions);
  }
  
  public CloseableImage decodeGif(EncodedImage paramEncodedImage, int paramInt, QualityInfo paramQualityInfo, ImageDecodeOptions paramImageDecodeOptions)
  {
    if ((paramEncodedImage.getWidth() != -1) && (paramEncodedImage.getHeight() != -1))
    {
      if (!paramImageDecodeOptions.forceStaticImage)
      {
        ImageDecoder localImageDecoder = this.mAnimatedGifDecoder;
        if (localImageDecoder != null) {
          return localImageDecoder.decode(paramEncodedImage, paramInt, paramQualityInfo, paramImageDecodeOptions);
        }
      }
      return decodeStaticImage(paramEncodedImage, paramImageDecodeOptions);
    }
    throw new DecodeException("image width or height is incorrect", paramEncodedImage);
  }
  
  public CloseableStaticBitmap decodeJpeg(EncodedImage paramEncodedImage, int paramInt, QualityInfo paramQualityInfo, ImageDecodeOptions paramImageDecodeOptions)
  {
    CloseableReference localCloseableReference = this.mPlatformDecoder.decodeJPEGFromEncodedImageWithColorSpace(paramEncodedImage, paramImageDecodeOptions.bitmapConfig, null, paramInt, paramImageDecodeOptions.colorSpace);
    try
    {
      maybeApplyTransformation(paramImageDecodeOptions.bitmapTransformation, localCloseableReference);
      paramEncodedImage = new CloseableStaticBitmap(localCloseableReference, paramQualityInfo, paramEncodedImage.getRotationAngle(), paramEncodedImage.getExifOrientation());
      return paramEncodedImage;
    }
    finally
    {
      localCloseableReference.close();
    }
  }
  
  public CloseableStaticBitmap decodeStaticImage(EncodedImage paramEncodedImage, ImageDecodeOptions paramImageDecodeOptions)
  {
    CloseableReference localCloseableReference = this.mPlatformDecoder.decodeFromEncodedImageWithColorSpace(paramEncodedImage, paramImageDecodeOptions.bitmapConfig, null, paramImageDecodeOptions.colorSpace);
    try
    {
      maybeApplyTransformation(paramImageDecodeOptions.bitmapTransformation, localCloseableReference);
      paramEncodedImage = new CloseableStaticBitmap(localCloseableReference, ImmutableQualityInfo.FULL_QUALITY, paramEncodedImage.getRotationAngle(), paramEncodedImage.getExifOrientation());
      return paramEncodedImage;
    }
    finally
    {
      localCloseableReference.close();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\decoder\DefaultImageDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */