package com.facebook.imagepipeline.nativecode;

public class WebpTranscoderFactory
{
  private static WebpTranscoder sWebpTranscoder;
  public static boolean sWebpTranscoderPresent = false;
  
  static
  {
    try
    {
      sWebpTranscoder = (WebpTranscoder)Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
      sWebpTranscoderPresent = true;
      return;
    }
    finally
    {
      for (;;) {}
    }
  }
  
  public static WebpTranscoder getWebpTranscoder()
  {
    return sWebpTranscoder;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\nativecode\WebpTranscoderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */