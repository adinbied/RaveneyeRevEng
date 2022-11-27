package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Preconditions;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.transcoder.DownsampleUtil;
import com.facebook.imagepipeline.transcoder.ImageTranscodeResult;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

public class NativeJpegTranscoder
  implements ImageTranscoder
{
  public static final String TAG = "NativeJpegTranscoder";
  private int mMaxBitmapSize;
  private boolean mResizingEnabled;
  private boolean mUseDownsamplingRatio;
  
  public NativeJpegTranscoder(boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mResizingEnabled = paramBoolean1;
    this.mMaxBitmapSize = paramInt;
    this.mUseDownsamplingRatio = paramBoolean2;
    if (paramBoolean3) {
      NativeJpegTranscoderSoLoader.ensure();
    }
  }
  
  private static native void nativeTranscodeJpeg(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3)
    throws IOException;
  
  private static native void nativeTranscodeJpegWithExifOrientation(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3)
    throws IOException;
  
  public static void transcodeJpeg(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    NativeJpegTranscoderSoLoader.ensure();
    boolean bool2 = false;
    boolean bool1;
    if (paramInt2 >= 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramInt2 <= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramInt3 >= 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramInt3 <= 100) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    Preconditions.checkArgument(JpegTranscoderUtils.isRotationAngleAllowed(paramInt1));
    if (paramInt2 == 8)
    {
      bool1 = bool2;
      if (paramInt1 == 0) {}
    }
    else
    {
      bool1 = true;
    }
    Preconditions.checkArgument(bool1, "no transformation requested");
    nativeTranscodeJpeg((InputStream)Preconditions.checkNotNull(paramInputStream), (OutputStream)Preconditions.checkNotNull(paramOutputStream), paramInt1, paramInt2, paramInt3);
  }
  
  public static void transcodeJpegWithExifOrientation(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    NativeJpegTranscoderSoLoader.ensure();
    boolean bool2 = false;
    boolean bool1;
    if (paramInt2 >= 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramInt2 <= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramInt3 >= 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramInt3 <= 100) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    Preconditions.checkArgument(JpegTranscoderUtils.isExifOrientationAllowed(paramInt1));
    if (paramInt2 == 8)
    {
      bool1 = bool2;
      if (paramInt1 == 1) {}
    }
    else
    {
      bool1 = true;
    }
    Preconditions.checkArgument(bool1, "no transformation requested");
    nativeTranscodeJpegWithExifOrientation((InputStream)Preconditions.checkNotNull(paramInputStream), (OutputStream)Preconditions.checkNotNull(paramOutputStream), paramInt1, paramInt2, paramInt3);
  }
  
  public boolean canResize(EncodedImage paramEncodedImage, @Nullable RotationOptions paramRotationOptions, @Nullable ResizeOptions paramResizeOptions)
  {
    RotationOptions localRotationOptions = paramRotationOptions;
    if (paramRotationOptions == null) {
      localRotationOptions = RotationOptions.autoRotate();
    }
    return JpegTranscoderUtils.getSoftwareNumerator(localRotationOptions, paramResizeOptions, paramEncodedImage, this.mResizingEnabled) < 8;
  }
  
  public boolean canTranscode(ImageFormat paramImageFormat)
  {
    return paramImageFormat == DefaultImageFormats.JPEG;
  }
  
  public String getIdentifier()
  {
    return "NativeJpegTranscoder";
  }
  
  public ImageTranscodeResult transcode(EncodedImage paramEncodedImage, OutputStream paramOutputStream, @Nullable RotationOptions paramRotationOptions, @Nullable ResizeOptions paramResizeOptions, @Nullable ImageFormat paramImageFormat, @Nullable Integer paramInteger)
    throws IOException
  {
    paramImageFormat = paramInteger;
    if (paramInteger == null) {
      paramImageFormat = Integer.valueOf(85);
    }
    paramInteger = paramRotationOptions;
    if (paramRotationOptions == null) {
      paramInteger = RotationOptions.autoRotate();
    }
    int k = DownsampleUtil.determineSampleSize(paramInteger, paramResizeOptions, paramEncodedImage, this.mMaxBitmapSize);
    Object localObject = null;
    paramRotationOptions = (RotationOptions)localObject;
    try
    {
      int i = JpegTranscoderUtils.getSoftwareNumerator(paramInteger, paramResizeOptions, paramEncodedImage, this.mResizingEnabled);
      paramRotationOptions = (RotationOptions)localObject;
      int j = JpegTranscoderUtils.calculateDownsampleNumerator(k);
      paramRotationOptions = (RotationOptions)localObject;
      if (this.mUseDownsamplingRatio) {
        i = j;
      }
      paramRotationOptions = (RotationOptions)localObject;
      paramResizeOptions = paramEncodedImage.getInputStream();
      paramRotationOptions = paramResizeOptions;
      if (JpegTranscoderUtils.INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(paramEncodedImage.getExifOrientation())))
      {
        paramRotationOptions = paramResizeOptions;
        transcodeJpegWithExifOrientation(paramResizeOptions, paramOutputStream, JpegTranscoderUtils.getForceRotatedInvertedExifOrientation(paramInteger, paramEncodedImage), i, paramImageFormat.intValue());
      }
      else
      {
        paramRotationOptions = paramResizeOptions;
        transcodeJpeg(paramResizeOptions, paramOutputStream, JpegTranscoderUtils.getRotationAngle(paramInteger, paramEncodedImage), i, paramImageFormat.intValue());
      }
      Closeables.closeQuietly(paramResizeOptions);
      i = 1;
      if (k != 1) {
        i = 0;
      }
      return new ImageTranscodeResult(i);
    }
    finally
    {
      Closeables.closeQuietly(paramRotationOptions);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\nativecode\NativeJpegTranscoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */