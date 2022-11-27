package com.facebook.imagepipeline.image;

public class ImmutableQualityInfo
  implements QualityInfo
{
  public static final QualityInfo FULL_QUALITY = of(Integer.MAX_VALUE, true, true);
  boolean mIsOfFullQuality;
  boolean mIsOfGoodEnoughQuality;
  int mQuality;
  
  private ImmutableQualityInfo(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mQuality = paramInt;
    this.mIsOfGoodEnoughQuality = paramBoolean1;
    this.mIsOfFullQuality = paramBoolean2;
  }
  
  public static QualityInfo of(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new ImmutableQualityInfo(paramInt, paramBoolean1, paramBoolean2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ImmutableQualityInfo)) {
      return false;
    }
    paramObject = (ImmutableQualityInfo)paramObject;
    return (this.mQuality == ((ImmutableQualityInfo)paramObject).mQuality) && (this.mIsOfGoodEnoughQuality == ((ImmutableQualityInfo)paramObject).mIsOfGoodEnoughQuality) && (this.mIsOfFullQuality == ((ImmutableQualityInfo)paramObject).mIsOfFullQuality);
  }
  
  public int getQuality()
  {
    return this.mQuality;
  }
  
  public int hashCode()
  {
    int k = this.mQuality;
    boolean bool = this.mIsOfGoodEnoughQuality;
    int j = 0;
    int i;
    if (bool) {
      i = 4194304;
    } else {
      i = 0;
    }
    if (this.mIsOfFullQuality) {
      j = 8388608;
    }
    return k ^ i ^ j;
  }
  
  public boolean isOfFullQuality()
  {
    return this.mIsOfFullQuality;
  }
  
  public boolean isOfGoodEnoughQuality()
  {
    return this.mIsOfGoodEnoughQuality;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\image\ImmutableQualityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */