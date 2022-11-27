package com.facebook.imagepipeline.image;

public abstract interface ImageInfo
  extends HasImageMetadata
{
  public abstract int getHeight();
  
  public abstract QualityInfo getQualityInfo();
  
  public abstract int getWidth();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\image\ImageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */