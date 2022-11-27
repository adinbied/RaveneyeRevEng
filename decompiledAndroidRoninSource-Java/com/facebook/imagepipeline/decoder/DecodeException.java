package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.EncodedImage;

public class DecodeException
  extends RuntimeException
{
  private final EncodedImage mEncodedImage;
  
  public DecodeException(String paramString, EncodedImage paramEncodedImage)
  {
    super(paramString);
    this.mEncodedImage = paramEncodedImage;
  }
  
  public DecodeException(String paramString, Throwable paramThrowable, EncodedImage paramEncodedImage)
  {
    super(paramString, paramThrowable);
    this.mEncodedImage = paramEncodedImage;
  }
  
  public EncodedImage getEncodedImage()
  {
    return this.mEncodedImage;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\decoder\DecodeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */