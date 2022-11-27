package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.Nullable;

public abstract interface ImageTranscoder
{
  public abstract boolean canResize(EncodedImage paramEncodedImage, @Nullable RotationOptions paramRotationOptions, @Nullable ResizeOptions paramResizeOptions);
  
  public abstract boolean canTranscode(ImageFormat paramImageFormat);
  
  public abstract String getIdentifier();
  
  public abstract ImageTranscodeResult transcode(EncodedImage paramEncodedImage, OutputStream paramOutputStream, @Nullable RotationOptions paramRotationOptions, @Nullable ResizeOptions paramResizeOptions, @Nullable ImageFormat paramImageFormat, @Nullable Integer paramInteger)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\transcoder\ImageTranscoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */