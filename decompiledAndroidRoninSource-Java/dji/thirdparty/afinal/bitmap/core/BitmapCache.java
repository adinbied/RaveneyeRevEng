package dji.thirdparty.afinal.bitmap.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;

public class BitmapCache
{
  private static final int DEFAULT_DISK_CACHE_COUNT = 10000;
  private static final boolean DEFAULT_DISK_CACHE_ENABLED = true;
  private static final int DEFAULT_DISK_CACHE_SIZE = 52428800;
  private static final boolean DEFAULT_MEM_CACHE_ENABLED = true;
  private static final int DEFAULT_MEM_CACHE_SIZE = 8388608;
  private ImageCacheParams mCacheParams;
  private DiskCache mDiskCache;
  private IMemoryCache mMemoryCache;
  
  public BitmapCache(ImageCacheParams paramImageCacheParams)
  {
    init(paramImageCacheParams);
  }
  
  /* Error */
  private void init(ImageCacheParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void addToDiskCache(String arg1, byte[] arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void addToMemoryCache(String arg1, Bitmap arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void clearCache()
  {
    clearMemoryCache();
    clearDiskCache();
  }
  
  public void clearCache(String paramString)
  {
    clearMemoryCache(paramString);
    clearDiskCache(paramString);
  }
  
  public void clearDiskCache()
  {
    DiskCache localDiskCache = this.mDiskCache;
    if (localDiskCache != null) {
      localDiskCache.delete();
    }
  }
  
  public void clearDiskCache(String paramString)
  {
    addToDiskCache(paramString, new byte[0]);
  }
  
  public void clearMemoryCache()
  {
    IMemoryCache localIMemoryCache = this.mMemoryCache;
    if (localIMemoryCache != null) {
      localIMemoryCache.evictAll();
    }
  }
  
  public void clearMemoryCache(String paramString)
  {
    IMemoryCache localIMemoryCache = this.mMemoryCache;
    if (localIMemoryCache != null) {
      localIMemoryCache.remove(paramString);
    }
  }
  
  public void close()
  {
    DiskCache localDiskCache = this.mDiskCache;
    if (localDiskCache != null) {
      localDiskCache.close();
    }
  }
  
  public Bitmap getBitmapFromMemoryCache(String paramString)
  {
    return null;
  }
  
  public boolean getImageData(String paramString, BytesBufferPool.BytesBuffer paramBytesBuffer)
  {
    return false;
  }
  
  public static class ImageCacheParams
  {
    public int diskCacheCount = 10000;
    public File diskCacheDir;
    public boolean diskCacheEnabled = true;
    public int diskCacheSize = 52428800;
    public int memCacheSize = 8388608;
    public boolean memoryCacheEnabled = true;
    public boolean recycleImmediately = true;
    
    public ImageCacheParams(File paramFile)
    {
      this.diskCacheDir = paramFile;
    }
    
    public ImageCacheParams(String paramString)
    {
      this.diskCacheDir = new File(paramString);
    }
    
    private static int getMemoryClass(Context paramContext)
    {
      return ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
    }
    
    public void setDiskCacheCount(int paramInt)
    {
      this.diskCacheCount = paramInt;
    }
    
    public void setDiskCacheSize(int paramInt)
    {
      this.diskCacheSize = paramInt;
    }
    
    public void setMemCacheSize(int paramInt)
    {
      this.memCacheSize = paramInt;
    }
    
    /* Error */
    public void setMemCacheSizePercent(Context arg1, float arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void setRecycleImmediately(boolean paramBoolean)
    {
      this.recycleImmediately = paramBoolean;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\bitmap\core\BitmapCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */