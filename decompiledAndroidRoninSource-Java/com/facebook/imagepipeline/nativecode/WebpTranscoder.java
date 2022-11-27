package com.facebook.imagepipeline.nativecode;

import com.facebook.imageformat.ImageFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface WebpTranscoder
{
  public abstract boolean isWebpNativelySupported(ImageFormat paramImageFormat);
  
  public abstract void transcodeWebpToJpeg(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt)
    throws IOException;
  
  public abstract void transcodeWebpToPng(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\nativecode\WebpTranscoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */