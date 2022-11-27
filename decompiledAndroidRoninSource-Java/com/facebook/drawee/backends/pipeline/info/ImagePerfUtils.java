package com.facebook.drawee.backends.pipeline.info;

public class ImagePerfUtils
{
  public static String toString(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return "unknown";
              }
              return "error";
            }
            return "canceled";
          }
          return "success";
        }
        return "intermediate_available";
      }
      return "origin_available";
    }
    return "requested";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\info\ImagePerfUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */