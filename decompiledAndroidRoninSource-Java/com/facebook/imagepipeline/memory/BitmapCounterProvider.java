package com.facebook.imagepipeline.memory;

public class BitmapCounterProvider
{
  private static final long KB = 1024L;
  public static final int MAX_BITMAP_TOTAL_SIZE = ;
  private static final long MB = 1048576L;
  private static volatile BitmapCounter sBitmapCounter;
  private static int sMaxBitmapCount = 384;
  
  public static BitmapCounter get()
  {
    if (sBitmapCounter == null) {
      try
      {
        if (sBitmapCounter == null) {
          sBitmapCounter = new BitmapCounter(sMaxBitmapCount, MAX_BITMAP_TOTAL_SIZE);
        }
      }
      finally {}
    }
    return sBitmapCounter;
  }
  
  private static int getMaxSizeHardCap()
  {
    int i = (int)Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
    if (i > 16777216L) {
      return i / 4 * 3;
    }
    return i / 2;
  }
  
  public static void initialize(BitmapCounterConfig paramBitmapCounterConfig)
  {
    if (sBitmapCounter == null)
    {
      sMaxBitmapCount = paramBitmapCounterConfig.getMaxBitmapCount();
      return;
    }
    throw new IllegalStateException("BitmapCounter has already been created! `BitmapCounterProvider.initialize(...)` should only be called before `BitmapCounterProvider.get()` or not at all!");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\BitmapCounterProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */