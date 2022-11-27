package com.facebook.imageutils;

import android.graphics.ColorSpace;
import android.util.Pair;
import javax.annotation.Nullable;

public class ImageMetaData
{
  @Nullable
  private final ColorSpace mColorSpace;
  @Nullable
  private final Pair<Integer, Integer> mDimensions;
  
  public ImageMetaData(int paramInt1, int paramInt2, @Nullable ColorSpace paramColorSpace)
  {
    Pair localPair;
    if ((paramInt1 != -1) && (paramInt2 != -1)) {
      localPair = new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    } else {
      localPair = null;
    }
    this.mDimensions = localPair;
    this.mColorSpace = paramColorSpace;
  }
  
  @Nullable
  public ColorSpace getColorSpace()
  {
    return this.mColorSpace;
  }
  
  @Nullable
  public Pair<Integer, Integer> getDimensions()
  {
    return this.mDimensions;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imageutils\ImageMetaData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */