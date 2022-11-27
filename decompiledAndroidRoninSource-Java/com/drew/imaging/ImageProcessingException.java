package com.drew.imaging;

import com.drew.lang.CompoundException;

public class ImageProcessingException
  extends CompoundException
{
  private static final long serialVersionUID = -9115669182209912676L;
  
  public ImageProcessingException(String paramString)
  {
    super(paramString);
  }
  
  public ImageProcessingException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public ImageProcessingException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\ImageProcessingException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */