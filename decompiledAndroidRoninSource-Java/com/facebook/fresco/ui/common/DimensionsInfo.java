package com.facebook.fresco.ui.common;

public class DimensionsInfo
{
  private final int mDecodedImageHeight;
  private final int mDecodedImageWidth;
  private final int mEncodedImageHeight;
  private final int mEncodedImageWidth;
  private final String mScaleType;
  private final int mViewportHeight;
  private final int mViewportWidth;
  
  public DimensionsInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString)
  {
    this.mViewportWidth = paramInt1;
    this.mViewportHeight = paramInt2;
    this.mEncodedImageWidth = paramInt3;
    this.mEncodedImageHeight = paramInt4;
    this.mDecodedImageWidth = paramInt5;
    this.mDecodedImageHeight = paramInt6;
    this.mScaleType = paramString;
  }
  
  public int getDecodedImageHeight()
  {
    return this.mDecodedImageHeight;
  }
  
  public int getDecodedImageWidth()
  {
    return this.mDecodedImageWidth;
  }
  
  public int getEncodedImageHeight()
  {
    return this.mEncodedImageHeight;
  }
  
  public int getEncodedImageWidth()
  {
    return this.mEncodedImageWidth;
  }
  
  public String getScaleType()
  {
    return this.mScaleType;
  }
  
  public int getViewportHeight()
  {
    return this.mViewportHeight;
  }
  
  public int getViewportWidth()
  {
    return this.mViewportWidth;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DimensionsInfo{mViewportWidth=");
    localStringBuilder.append(this.mViewportWidth);
    localStringBuilder.append(", mViewportHeight=");
    localStringBuilder.append(this.mViewportHeight);
    localStringBuilder.append(", mEncodedImageWidth=");
    localStringBuilder.append(this.mEncodedImageWidth);
    localStringBuilder.append(", mEncodedImageHeight=");
    localStringBuilder.append(this.mEncodedImageHeight);
    localStringBuilder.append(", mDecodedImageWidth=");
    localStringBuilder.append(this.mDecodedImageWidth);
    localStringBuilder.append(", mDecodedImageHeight=");
    localStringBuilder.append(this.mDecodedImageHeight);
    localStringBuilder.append(", mScaleType='");
    localStringBuilder.append(this.mScaleType);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\fresc\\ui\common\DimensionsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */