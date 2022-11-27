package dji.thirdparty.afinal.bitmap.core;

import android.graphics.Bitmap;

public abstract interface IMemoryCache
{
  public abstract void evictAll();
  
  public abstract Bitmap get(String paramString);
  
  public abstract void put(String paramString, Bitmap paramBitmap);
  
  public abstract void remove(String paramString);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\bitmap\core\IMemoryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */