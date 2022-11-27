package com.facebook.imagepipeline.memory;

public class BitmapCounterConfig
{
  public static final int DEFAULT_MAX_BITMAP_COUNT = 384;
  private int mMaxBitmapCount = 384;
  
  public BitmapCounterConfig(Builder paramBuilder)
  {
    this.mMaxBitmapCount = paramBuilder.getMaxBitmapCount();
  }
  
  public static Builder newBuilder()
  {
    return new Builder(null);
  }
  
  public int getMaxBitmapCount()
  {
    return this.mMaxBitmapCount;
  }
  
  public void setMaxBitmapCount(int paramInt)
  {
    this.mMaxBitmapCount = paramInt;
  }
  
  public static class Builder
  {
    private int mMaxBitmapCount = 384;
    
    public BitmapCounterConfig build()
    {
      return new BitmapCounterConfig(this);
    }
    
    public int getMaxBitmapCount()
    {
      return this.mMaxBitmapCount;
    }
    
    public Builder setMaxBitmapCount(int paramInt)
    {
      this.mMaxBitmapCount = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\BitmapCounterConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */