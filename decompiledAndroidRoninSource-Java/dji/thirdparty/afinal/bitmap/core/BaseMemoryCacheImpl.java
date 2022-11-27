package dji.thirdparty.afinal.bitmap.core;

import android.graphics.Bitmap;
import dji.thirdparty.afinal.utils.Utils;

public class BaseMemoryCacheImpl
  implements IMemoryCache
{
  private final LruMemoryCache<String, Bitmap> mMemoryCache;
  
  public BaseMemoryCacheImpl(int paramInt)
  {
    this.mMemoryCache = new LruMemoryCache(paramInt)
    {
      protected int sizeOf(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        return Utils.getBitmapSize(paramAnonymousBitmap);
      }
    };
  }
  
  public void evictAll()
  {
    this.mMemoryCache.evictAll();
  }
  
  public Bitmap get(String paramString)
  {
    return null;
  }
  
  public void put(String paramString, Bitmap paramBitmap)
  {
    this.mMemoryCache.put(paramString, paramBitmap);
  }
  
  public void remove(String paramString)
  {
    this.mMemoryCache.remove(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\bitmap\core\BaseMemoryCacheImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */