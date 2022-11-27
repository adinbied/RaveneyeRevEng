package com.facebook.imagepipeline.cache;

import android.os.Build.VERSION;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;

public class BitmapMemoryCacheTrimStrategy
  implements MemoryCache.CacheTrimStrategy
{
  private static final String TAG = "BitmapMemoryCacheTrimStrategy";
  
  public double getTrimRatio(MemoryTrimType paramMemoryTrimType)
  {
    int i = 1.$SwitchMap$com$facebook$common$memory$MemoryTrimType[paramMemoryTrimType.ordinal()];
    if (i != 1)
    {
      if ((i != 2) && (i != 3) && (i != 4) && (i != 5))
      {
        FLog.wtf("BitmapMemoryCacheTrimStrategy", "unknown trim type: %s", new Object[] { paramMemoryTrimType });
        return 0.0D;
      }
      return 1.0D;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      return MemoryTrimType.OnCloseToDalvikHeapLimit.getSuggestedTrimRatio();
    }
    return 0.0D;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\cache\BitmapMemoryCacheTrimStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */