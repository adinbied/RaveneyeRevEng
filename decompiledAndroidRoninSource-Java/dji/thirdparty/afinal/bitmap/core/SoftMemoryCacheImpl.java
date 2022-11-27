package dji.thirdparty.afinal.bitmap.core;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class SoftMemoryCacheImpl
  implements IMemoryCache
{
  private final HashMap<String, SoftReference<Bitmap>> mMemoryCache = new HashMap();
  
  public SoftMemoryCacheImpl(int paramInt) {}
  
  public void evictAll()
  {
    this.mMemoryCache.clear();
  }
  
  public Bitmap get(String paramString)
  {
    return null;
  }
  
  /* Error */
  public void put(String arg1, Bitmap arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void remove(String paramString)
  {
    this.mMemoryCache.remove(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\bitmap\core\SoftMemoryCacheImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */